package com.danyglaz.yaduvankinapp.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.danyglaz.yaduvankinapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.danyglaz.yaduvankinapp.domain.model.GameItem
import com.danyglaz.yaduvankinapp.presentation.ui.theme.Grey
import com.danyglaz.yaduvankinapp.presentation.ui.theme.YaduvankinAppTheme


@Composable
fun GamesItem(
    modifier: Modifier = Modifier,
    gameItem: GameItem,
    onNeedGameClicked:() ->Unit,
    onReadClicked:() -> Unit
){
    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = gameItem.title,
                    fontSize = 22.sp

                )
                IconButton(
                    onClick = onNeedGameClicked
                ) {
                    Icon(
                        imageVector = if(gameItem.isNeedGame)Icons.Default.CheckCircle
                        else Icons.Outlined.Check,
                        contentDescription = "Просмотренно"
                    )
                }
            }

            Text(
                text = gameItem.description,
                maxLines = 3,
                fontSize = 18.sp
            )
            Text(
                text = gameItem.type,
                maxLines = 3,
                fontSize = 14.sp
            )
            StyledButton(
                onClick = onReadClicked
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = stringResource(R.string.view))
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "Посмотреть игру"
                    )
                }
            }
        }


    }
}

@Preview
@Composable
fun GameItemPreview(){
    YaduvankinAppTheme {
        GamesItem(
            gameItem = GameItem(
                id = "1",
                ownerId = 1,
                title = "Dota2",
                description = "play for me",
                type = "role",
                isNeedGame = true
            ),
            onNeedGameClicked = {},
            onReadClicked = {},
        )
    }
}

