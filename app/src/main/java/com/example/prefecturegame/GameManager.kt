package com.example.prefecturegame

class GameManager(val mainActivity: MainActivity) {
    var ternNumber : Int = 0
    val p1 = Player ()
    val p2 = Player ()
    var tern : Int = 0

    var exhibit : String = ""



    fun tern(selection : Int, p1:Player, p2:Player ){


        if(tern == 0){
            mainActivity.messageText1 = "どの都道府県で首都打倒を目指す？"
            mainActivity.buttonText1 = "北海道"
            mainActivity.buttonText2 = "青森県"
            mainActivity.buttonText3 = "高知県"
            mainActivity.buttonText4 = "島根県"
            mainActivity.buttonText5 = "長崎県"
            mainActivity.buttonText6 = "鹿児島県"

            mainActivity.buttonSet()
            mainActivity.messageSet1()
        }

        if(tern == 1 && selection in 1..6){
            p1.selectPref(selection)
            exhibitStatus(p1)
            mainActivity.statusText1p = exhibit//ステータスを表示する文字列を作る汎用の関数にp1の変数を渡して、文字列を1pステータス表示文字列の変数に代入してもらう。
            mainActivity.statusSetP1()//Mainクラスにある、Prefのステータスを表示する関数を呼び出す。
            mainActivity.messageText2 = "${p1.pref1.name}を選択しました."
            mainActivity.messageSet2()
            mainActivity.buttonReset()
            mainActivity.messageText1 = "敵が現れた！"
            mainActivity.messageSet1()
        }

        if(tern == 2){//コムの敵が自分じゃない都道府県を選択する。
            do {
                var comSelect: Int = (1..6).random()
                when (comSelect) {
                    1 -> p2.selectPref(1)
                    2 -> p2.selectPref(2)
                    3 -> p2.selectPref(3)
                    4 -> p2.selectPref(4)
                    5 -> p2.selectPref(5)
                    6 -> p2.selectPref(6)
                }
            }while(p1.pref1.name == p2.pref1.name)

            exhibitStatus(p2)
            mainActivity.statusText2p = exhibit//ステータスを表示する文字列を作る汎用の関数にp1の変数を渡して、文字列を1pステータス表示文字列の変数に代入してもらう。
            mainActivity.statusSetP2()//Mainクラスにある、Prefのステータスを表示する関数を呼び出す。
            mainActivity.messageText2 = "${p2.pref1.name}を選択しました."
            mainActivity.messageSet2()

        }



        if(tern % 3 == 0 ) {
            mainActivity.messageText1 = "${p1.pref1.name}は、どうする？"
            mainActivity.buttonText1 = "${p1.pref1.technique1.name}"
            mainActivity.buttonText2 = "${p1.pref1.technique2.name}"
            mainActivity.buttonText3 = "${p1.pref1.technique3.name}"
            mainActivity.buttonText4 = "500億円の軍事費を投入する"
            mainActivity.buttonText5 = "300億円の子育て支援策を実施する"
            mainActivity.buttonText6 = "100億円で感染症対策を実施する"
            mainActivity.buttonSet()
            mainActivity.messageSet1()
        }

        if(tern % 3 == 1 ) {
            when (selection){
                1 -> p1.pref1.technique1.executeTechnique()
                2 -> p1.pref1.technique2.executeTechnique()
            }
        }




    tern++
    }


    fun exhibitStatus(p:Player){//ステータスに表示する内容を変数exhibitに格納する。
        exhibit = "1P:${p.pref1.name}\n人口:${p.pref1.population}人" +
                "\n面積:${p.pref1.area}km2\n攻撃力:${p.pref1.atack}\n" +
                "防御力:${p.pref1.defence}"

    }






}