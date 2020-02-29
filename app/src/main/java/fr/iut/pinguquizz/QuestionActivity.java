package fr.iut.pinguquizz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

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
            listquestion.add(new Question("Qui est Bajoo?","Un homme des neiges","Un Otarie trop gentils"));
            listquestion.add(new Question("Quel est le nom de l'épisode 23 de la saison 4?","Pingu perd un pari","Pingu apprend à pecher"));
            listquestion.add(new Question("Quel personnage se révèle être diabolique dans l'épisode \"Un mariage avec Pingu\" ?","L'aspirateur","Un bonhomme de neige"));

        }

        super.onCreate(savedInstanceState);
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

        ConstraintLayout l = (ConstraintLayout) findViewById(R.id.linearLayout);
        l.setBackgroundColor(Color.RED);

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
