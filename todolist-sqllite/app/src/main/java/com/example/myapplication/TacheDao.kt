package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//class TacheDao {
//}

@Dao
interface TacheDao {
    @Query("SELECT * FROM taches")
    fun getAll(): LiveData<List<Tache>>
//    fun getAll(): List<Tache>

//    fun getAll(): LiveData<List<myData>>

    /* @Query("SELECT * FROM student_table WHERE uid IN (:userIds)")
     fun loadAllByIds(userIds: IntArray): List<Student>*/

    @Query("SELECT * FROM taches WHERE id LIKE :idt LIMIT 1")
    fun findByRoll(idt: Int): Tache

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tache: Tache)

    @Delete
    fun delete(tache: Tache)

    @Query("DELETE FROM taches")
    fun deleteAll()
}