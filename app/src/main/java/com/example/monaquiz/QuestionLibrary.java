package com.example.monaquiz;


import android.support.v7.app.AppCompatActivity;

public class QuestionLibrary extends AppCompatActivity {

//list of question
    private String mQuestion[] = {
            "Which is the only American state to begin with the letter 'p'?",
            "Name the world's biggest island",
            "In the children's book series, where is Paddington Bear originally from?",
            "A Way of Representing Information Using Only Two States:",
            "What is the capital city of Spain?",
            "What letter must appear at the beginning of the registration number of all non-military aircraft in the U.S.? ",
            "Which country is Prague in?",
        "Who delivered the less famous two-hour speech that preceded Abraham Lincoln's two-minute Gettysburg Address?",
        "(Nephelococcygia) is the practice of doing what?",
        "Which insect shorted out an early supercomputer and inspired the term (computer bug)?"

    };
//list of answers
    private String mChoices[][] = {
            { "Florida", "Main", "New York","Pennsylvania",},
            {"River Island", "Moon Island", "Greenland", "Blueland"},
            {"India", "Peru", "Canada","Iceland "},
            { "Protocol","Binary", "Binary Message", "Latence"},
            {"New York", "Madrid", "London", "Paris"},
            {"N","A", "U","L"},
            {"USA", "Czech Republic","UK", "France"},
        {"Wendell Phillips", "Danial Webster", "Robert G.", "Edward Everett"},
        {"Finding Shapes in cloud", "Sleeping with your eyes open", "Breaking glass with your voice", "Swimming in freezing water"},
        {"Roach","Moth", "Fly","Japanese beetle "},
    };
//check correct answer array
    public String mCorrectAnswers[] = {"Pennsylvania", "Greenland", "Canada", "Binary",  "Madrid", "N", "Czech Republic", "Danial Webster", "Finding Shapes in cloud","Fly"};

    public int getLength() {
        return mQuestion.length;
    }

//return question number
    public String getQuestion(int a) {
        String question = mQuestion[a];
        return question;

    }
//return first choice
    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }
    //return second choice
    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    //return thirs choice
    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }
    //return fourth choice
    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }


}
