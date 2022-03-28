package com.example.useractivity

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandling(context: Context) : SQLiteOpenHelper(context, "course.db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "CREATE TABLE users (email text primary key, password text, tendangnhap text)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun addUser(email: String, password: String, tendangnhap: String){
        var db = this.writableDatabase
        var values = ContentValues()
        values.put("email", email)
        values.put("password", password)
        values.put("tendangnhap", tendangnhap)

        db.insert("users", null, values)
    }

    fun getUser(email: String, password: String, tendangnhap: String) : Boolean {
        var db = this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM users WHERE email = ? AND password = ? AND tendangnhap = ?", arrayOf(email, password, tendangnhap))
        var ret = false
        if(cursor.count > 0) {
            ret  = true
        }
        return ret
    }

    fun showTT(email: String, password: String, tendangnhap: String){
        var db = this.readableDatabase
    }

}