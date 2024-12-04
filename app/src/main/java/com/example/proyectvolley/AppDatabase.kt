package com.example.proyectvolley

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Partido:: class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun partidoDao(): PartidoDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "partido_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}