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
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    TextView mScoreView;
    TextView mQuestionView;
    CheckBox mButtonChoice1;
    CheckBox mButtonChoice2;
    CheckBox mButtonChoice3;
    CheckBox mButtonChoice4;
    Button confirm;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (CheckBox) findViewById(R.id.choice1);
        mButtonChoice2 = (CheckBox) findViewById(R.id.choice2);
        mButtonChoice3 = (CheckBox) findViewById(R.id.choice3);
        mButtonChoice4 = (CheckBox) findViewById(R.id.choice4);

        confirm = (Button) findViewById(R.id.confirmAnswer);

        mScoreView.setText("You Earned: $" + mScore);
        updateQuestion();


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(quiz.this);
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
                                        Toast.makeText(quiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(quiz.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }
                                } else if (mButtonChoice2.isChecked() == true) {

                                    if (mButtonChoice2.getText() == mAnswer) {
                                        mScore++;
                                        mScoreView.setText("You Earned: $" + mScore);
                                        Toast.makeText(quiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(quiz.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }
                                } else if (mButtonChoice3.isChecked() == true) {
                                    if (mButtonChoice3.getText() == mAnswer) {
                                        mScore++;
                                        mScoreView.setText("You Earned: $" + mScore);
                                        Toast.makeText(quiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(quiz.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }
                                } else if (mQuestionLibrary.getLength() == 2|| mQuestionLibrary.getLength() == 5) {
                                    if (mButtonChoice4.isChecked()&& mButtonChoice1.isChecked()) {

                                        mScore++;
                                        mScoreView.setText("You Earned: $" + mScore);
                                        Toast.makeText(quiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    } else {
                                        Toast.makeText(quiz.this, "Wrong!", Toast.LENGTH_SHORT).show();
                                        updateQuestion();
                                    }

                                } else {
                                    if (mButtonChoice4.isChecked() == true) {
                                        if (mButtonChoice4.getText() == mAnswer) {
                                            mScore++;
                                            mScoreView.setText("You Earned: $ " + mScore);
                                            Toast.makeText(quiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                            updateQuestion();
                                        } else {
                                            Toast.makeText(quiz.this, "Wrong!", Toast.LENGTH_SHORT).show();
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
            } else if (mScore==1000000){

                    Toast.makeText(quiz.this, "Good Job! this is the last question :)", Toast.LENGTH_SHORT).show();

                    SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                    String newScore = mScoreView.getText().toString();
                    //String PrintScore = preferences.getString(newScore+"data","");
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("You Earned: $",newScore);
                    editor.commit();
                    Intent intent = new Intent(quiz.this,win.class);
                    startActivity(intent);}
                else {
                    Intent intent = new Intent(quiz.this,lose.class);
                    startActivity(intent);

                }

            }
        }









