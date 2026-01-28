package com.example.authapp.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TermsAndCondition",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TermsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userId: Int,
    val accept: Boolean,
    val date: String
)
