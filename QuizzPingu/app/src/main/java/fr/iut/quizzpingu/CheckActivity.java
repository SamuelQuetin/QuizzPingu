package fr.iut.quizzpingu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckActivity extends Activity implements I_QuestionActivity {
    public TextView textQuestion;
    static List<Question> listquestion = null;
    private Question question = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (listquestion == null) {
            listquestion = new ArrayList<Question>();
            ArrayList<String> badReponses = new ArrayList<String>();
            ArrayList<String> reponses = new ArrayList<String>();
            reponses.add("Ping");
            reponses.add("Pinga");
            reponses.add("Pingo");
            reponses.add("Pingi");
            listquestion.add(new Question("Quels personnages existent vraiment dans Pingu ?", reponses,badReponses));
            reponses = new ArrayList<String>();
            reponses.add("Pingu pollue");
            reponses.add("Pingu s'est battu");
            badReponses = new ArrayList<String>();
            badReponses.add("Pingu fait des danses fornites");
            badReponses.add("Pingu rejoint la mafia");
            listquestion.add(new Question("Quels titres d'épisodes de pingu existent ?", reponses,badReponses));
            reponses = new ArrayList<String>();
            reponses.add("Pingu sent le poisson");
            reponses.add("Pingu fait des bonds");
            reponses.add("Pingu fait la fête");
            badReponses = new ArrayList<String>();
            badReponses.add("Pingu aux jeux olympiques");
            listquestion.add(new Question("Quel titre de DVD de Pingu existent?", reponses,badReponses));
        }
        super.onCreate(savedInstanceState);

        setContentView(R.layout.check_layout);
        int rndIndexMax = new Random().nextInt(listquestion.size());
        question = listquestion.remove(rndIndexMax);
        Button valider = (Button) findViewById(R.id.valider);
        TextView textQuestion = (TextView) findViewById(R.id.textQuestion);
        final CheckBox reponseA = (CheckBox) findViewById(R.id.reponseA);
        final CheckBox reponseB = (CheckBox) findViewById(R.id.reponseB);
        final CheckBox reponseC = (CheckBox) findViewById(R.id.reponseC);
        final CheckBox reponseD = (CheckBox) findViewById(R.id.reponseD);
        ArrayList<String> reponses = new ArrayList<String>();
        textQuestion.setText(question.getQuestion());
        reponses.addAll(question.getBonnesReponses());
        reponses.addAll(question.getMauvaisesReponses());

        reponseA.setText(reponses.remove(new Random().nextInt(reponses.size())));
        reponseB.setText(reponses.remove(new Random().nextInt(reponses.size())));
        reponseC.setText(reponses.remove(new Random().nextInt(reponses.size())));
        reponseD.setText(reponses.remove(new Random().nextInt(reponses.size())));

        if(!listquestion.isEmpty()){
            Intent myIntent = new Intent(CheckActivity.this, CheckActivity.class);
            startActivity(myIntent);
        }
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()== R.id.valider){
                    List<String> trucValide = new ArrayList<String>();
                    if(reponseA.isChecked()){
                        trucValide.add((String) reponseA.getText());
                    }
                    if(reponseB.isChecked()){
                        trucValide.add((String) reponseB.getText());
                    }
                    if(reponseC.isChecked()){
                        trucValide.add((String) reponseC.getText());
                    }
                    if(reponseD.isChecked()){
                        trucValide.add((String) reponseD.getText());
                    }
                    if(trucValide.containsAll(question.getBonnesReponses()) && !trucValide.containsAll(question.getMauvaisesReponses())) {
                        MainActivity.score++;
                        changeBackground(Color.GREEN);
                    }else{
                        changeBackground(Color.RED);
                    }
                    finish();
                }
            }
        });

        if(listquestion.isEmpty()){
            listquestion=null;
        }
    }
    public void changeBackground(int changeColor){
        ConstraintLayout l = (ConstraintLayout) findViewById(R.id.check_layout);
        l.setBackgroundColor(changeColor);
    }
}
