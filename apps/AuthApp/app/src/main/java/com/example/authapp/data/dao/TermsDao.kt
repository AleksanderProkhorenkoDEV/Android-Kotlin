package com.example.authapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.authapp.data.entities.TermsEntity

@Dao
interface TermsDao {
    @Insert
    fun insert(terms: TermsEntity)
}