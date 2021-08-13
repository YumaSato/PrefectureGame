package com.example.prefecturegame

import android.util.Log

class Technique {
    var name : String = ""
    var type : String = ""
    var typeRatio : Int = 1
    var power : Int = 0
    var killPeople : Int = 0//定数ダメージ
    var recoverPeople : Int = 0
    var hitRate : Int = 10//命中率1〜10割

    var techniqueMessage : String = ""






    fun executeTechnique(prefOfMine : Pref, prefOfEnemy : Pref){//技が選択された時に実行される内容。

        if(power > 0 || killPeople > 0){//攻撃技の処理
            var hitting : Int = (1..10).random()//攻撃技を打って外れた場合の処理
            if(hitting > hitRate){
                killPeople = 0
                techniqueMessage = "${name}は当たらなかった。"
            }else{
                if(killPeople == 0) {//定数ダメージ技じゃない時の処理
                    typeCompatibility(prefOfEnemy)
                    var randomRatio: Int = (80..100).random()
                    killPeople = (prefOfMine.atack * power * typeRatio * 8 * randomRatio + 300 )/ prefOfEnemy.defence
                    Log.d("killPeople", killPeople.toString())
                    if (typeRatio ==2){
                        techniqueMessage = "${name}は${prefOfEnemy.name}に効いているぞ！\n${killPeople}が瀕死になった。"
                    }
                    if (typeRatio ==1) {
                        techniqueMessage = "${killPeople}が瀕死になった。"
                    }
                    if (typeRatio ==1/2) {
                        techniqueMessage = "${name}は${prefOfEnemy.name}にあまり効いてないぞ！\n" +
                                "${killPeople}が瀕死になった。"
                    }

                }
            }
            prefOfEnemy.people = prefOfEnemy.people - killPeople
        }


        if(recoverPeople > 0){//自己回復技の処理
            prefOfMine.people = prefOfMine.people + recoverPeople
            techniqueMessage = "${prefOfMine.name}の${recoverPeople}人が回復した。"
            if(prefOfMine.people > prefOfMine.population){
                prefOfMine.people = prefOfMine.population
                techniqueMessage = "${prefOfMine.name}の住民は全員元気だ！。"

            }
        }

        if(name == "生物兵器ウイルス"){
            prefOfEnemy.illness = prefOfEnemy.illness + 2
            techniqueMessage = "${prefOfEnemy.name}の感染症危険度が${prefOfEnemy.illness}になった。"
        }


    }


    fun typeCompatibility(prefOfEnemy : Pref){
        when(type) {
            "普通" -> when (prefOfEnemy.type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1
                "火炎" -> typeRatio = 1
                "植物" -> typeRatio = 1
                "大地" -> typeRatio = 1
                "都会" -> typeRatio = 1
                "神" -> typeRatio = 1 / 2
            }

            "海洋" -> when (prefOfEnemy.type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1 / 2
                "火炎" -> typeRatio = 2
                "植物" -> typeRatio = 1 / 2
                "大地" -> typeRatio = 2
                "都会" -> typeRatio = 1
                "神" -> typeRatio = 1 / 2
            }

            "火炎" -> when (prefOfEnemy.type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1 / 2
                "火炎" -> typeRatio = 1 / 2
                "植物" -> typeRatio = 2
                "大地" -> typeRatio = 1
                "都会" -> typeRatio = 2
                "神" -> typeRatio = 1 / 2
            }

            "植物" -> when (prefOfEnemy.type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 2
                "火炎" -> typeRatio = 1 / 2
                "植物" -> typeRatio = 1 / 2
                "大地" -> typeRatio = 2
                "都会" -> typeRatio = 1 / 2
                "神" -> typeRatio = 1
            }

            "大地" -> when (prefOfEnemy.type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1
                "火炎" -> typeRatio = 2
                "植物" -> typeRatio = 1 / 2
                "大地" -> typeRatio = 1
                "都会" -> typeRatio = 2
                "神" -> typeRatio = 1 / 2
            }

            "都会" -> when (prefOfEnemy.type) {
                "普通" -> typeRatio = 2
                "海洋" -> typeRatio = 1 / 2
                "火炎" -> typeRatio = 1
                "植物" -> typeRatio = 2
                "大地" -> typeRatio = 1 / 2
                "都会" -> typeRatio = 1
                "神" -> typeRatio = 2
            }

            "神" -> when (prefOfEnemy.type) {
                "普通" -> typeRatio = 1 / 2
                "海洋" -> typeRatio = 2
                "火炎" -> typeRatio = 1
                "植物" -> typeRatio = 1 / 2
                "大地" -> typeRatio = 2
                "都会" -> typeRatio = 1
                "神" -> typeRatio = 1
            }
        }

    }
}