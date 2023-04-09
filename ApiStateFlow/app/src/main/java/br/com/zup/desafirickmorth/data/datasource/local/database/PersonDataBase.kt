package br.com.zup.desafirickmorth.data.datasource.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.desafirickmorth.data.datasource.local.dao.PersonDao
import br.com.zup.desafirickmorth.data.model.PersonResult

@Database(entities = [PersonResult::class], version = 2)
abstract class PersonDataBase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        @Volatile
        private var INSTANCE: PersonDataBase? = null

        fun getDatabase(context: Context): PersonDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDataBase::class.java,
                    "person_data_base"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}