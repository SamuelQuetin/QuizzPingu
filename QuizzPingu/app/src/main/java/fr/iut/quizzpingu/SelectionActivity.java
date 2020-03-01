package fr.iut.quizzpingu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectionActivity extends Activity implements I_QuestionActivity {

    public Question question = null;
    public TextView txtQuestion = null;
    static List<Question> listquestion = null;
    private TextView textbar;
    private SeekBar bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(listquestion==null){
            listquestion = new ArrayList<Question>();
            listquestion.add(new Question("Combien y a t il de saisons de pingu?","6"));
            listquestion.add(new Question("Combien y a t il d'épisodes de pingu?","156"));
            listquestion.add(new Question("Combien de minutes dure un épisode?","5"));
            listquestion.add(new Question("Combien d'épisodes y a t-il dans chaque saison de pingu?","26"));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_layout);
        int rndIndexMax = new Random().nextInt(listquestion.size());
        question = listquestion.remove(rndIndexMax);
        txtQuestion = (TextView) findViewById(R.id.textView);
        bar = (SeekBar) findViewById(R.id.seekBar);
        textbar = (TextView) findViewById(R.id.textBar);
        Button valider = (Button) findViewById(R.id.valider);
        textbar.setText("Progress: " + bar.getProgress() + "/" + bar.getMax());
        txtQuestion.setText(question.getQuestion());
        if(Integer.parseInt(question.getBonneReponse())>10){
            bar.setMax(50);
        }
        if(Integer.parseInt(question.getBonneReponse())>50){
            bar.setMax(100);
        }
        if(Integer.parseInt(question.getBonneReponse())>100){
            bar.setMax(200);
        }
        if(!listquestion.isEmpty()){
            Intent myIntent = new Intent(SelectionActivity.this, SelectionActivity.class);
            startActivity(myIntent);
        }

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((bar.getProgress()+"").equals(question.getBonneReponse())){
                    MainActivity.score++;
                    changeBackground(Color.GREEN);
                }else{
                    changeBackground(Color.RED);
                }
                finish();
            }
        });

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar bar, int progressValue, boolean fromUser) {
                progress = progressValue;
                textbar.setText("Progress: " + progressValue + "/" + bar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                textbar.setText("Progress: " + progress + "/" + bar.getMax());
            }
            });


    }
    public void changeBackground(int changeColor){
        ConstraintLayout l = (ConstraintLayout) findViewById(R.id.selectionLayout);
        l.setBackgroundColor(changeColor);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listquestion = null;
    }
}
