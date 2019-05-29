package com.raseeditask.data.addatastore.localstore

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raseeditask.data.adresponse.AdModel

@Dao
interface AdDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(adModelList: MutableList<AdModel>)

    @Query("select * from ad_table ")
    fun getAdAscendingOrder(): MutableList<AdModel>

}
