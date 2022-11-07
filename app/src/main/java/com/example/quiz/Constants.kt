package com.example.quiz

object Constants {

    const val USER_NAME : String = "username"
    const val TOTAL_QUESTIONS : String = "total question"
    const val CORRECT_ANSWERS : String = "correct answers"

    fun getQuestion() : ArrayList<Question>{
        val questionsList =  ArrayList<Question>()
        val que1 = Question(
            1, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "이 국기는 어느 나라 국기입니까?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionsList.add(que10)

        questionsList.add(que10)

        val que11 = Question(
            11, "이 국기는 어느 나라 국기입니까?",
            R.drawable.japan162328640,
            "japan", "Jordan",
            "jambia", "joins", 1
        )

        questionsList.add(que11)

        val que12 = Question(
            12, "이 국기는 어느 나라 국기입니까?",
            R.drawable.southkorea162427640,
            "konbino", "korea",
            "kimchiland", "kokoaina", 2
        )

        questionsList.add(que12)

        val que13 = Question(
            13, "이 국기는 어느 나라 국기입니까?",
            R.drawable.turkishflag1774834_640,
            "Turkey", "Tukey",
            "Turkiye", "tokey", 3
        )

        questionsList.add(que13)



        return questionsList

    }
}