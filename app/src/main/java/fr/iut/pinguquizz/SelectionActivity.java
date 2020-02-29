package fr.iut.pinguquizz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SelectionActivity extends Activity implements I_QuestionActivity {


    public TextView question = null;
    static List<Question> listquestion = new ArrayList<Question>();
    private TextView textbar;

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
        setContentView(R.layout.selection_layout);

        SeekBar bar = (SeekBar) findViewById(R.id.seekBar);
        textbar = (TextView) findViewById(R.id.textBar);
        textbar.setText("Progress: " + bar.getProgress() );

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                textbar.setText("Progress: " + progressValue + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textbar.setText("Progress: " + progress + "/" + seekBar.getMax());
            }
            });
    }
}
