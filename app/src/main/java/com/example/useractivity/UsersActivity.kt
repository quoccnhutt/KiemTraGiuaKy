package com.example.useractivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        var db = DBHandling (this)
        btnRegister.setOnClickListener {
            var email = editEmail.text.toString()
            var tendangnhap  = editUsername.text.toString()
            if (editPassword.text.toString() == editPassword2.text.toString()){
                var password  = editPassword.text.toString()
                db.addUser(email, password, tendangnhap)
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show()

                val intent: Intent = Intent (this, activity_login::class.java)
                intent.putExtra("data1", tendangnhap)

                startActivity(intent)

            } else {
                Toast.makeText(this, "Password không trùng khớp", Toast.LENGTH_SHORT).show()
            }


        }
        



    }
}