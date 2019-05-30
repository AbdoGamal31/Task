package com.raseeditask.data.addatastore.localstore

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable

/**
 * here operation on room database
 * @author  Abdo Gamal
 * @version 1.0
 * @since   29-5-2019
 */
@Dao
interface AdDao {
    /**
     * here insert list to database when the same item in the DB ignore it
     *@param MutableList<AdModel>
     * @author  Abdo Gamal
     * @version 1.0
     * @since   29-5-2019
     */

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(adModelList: MutableList<AdModel>)

    //here select all Ad from database
    @Query("select * from ad_table ")
    fun getAdAscendingOrder(): Observable<MutableList<AdModel>>

}
