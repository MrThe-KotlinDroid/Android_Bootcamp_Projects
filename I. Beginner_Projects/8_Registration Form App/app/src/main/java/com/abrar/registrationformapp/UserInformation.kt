package com.abrar.registrationformapp

import java.io.Serializable

data class UserInformation(
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
): Serializable {

    fun getFullName() = "$title $firstName $lastName"

}
