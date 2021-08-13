package com.example.prefecturegame

class Technique {
    var name : String = ""
    var type : String = ""
    var typeRatio : Int = 0
    var power : Int = 0
    var killPeople : Int = 0//定数ダメージ
    var recoverPeople : Int = 0
    var hitRate : Int = 0




    fun executeTechnique(prefOfMine : Pref, prefOfEnemy : Pref){//技が選択された時に実行される内容。




        if(power > 0 || killPeople > 0){//攻撃技の処理
            var hitting : Int = (1..10).random()//攻撃技を打って外れた場合の処理
            if(hitting > hitRate){
                killPeople = 0
            }else{
                if(killPeople == 0) {//定数ダメージ技じゃない時の処理
                    var randomRatio: Int = (80..100).random()
                    killPeople =
                        (prefOfMine.atack * power * typeRatio + 1 * randomRatio / 100) / prefOfEnemy.defence
                }
            }
            prefOfEnemy.people = prefOfEnemy.people - killPeople
        }


        if(recoverPeople > 0){//自己回復技の処理
            prefOfMine.people = prefOfMine.people + recoverPeople
            if(prefOfMine.people > prefOfMine.population){
                prefOfMine.people = prefOfMine.population
            }
        }

        if(name == "生物兵器ウイルス"){
            prefOfEnemy.illness = prefOfEnemy.illness + 2
        }


    }


    fun typeCompatibility(prefOfEnemy : Pref){
        when(prefOfEnemy.type) {
            "普通" -> when (type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1
                "火炎" -> typeRatio = 1
                "植物" -> typeRatio = 1
                "大地" -> typeRatio = 1
                "都会" -> typeRatio = 1
                "神" -> typeRatio = 1 / 2
            }

            "海洋" -> when (type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1 / 2
                "火炎" -> typeRatio = 2
                "植物" -> typeRatio = 1 / 2
                "大地" -> typeRatio = 2
                "都会" -> typeRatio = 1
                "神" -> typeRatio = 1 / 2
            }

            "火炎" -> when (type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1 / 2
                "火炎" -> typeRatio = 1 / 2
                "植物" -> typeRatio = 2
                "大地" -> typeRatio = 1
                "都会" -> typeRatio = 2
                "神" -> typeRatio = 1 / 2
            }

            "植物" -> when (type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 2
                "火炎" -> typeRatio = 1 / 2
                "植物" -> typeRatio = 1 / 2
                "大地" -> typeRatio = 2
                "都会" -> typeRatio = 1 / 2
                "神" -> typeRatio = 1
            }

            "大地" -> when (type) {
                "普通" -> typeRatio = 1
                "海洋" -> typeRatio = 1
                "火炎" -> typeRatio = 2
                "植物" -> typeRatio = 1 / 2
                "大地" -> typeRatio = 1
                "都会" -> typeRatio = 2
                "神" -> typeRatio = 1 / 2
            }

            "都会" -> when (type) {
                "普通" -> typeRatio = 2
                "海洋" -> typeRatio = 1 / 2
                "火炎" -> typeRatio = 1
                "植物" -> typeRatio = 2
                "大地" -> typeRatio = 1 / 2
                "都会" -> typeRatio = 1
                "神" -> typeRatio = 2
            }

            "神" -> when (type) {
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