package com.radio.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    TextView scoreKeeperTextView;
    TextView equationTextView;
    TextView rightOrWrongTextView;
    GridLayout answerGrid;
    TextView choiceTextView1;
    TextView choiceTextView2;
    TextView choiceTextView3;
    TextView choiceTextView4;
    Button button;
    Button playAgainButton;
    int correctAnswers = 0;
    int totalAttempts = 0;
    int equationAnswer;
    int equationLeft = 0;
    int equationRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = (TextView) findViewById(R.id.timerTextView);
        scoreKeeperTextView = (TextView) findViewById(R.id.scoreKeeperTextView);
        equationTextView = (TextView) findViewById(R.id.equationTextView);
        rightOrWrongTextView = (TextView) findViewById(R.id.rightOrWrongTextView);
        answerGrid = (GridLayout)findViewById(R.id.answerGrid);
        choiceTextView1 = (TextView) findViewById(R.id.choiceTextView1);
        choiceTextView1.setOnClickListener(mGlobal_OnClickListener);
        choiceTextView2 = (TextView) findViewById(R.id.choiceTextView2);
        choiceTextView2.setOnClickListener(mGlobal_OnClickListener);
        choiceTextView3 = (TextView) findViewById(R.id.choiceTextView3);
        choiceTextView3.setOnClickListener(mGlobal_OnClickListener);
        choiceTextView4 = (TextView) findViewById(R.id.choiceTextView4);
        choiceTextView4.setOnClickListener(mGlobal_OnClickListener);
        button = (Button) findViewById(R.id.button);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
    }

    public void startGame(View view){
        timerTextView.setVisibility(View.VISIBLE);
        scoreKeeperTextView.setVisibility(View.VISIBLE);
        equationTextView.setVisibility(View.VISIBLE);
        rightOrWrongTextView.setVisibility(View.VISIBLE);
        answerGrid.setVisibility(View.VISIBLE);
        choiceTextView1.setVisibility(View.VISIBLE);
        choiceTextView2.setVisibility(View.VISIBLE);
        choiceTextView3.setVisibility(View.VISIBLE);
        choiceTextView4.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        generateProblem();
        gameTimer();
    }

    final View.OnClickListener mGlobal_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch(view.getId()){
                case R.id.choiceTextView1:
                    String a = choiceTextView1.getText().toString();
                    int value = Integer.parseInt(a);
                    checkAnswer(value);
                    break;
                case R.id.choiceTextView2:
                    a = choiceTextView2.getText().toString();
                    value = Integer.parseInt(a);
                    checkAnswer(value);
                    break;
                case R.id.choiceTextView3:
                    a = choiceTextView3.getText().toString();
                    value = Integer.parseInt(a);
                    checkAnswer(value);
                    break;
                case R.id.choiceTextView4:
                    a = choiceTextView4.getText().toString();
                    value = Integer.parseInt(a);
                    checkAnswer(value);
                    break;
            }
            totalAttempts++;
            scoreKeeperTextView.setText(correctAnswers + "/" + totalAttempts);
            generateProblem();
        }
    };

    public void restartGame(View view){
        choiceTextView1.setEnabled(true);
        choiceTextView2.setEnabled(true);
        choiceTextView3.setEnabled(true);
        choiceTextView4.setEnabled(true);
        playAgainButton.setVisibility(View.GONE);
        totalAttempts = 0;
        correctAnswers = 0;
        rightOrWrongTextView.setText("");
        generateProblem();
        gameTimer();
    }

    public void gameTimer(){
        new CountDownTimer(30000,1000){
            public void onTick(long milliseconds){
                timerTextView.setText(Long.toString(milliseconds/1000) + "s");
            }
            public void onFinish(){
                timerTextView.setText("0s");
                rightOrWrongTextView.setText("Your score is: " + correctAnswers + " out of: " + totalAttempts + ".");
                choiceTextView1.setEnabled(false);
                choiceTextView2.setEnabled(false);
                choiceTextView3.setEnabled(false);
                choiceTextView4.setEnabled(false);
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void generateProblem(){
        equationLeft = (int) (Math.random() * 50) + 1;
        equationRight = (int) (Math.random() * 50) + 1;
        equationTextView.setText(equationLeft + " + " + equationRight + " =");
        equationAnswer = equationLeft + equationRight;
        String answer = Integer.toString(equationAnswer);
        int a;
        String textA;
        int b;
        String textB;
        int c;
        String textC;

        int rand = (int) (Math.random() * 4) + 1;
        switch(rand) {
            case 1:
                choiceTextView1.setText(answer);
                a = (int) (Math.random() * 100) + 1;
                textA = Integer.toString(a);
                choiceTextView4.setText(textA);
                b = (int) (Math.random() * 100) + 1;
                textB = Integer.toString(b);
                choiceTextView2.setText(textB);
                c = (int) (Math.random() * 100) + 1;
                textC = Integer.toString(c);
                choiceTextView3.setText(textC);
                break;
            case 2:
                choiceTextView2.setText(answer);
                a = (int) (Math.random() * 100) + 1;
                textA = Integer.toString(a);
                choiceTextView4.setText(textA);
                b = (int) (Math.random() * 100) + 1;
                textB = Integer.toString(b);
                choiceTextView1.setText(textB);
                c = (int) (Math.random() * 100) + 1;
                textC = Integer.toString(c);
                choiceTextView3.setText(textC);
                break;
            case 3:
                choiceTextView3.setText(answer);
                a = (int) (Math.random() * 100) + 1;
                textA = Integer.toString(a);
                choiceTextView4.setText(textA);
                b = (int) (Math.random() * 100) + 1;
                textB = Integer.toString(b);
                choiceTextView2.setText(textB);
                c = (int) (Math.random() * 100) + 1;
                textC = Integer.toString(c);
                choiceTextView1.setText(textC);
                break;
            case 4:
                choiceTextView4.setText(answer);
                a = (int) (Math.random() * 100) + 1;
                textA = Integer.toString(a);
                choiceTextView1.setText(textA);
                b = (int) (Math.random() * 100) + 1;
                textB = Integer.toString(b);
                choiceTextView2.setText(textB);
                c = (int) (Math.random() * 100) + 1;
                textC = Integer.toString(c);
                choiceTextView3.setText(textC);
                break;
        }
    }

    public void checkAnswer(int value){
        if(value == equationAnswer){
            correctAnswers++;
            rightOrWrongTextView.setText("Correct!");
        } else if(value != equationAnswer){
            rightOrWrongTextView.setText("Wrong!");
        }
    }
}