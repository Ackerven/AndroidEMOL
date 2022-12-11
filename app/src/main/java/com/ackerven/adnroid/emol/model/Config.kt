package com.ackerven.adnroid.emol.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "config")
data class Config(@PrimaryKey val id: UUID = UUID.randomUUID(),
                  val status: Int = 0,
                  val password: String = "",
                  val isDelete: Boolean = false)
