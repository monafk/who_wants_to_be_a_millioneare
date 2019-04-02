package com.example.monaquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q9 extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    TextView mScoreView;
    TextView mQuestionView;
    RadioButton mButtonChoice1;
    RadioButton mButtonChoice2;
    RadioButton mButtonChoice3;
    RadioButton mButtonChoice4;
    Button confirm;

    private String mAnswer;
    private int mScore = 100000;
    private int mQuestionNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q9);
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (RadioButton) findViewById(R.id.choice1);
        mButtonChoice2 = (RadioButton) findViewById(R.id.choice2);
        mButtonChoice3 = (RadioButton) findViewById(R.id.choice3);
        mButtonChoice4 = (RadioButton) findViewById(R.id.choice4);

        confirm = (Button) findViewById(R.id.confirmAnswer);

        mScoreView.setText("You Earned: $" + 0);
        //updateQuestion();


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Q9.this);
                alertDialogBuilder
                        .setMessage("Are you sure you want to confirm this answer?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //check if the checked answer is correct or not
                                if (mButtonChoice1.isChecked() == true){
                                    if (mButtonChoice1.getText() == mAnswer) {
                                        mScore++;
                                        mScoreView.setText("You Earned: $" + mScore);
                                        Toast.makeText(Q9.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(Q9.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }
                                } else if (mButtonChoice2.isChecked() == true) {

                                    if (mButtonChoice2.getText() == mAnswer) {
                                        mScore++;
                                        mScoreView.setText("You Earned: $" + mScore);
                                        Toast.makeText(Q9.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(Q9.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }
                                } else if (mButtonChoice3.isChecked() == true) {
                                    if (mButtonChoice3.getText() == mAnswer) {
                                        mScore++;
                                        mScoreView.setText("You Earned: $" + mScore);
                                        Toast.makeText(Q9.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(Q9.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }
                                } else if (mQuestionLibrary.getLength() == 2|| mQuestionLibrary.getLength() == 5) {
                                    if (mButtonChoice4.isChecked()&& mButtonChoice1.isChecked()) {

                                        mScore++;
                                        mScoreView.setText("You Earned: $" + mScore);
                                        Toast.makeText(Q9.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(Q9.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }

                                } else {
                                    if (mButtonChoice4.isChecked() == true) {
                                        if (mButtonChoice4.getText() == mAnswer) {
                                            mScore++;
                                            mScoreView.setText("You Earned: $" + mScore);
                                            Toast.makeText(Q9.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                            updateQuestion();
                                        } else {
                                            Toast.makeText(Q9.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                            updateQuestion();
                                        }
                                    }
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {


                            }




                        }) .show();
            }
        });
        SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
        String newScore = mScoreView.getText().toString();
        //String PrintScore = preferences.getString(newScore+"data","");
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("You Earned: $",newScore);
        editor.commit();
        Intent intent = new Intent(Q9.this,Q10.class);
        startActivity(intent);
    }


    private void updateQuestion () {
        if (mQuestionNumber < mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else if(mScore==1000000){
                Toast.makeText(Q9.this, "Good Job! this is the last question :)", Toast.LENGTH_SHORT).show();

                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                String newScore = mScoreView.getText().toString();
                //String PrintScore = preferences.getString(newScore+"data","");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("You Earned: $",newScore);
                editor.commit();
                Intent intent = new Intent(Q9.this,win.class);
                startActivity(intent);}
            else {
                Intent intent = new Intent(Q9.this,lose.class);
                startActivity(intent);





        }
    }
}
