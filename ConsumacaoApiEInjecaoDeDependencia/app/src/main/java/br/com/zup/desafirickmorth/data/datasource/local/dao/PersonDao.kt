package br.com.zup.desafirickmorth.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.desafirickmorth.data.model.PersonResult

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPersonDao(personResult: List<PersonResult>)
    @Query("SELECT * FROM person")
    suspend fun getAllPersonDao(): List<PersonResult>
}