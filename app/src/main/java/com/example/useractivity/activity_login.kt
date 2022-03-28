package com.example.useractivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_thong_tin.*
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.activity_users.btnLogin

class activity_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var db = DBHandling (this)
        val intent = intent
        val tendangnhap : String = intent.getStringExtra("data1").toString()
        btnLogin3.setOnClickListener {
            var email = editEmail3.text.toString()
            var password  = editPassword3.text.toString()

            var ret = db.getUser(email, password, tendangnhap)
            if(ret) {
                Toast.makeText(this, "Thông tin chính xác", Toast.LENGTH_SHORT).show()



            } else {
                Toast.makeText(this, "Không hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}