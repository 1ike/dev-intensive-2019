package ru.skillbranch.devintensive.models

import java.util.*


class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false
){
    constructor(userId: String, firstName: String?, lastName: String?) : this(
        id = userId,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    companion object  Factory {
        private var lastId : Int = -1

        fun makeUser(fullName:String) : User {
            lastId++

            val (firstName, lastName)  = Utils.parseFullName(fullName)

            return User(userId = "$lastId", firstName = firstName, lastName = lastName)
        }
    }
}