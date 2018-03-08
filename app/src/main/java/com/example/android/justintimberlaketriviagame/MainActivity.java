
package com.example.android.justintimberlaketriviagame.;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.justintimberlaketriviagame.R;

public class MainActivity extends AppCompatActivity {

    int basescore = 0;
    String toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Gets answer for Question 1
     */
    public void getQ1Answer() {
        EditText questionOneAnswer = findViewById(R.id.question_1_answer);
        String cityName = questionOneAnswer.getText().toString();

        if (cityName.contains("Nashville")) {
            basescore++;
        } else {
            Toast.makeText(this, "The city you have named is incorrect. Try again.", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Gets answer for Question 2
     */
    public void getQ2Answers() {
        CheckBox silasCheckBox = findViewById(R.id.q2_option1);
        boolean isSilas = silasCheckBox.isChecked();

        CheckBox jessicaCheckBox = findViewById(R.id.q2_option2);
        boolean isJessica = jessicaCheckBox.isChecked();

        CheckBox jimmyCheckBox = findViewById(R.id.q2_option3);
        boolean isJimmy = jimmyCheckBox.isChecked();

        CheckBox jonathanCheckBox = findViewById(R.id.q2_option4);
        boolean isJonathan = jonathanCheckBox.isChecked();

        CheckBox lynnCheckBox = findViewById(R.id.q2_option5);
        boolean isLynn = lynnCheckBox.isChecked();

        CheckBox randyCheckBox = findViewById(R.id.q2_option6);
        boolean isRandy = randyCheckBox.isChecked();

        if (isJimmy) {
            Toast.makeText(this, "You have not selected the correct members of the family, try again", Toast.LENGTH_SHORT).show();
            return;
        }
        if (isSilas && isJessica && isJonathan && isLynn && isRandy) {
            basescore++;

        } else {
            Toast.makeText(this, "You have not selected the correct members of the family, try again", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * gets answer for Q3
     */
    public void getQ3answer() {

        RadioButton motwRadio = findViewById(R.id.q3_option4);
        boolean isMOTW = motwRadio.isChecked();

        if (isMOTW)
            basescore++;
        else {
            Toast.makeText(this, "You have not selected the correct album name", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * gets answer for Q4
     */
    public void getQ4answer() {
        RadioButton trueRadio = findViewById(R.id.q4_option2);
        boolean isTrue= trueRadio.isChecked();

        if (isTrue)
            basescore++;
        else {
            Toast.makeText(this, "You have answered question 4 incorrectly ", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Gets answer for Question 5
     */
    public void getQ5Answers() {
        CheckBox nstCheckBox = findViewById(R.id.q5_option1);
        boolean isNst = nstCheckBox.isChecked();

        CheckBox fslsCheckBox = findViewById(R.id.q5_option2);
        boolean isFsls = fslsCheckBox.isChecked();

        CheckBox celebrityCheckBox = findViewById(R.id.q5_option3);
        boolean isCelebrity = celebrityCheckBox.isChecked();

        CheckBox nsyncCheckBox = findViewById(R.id.q5_option4);
        boolean isNSYNC = nsyncCheckBox.isChecked();

        if (isNst && isCelebrity && isNSYNC) {
            basescore++;
        } else {
            Toast.makeText(this, "You incorrectly choosen Homer's occupations", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * establishes toast time and position
     */
    public void getToast() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    /**
     * Calls answer methods to get score and store
     * displays quiz results through toast
     */
    public void submitQuiz(View view) {
        getQ1Answer();
        getQ2Answers();
        getQ3answer();
        getQ4answer();
        getQ5Answers();
        toastMessage = "Your score is " + basescore + " out of 5 possible.";
        getToast();
    }
}
