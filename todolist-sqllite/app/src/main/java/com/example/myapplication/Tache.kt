package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taches")
data class Tache(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="title")val title: String,
    @ColumnInfo(name="description")val description: String,
//    @ColumnInfo(name="completed")val completed: Boolean? = false
)