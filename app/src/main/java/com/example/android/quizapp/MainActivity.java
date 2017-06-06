package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        int score = 0;
        boolean q1 = false;
        boolean q2 = false;
        boolean q3 = false;
        boolean q4 = false;

        RadioGroup rdGrp = (RadioGroup) findViewById(R.id.monster_radiogroup);
        if (rdGrp.getCheckedRadioButtonId() == R.id.frankenstein_radiobutton) {
            score += 1;
            q1 = true;
        }

        EditText edtTxt = (EditText) findViewById(R.id.slipper_edittext);
        if (edtTxt.getText().toString().equalsIgnoreCase("Silver")) {
            score += 1;
            q2 = true;
        }

        CheckBox towerChkbx = (CheckBox) findViewById(R.id.two_tower_checkbox);
        CheckBox fellowshipChkbx = (CheckBox) findViewById(R.id.fellowship_checkbox);
        CheckBox phoenixChkbx = (CheckBox) findViewById(R.id.phoenix_checkbox);
        CheckBox kingChkbx = (CheckBox) findViewById(R.id.king_checkbox);
        if (towerChkbx.isChecked() && fellowshipChkbx.isChecked() && kingChkbx.isChecked() && !phoenixChkbx.isChecked()) {
            score += 1;
            q3 = true;
        }

        RadioGroup nameRdGrp = (RadioGroup) findViewById(R.id.first_name_radiogroup);
        if (nameRdGrp.getCheckedRadioButtonId() == R.id.thomas_radiobutton) {
            score += 1;
            q4 = true;
        }

        if (score == 4) {
            Toast.makeText(this, "Congrats. It's all right!", Toast.LENGTH_SHORT).show();
        } else {
            String response = "";
            ArrayList<Integer> wrongQuestions = new ArrayList<Integer>();
            if (!q1) {
                wrongQuestions.add(1);
            }
            if (!q2) {
                wrongQuestions.add(2);
            }
            if (!q3) {
                wrongQuestions.add(3);
            }
            if (!q4) {
                wrongQuestions.add(4);
            }
            if (wrongQuestions.size() > 2) {
                response += "Questions ";
                for (Integer qNumber : wrongQuestions) {
                    if (qNumber == wrongQuestions.get(wrongQuestions.size() - 1)) {
                        response += "and " + qNumber.toString();
                    } else {
                        response += qNumber.toString() + ", ";
                    }
                }
            } else if (wrongQuestions.size() == 2) {
                response += "Questions ";
                for (Integer qNumber : wrongQuestions) {
                    if (qNumber == wrongQuestions.get(wrongQuestions.size() - 1)) {
                        response += "and " + qNumber.toString();
                    } else {
                        response += qNumber.toString() + " ";
                    }
                }
            } else {
                response += "Question " + wrongQuestions.get(0);
            }
            response += " needs revision.";
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
        }
    }
}
