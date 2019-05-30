package com.raseeditask.data.addatastore.localstore

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raseeditask.data.adresponse.AdModel

/**
 *this class response for create database instance to can access DB and do Db operations
 *@paramc context:Context
 * @author  Abdo Gamal
 * @version 1.0
 * @since   29-5-2019
 */
@Database(entities = [AdModel::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun adDao(): AdDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        //here bild DB instance
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "AdDatabase.db"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}