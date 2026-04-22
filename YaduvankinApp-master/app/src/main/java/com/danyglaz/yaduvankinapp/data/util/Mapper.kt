package com.danyglaz.yaduvankinapp.data.util

import com.danyglaz.yaduvankinapp.data.dto.GameItemDto
import com.danyglaz.yaduvankinapp.domain.model.GameItem
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun GameItemDto.toModel(): GameItem{
    return GameItem(
        id = id.toString(),
        ownerId = ownerId,
        title = title ?: "No Title",
        description = description ?: "no description",
        type = type ?: "no type",
        isNeedGame = false
    )
}

