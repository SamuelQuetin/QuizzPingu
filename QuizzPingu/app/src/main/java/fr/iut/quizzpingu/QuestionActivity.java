package fr.iut.quizzpingu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionActivity extends Activity implements I_QuestionActivity {

    public TextView textQuestion;
    static List<Question> listquestion = null;
    private Question question= null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(listquestion == null){
            listquestion = new ArrayList<Question>();
            listquestion.add(new Question("Pingu est quel animal?","Manchot","Pungoin"));
            listquestion.add(new Question("Quel est le métier du papa de pingu?","Facteur","Pompier"));
            listquestion.add(new Question("Quel est le nom de la soeur de pingu?","Pinga","Rose"));
            listquestion.add(new Question("Qui est Bajoo?","Un homme des neiges","Un Otarie trop gentils"));
            listquestion.add(new Question("Quel est le nom de l'épisode 23 de la saison 4?","Pingu perd un pari","Pingu apprend à pecher"));
            listquestion.add(new Question("Quel personnage se révèle être diabolique dans l'épisode \"Un mariage avec Pingu\" ?","L'aspirateur","Un bonhomme de neige"));

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);
        textQuestion = (TextView) findViewById(R.id.questionLabel);
        Button buttonLeft = (Button) findViewById(R.id.bouton_left);
        Button buttonRight = (Button) findViewById(R.id.bouton_right);

        int rndIndexMax = new Random().nextInt(listquestion.size());
        question = listquestion.remove(rndIndexMax);

        if(!listquestion.isEmpty()){
            Intent myIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
            startActivity(myIntent);
        }

        textQuestion.setText(question.getQuestion());
        if(new Random().nextInt(2) == 0) {
            buttonLeft.setText(question.getBonneReponse());
            buttonRight.setText(question.getMauvaiseReponse());
        }
        else {
            buttonRight.setText(question.getBonneReponse());
            buttonLeft.setText(question.getMauvaiseReponse());
        }
        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()== R.id.bouton_left || v.getId()== R.id.bouton_right){
                    if(((Button)v).getText().equals(question.getBonneReponse())) {
                        MainActivity.score++;
                        changeBackground(Color.GREEN);
                    }else{
                        changeBackground(Color.RED);
                    }
                }
                finish();
            }
        };

        buttonLeft.setOnClickListener(buttonListener);
        buttonRight.setOnClickListener(buttonListener);

    }


    public void changeBackground(int changeColor){
        ConstraintLayout l = (ConstraintLayout) findViewById(R.id.questionLayout);
        l.setBackgroundColor(changeColor);
    }


}
