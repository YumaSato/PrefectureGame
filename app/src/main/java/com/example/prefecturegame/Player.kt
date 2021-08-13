package com.example.prefecturegame

class Player {
    var money : Int = 0
    val pref1 = Pref()
    var actionMessage : String = ""


    fun selectPref(selection : Int){
        when(selection){
            1 -> {
                pref1.name = "北海道"
                pref1.population = 5280000
                pref1.people = pref1.population
                pref1.area = 83450
                pref1.atack = 95
                pref1.defence = 35
                pref1.type = "大地"
                pref1.technique1.name = "なぐりつける"
                pref1.technique1.type = "普通"
                pref1.technique1.power = 100
                pref1.technique2.name = "地震"
                pref1.technique2.type = "大地"
                pref1.technique2.power = 70
                pref1.technique2.hitRate = 9
                pref1.technique3.name = "作物の恵み"
                pref1.technique3.type = "大地"
                pref1.technique3.recoverPeople = 600000

            }
            2 -> {
                pref1.name = "青森県"
                pref1.population = 1249000
                pref1.people = pref1.population
                pref1.area = 9649
                pref1.atack = 80
                pref1.defence = 80
                pref1.type = "植物"
                pref1.technique1.name = "なぐりつける"
                pref1.technique1.type = "普通"
                pref1.technique1.power = 100
                pref1.technique2.name = "倒木アタック"
                pref1.technique2.type = "植物"
                pref1.technique2.power = 80
                pref1.technique2.hitRate = 8
                pref1.technique3.name = "作物の恵み"
                pref1.technique3.type = "大地"
                pref1.technique3.recoverPeople = 600000

            }
            3 -> {
                pref1.name = "高知県"
                pref1.population = 759000
                pref1.people = pref1.population
                pref1.area = 7104
                pref1.atack = 90
                pref1.defence = 120
                pref1.type = "海洋"
                pref1.technique1.name = "なぐりつける"
                pref1.technique1.type = "普通"
                pref1.technique1.power = 100
                pref1.technique2.name = "潮風の錆"
                pref1.technique2.type = "海洋"
                pref1.technique2.power = 55
                pref1.technique3.name = "海鮮の恵み"
                pref1.technique3.type = "海洋"
                pref1.technique3.recoverPeople = 400000

            }
            4 -> {
                pref1.name = "島根県"
                pref1.population = 665000
                pref1.people = pref1.population
                pref1.area = 6708
                pref1.atack = 110
                pref1.defence = 130
                pref1.type = "神"
                pref1.technique1.name = "なぐりつける"
                pref1.technique1.type = "普通"
                pref1.technique1.power = 100
                pref1.technique2.name = "神話の風"
                pref1.technique2.type = "神"
                pref1.technique2.power = 65
                pref1.technique3.name = "海鮮の恵み"
                pref1.technique3.type = "海洋"
                pref1.technique3.recoverPeople = 400000

            }
            5 -> {
                pref1.name = "長崎県"
                pref1.population = 1314000
                pref1.people = pref1.population
                pref1.area = 4131
                pref1.atack = 140
                pref1.defence = 70
                pref1.type = "海洋"
                pref1.technique1.name = "なぐりつける"
                pref1.technique1.type = "普通"
                pref1.technique1.power = 100
                pref1.technique2.name = "潮風の錆"
                pref1.technique2.type = "海洋"
                pref1.technique2.power = 55
                pref1.technique3.name = "海鮮の恵み"
                pref1.technique3.type = "海洋"
                pref1.technique3.recoverPeople = 400000


            }
            6 -> {
                pref1.name = "鹿児島県"
                pref1.population = 1600000
                pref1.people = pref1.population
                pref1.area = 9187
                pref1.atack = 60
                pref1.defence = 120
                pref1.type = "火炎"
                pref1.technique1.name = "なぐりつける"
                pref1.technique1.type = "普通"
                pref1.technique1.power = 100
                pref1.technique2.name = "火山灰の雨"
                pref1.technique2.type = "火炎"
                pref1.technique2.power = 60
                pref1.technique3.name = "生物兵器ウイルス"
                pref1.technique3.type = "都会"
                pref1.technique3.recoverPeople = 400000

            }
        }
    }


    fun strengthenMilitary(){

    }

    fun increasePopulation(){

    }

    fun cureDisease(){

    }

}