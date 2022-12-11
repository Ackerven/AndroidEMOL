package com.ackerven.adnroid.emol.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "moon")
data class Moon(@PrimaryKey val id: UUID = UUID.randomUUID(), var mood: String, val isDelete: Boolean = false)
