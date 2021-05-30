package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var board: Array<Array<Button>>
    var PLAYER = true
    var TURN_COUNT = 0
    var boardstatus = Array(3) { IntArray(3) }
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var resetbtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var button3 = findViewById<Button>(R.id.button3)
        var button4 = findViewById<Button>(R.id.button4)
        var button5 = findViewById<Button>(R.id.button5)
        var button6 = findViewById<Button>(R.id.button6)
        var button7 = findViewById<Button>(R.id.button7)
        var button8 = findViewById<Button>(R.id.button8)
        var button9 = findViewById<Button>(R.id.button9)
        var resetbtn = findViewById<Button>(R.id.ResetBtn)
        var displayTv = findViewById<TextView>(R.id.displayTv)


        board = arrayOf(
            arrayOf(button1, button2, button3),
            arrayOf(button4, button5, button6),
            arrayOf(button7, button8, button9)
        )

        for (i: Array<Button> in board) {
            for (button: Button in i) {
                button.setOnClickListener(this)
            }
        }

        initializeBoardStatus()

        resetbtn.setOnClickListener {
            initializeBoardStatus()
            displayTv.text = "Player A Turn"
            PLAYER = true
            TURN_COUNT = 0
        }
    }

    private fun initializeBoardStatus() {

        for (i in 0..2) {
            for (j in 0..2) {
                boardstatus[i][j] = -1
            }
        }
        for (i: Array<Button> in board) {
            for (button: Button in i) {
                button.isEnabled = true
                button.text = ""
            }
        }

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button1 -> {
                updateValue(row = 0, col = 0, player = PLAYER)
            }
            R.id.button2 -> {
                updateValue(row = 0, col = 1, player = PLAYER)
            }
            R.id.button3 -> {
                updateValue(row = 0, col = 2, player = PLAYER)
            }
            R.id.button4 -> {
                updateValue(row = 1, col = 0, player = PLAYER)
            }
            R.id.button5 -> {
                updateValue(row = 1, col = 1, player = PLAYER)

            }
            R.id.button6 -> {
                updateValue(row = 1, col = 2, player = PLAYER)

            }
            R.id.button7 -> {
                updateValue(row = 2, col = 0, player = PLAYER)

            }
            R.id.button8 -> {
                updateValue(row = 2, col = 1, player = PLAYER)

            }
            R.id.button9 -> {
                updateValue(row = 2, col = 2, player = PLAYER)
            }
        }

        TURN_COUNT++
        PLAYER = !PLAYER
        if (PLAYER) {
            updateDisplay("Player A Turn")
        } else {
            updateDisplay("Player B Turn")
        }

        if (TURN_COUNT == 9) {
            updateDisplay("Game Draw")
        }

        CheckWinner()

    }

    private fun CheckWinner() {
        //Horizontal Rows
        for (i: Int in 0..2) {
            if (boardstatus[i][0] == boardstatus[i][1] && boardstatus[i][0] == boardstatus[i][2]) {
                if (boardstatus[i][0] == 1) {
                    updateDisplay("Player A is Winner")
                    break;
                } else if ((boardstatus[i][0] == 0)) {
                    updateDisplay("Player B is Winner")
                }
            }
        }

        //Vertical Columns
        for (i: Int in 0..2) {
            if (boardstatus[0][i] == boardstatus[1][i] && boardstatus[0][i] == boardstatus[2][i]) {
                if (boardstatus[0][i] == 1) {
                    updateDisplay("Player A is Winner")
                    break;
                } else if ((boardstatus[0][i] == 0)) {
                    updateDisplay("Player B is Winner")
                }
            }
        }

        //FirstDiagonal

        if (boardstatus[0][0] == boardstatus[1][1] && boardstatus[0][0] == boardstatus[2][2]) {
            if (boardstatus[0][0] == 1) {
                updateDisplay("Player A is Winner")
            } else if ((boardstatus[0][0] == 0)) {
                updateDisplay("Player B is Winner")
            }
        }

        //SecondDiagonal
        if (boardstatus[0][2] == boardstatus[1][1] && boardstatus[0][2] == boardstatus[2][0]) {
            if (boardstatus[0][2] == 1) {
                updateDisplay("Player A is Winner")
            } else if ((boardstatus[0][2] == 0)) {
                updateDisplay("Player B is Winner")
            }
        }


    }

    private fun disableButton() {
        for (i: Array<Button> in board) {
            for (button: Button in i) {
                button.isEnabled = false
            }
        }
    }

    private fun updateDisplay(s: String) {
        var displayTv = findViewById<TextView>(R.id.displayTv)
        displayTv.text = s
        if (s.contains("Winner")) {
            disableButton()
        }
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {

        val text: String = if (player) "A" else "B"
        val value: Int = if (player) 1 else 0

        board[row][col].apply {
            isEnabled = false
            setText(text)
        }
        boardstatus[row][col] = value
    }

}