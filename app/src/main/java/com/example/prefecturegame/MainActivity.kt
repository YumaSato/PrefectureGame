package com.example.prefecturegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val manage = GameManager(this)
        var elect : Int = 1

        button1.setOnClickListener(){
            elect = 1
        }
        button2.setOnClickListener(){
            elect = 2
        }
        button3.setOnClickListener(){
            elect = 3
        }
        button4.setOnClickListener(){
            elect = 4
        }
        button5.setOnClickListener() {
            elect = 5
        }
        button6.setOnClickListener() {
            elect = 6
        }
        nextButton.setOnClickListener() {
            manage.tern(elect, manage.p1, manage.p2)
        }





    }


    var buttonText1: String = ""
    var buttonText2: String = ""
    var buttonText3: String = ""
    var buttonText4: String = ""
    var buttonText5: String = ""
    var buttonText6: String = ""
    var statusText1p: String = ""
    var statusText2p: String = ""
    var messageText1: String = ""
    var messageText2: String = ""


    fun buttonSet() {//manage.tern関数内で変更されたボタンの文字を表示する関数。
        button1.text = buttonText1
        button2.text = buttonText2
        button3.text = buttonText3
        button4.text = buttonText4
        button5.text = buttonText5
        button6.text = buttonText6
    }

    fun buttonReset() {//ボタンの文字を全消し。
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
    }

    fun statusSetP1() {//manage.tern関数内で変更されたステータスの文字を表示する関数。
        prefStatus1.text = statusText1p
    }
    fun statusSetP2() {//manage.tern関数内で変更されたステータスの文字を表示する関数。
        prefStatus2.text = statusText2p
    }

    fun messageSet1(){
        message1.text = messageText1
    }

    fun messageSet2(){
        message2.text = messageText2
    }




}