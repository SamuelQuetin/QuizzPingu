package fr.iut.pinguquizz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionActivity extends Activity implements I_QuestionActivity {

    public TextView question;
    private static List<Question> listquestion = new ArrayList<Question>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(listquestion.isEmpty()){
            listquestion.add(new Question("Pingu est quel animal?","Manchot","Pungoin"));
            listquestion.add(new Question("Combien y a t il de saisons de pingu?","6","5"));
            listquestion.add(new Question("Combien y a t il d'épisodes de pingu?","156","169"));
            listquestion.add(new Question("Quel est le métier du papa de pingu?","Facteur","Pompier"));
            listquestion.add(new Question("Quel est le nom de la soeur de pingu?","Pinga","Rose"));

        }

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.question_layout);
        question = (TextView) findViewById(R.id.questionLabel);
        Button buttonLeft = (Button) findViewById(R.id.bouton_left);
        final Button buttonRight = (Button) findViewById(R.id.bouton_right);

        int rndIndexMax = new Random().nextInt(listquestion.size() + 1);
        final Question quest = listquestion.remove(rndIndexMax);
        question.setText(quest.getQuestion());
        if(new Random().nextInt(2) == 0) {
            buttonLeft.setText(quest.getBonneReponse());
            buttonRight.setText(quest.getMauvaiseReponse());
        }
        else {
            buttonRight.setText(quest.getBonneReponse());
            buttonLeft.setText(quest.getMauvaiseReponse());
        }

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()== R.id.bouton_left || v.getId()== R.id.bouton_right){
                    if(((Button)v).getText().equals(quest.getBonneReponse())) {
                        MainActivity.score++;
                        System.out.println("score :" + MainActivity.score);
                    }
                }
                finish();
            }
        };

        buttonLeft.setOnClickListener(buttonListener);
        buttonRight.setOnClickListener(buttonListener);
    }
}
