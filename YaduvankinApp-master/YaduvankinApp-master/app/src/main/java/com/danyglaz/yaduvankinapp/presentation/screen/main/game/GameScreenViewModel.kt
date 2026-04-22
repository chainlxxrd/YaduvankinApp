package com.danyglaz.yaduvankinapp.presentation.screen.main.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.danyglaz.yaduvankinapp.data.repository.GamesRepository
import com.danyglaz.yaduvankinapp.domain.model.GameItem
import com.danyglaz.yaduvankinapp.presentation.navigation.Screen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel(assistedFactory = GameScreenViewModel.Factory::class)
class GameScreenViewModel @AssistedInject constructor(
    @Assisted val navigate: (Screen) -> Unit,
    private val gamesRepository: GamesRepository
):ViewModel() {
    private val _state = MutableStateFlow(GameScreenState())
    val state = _state.asStateFlow()
    private var games: List<GameItem> = emptyList()

    fun onEvent(event: GameScreenEvent){
        when(event){
            is GameScreenEvent.GameItemClicked -> TODO()
            is GameScreenEvent.SearchQueryChange -> onSearchQueryChanged(event.gameSearchQuery)
            is GameScreenEvent.GameItemNeedClicked -> onGameItemNeedClicked(event.gameItem)
        }
    }

    private fun onSearchQueryChanged(gameQuery: String){
        _state.update { it.copy(searchQuery = gameQuery) }

        viewModelScope.launch {
            _state.update { it.copy(filteredGame = filterGames(gameQuery, games)) }
        }

    }
    private fun onGameItemNeedClicked(gameItem: GameItem){
        val updateGame = state.value.filteredGame.map{
            if(it.id == gameItem.id) gameItem.copy(isNeedGame = !gameItem.isNeedGame)
            else it
        }
        _state.update { it.copy(filteredGame = updateGame) }
    }

    private fun loadGames() = viewModelScope.launch {
        val games = withContext(Dispatchers.IO){ gamesRepository.loadGames() }
        this@GameScreenViewModel.games = games
        _state.update { it.copy(filteredGame = filterGames(state.value.searchQuery, games)) }
    }

    private  suspend fun  filterGames(query: String, games: List<GameItem>): List<GameItem>{

         return withContext(Dispatchers.Default) {
             if(query.isEmpty()) games
             else  games.filter { it.title.contains(query) }
           }

    }
    init {
        loadGames()
    }
    @AssistedFactory
    interface  Factory{
        fun create(navigate:(Screen)->Unit): GameScreenViewModel
    }
}