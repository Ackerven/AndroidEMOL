package com.ackerven.adnroid.emol.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "diary", foreignKeys = [ForeignKey(
        entity = Moon::class, parentColumns = arrayOf("id"), childColumns = arrayOf("mood")
    )]
)
data class Diary(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var date: Date,
    @ColumnInfo(index = true) var mood: UUID,
    var title: String,
    var text: String,
    var isDelete: Boolean = false
)
