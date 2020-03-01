package fr.iut.pinguquizz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SelectionActivity extends Activity implements I_QuestionActivity {

    public Question question = null;
    public TextView txtQuestion = null;
    static List<Question> listquestion = new ArrayList<Question>();
    private TextView textbar;
    private SeekBar bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(listquestion.isEmpty()){
            listquestion.add(new Question("Combien y a t il de saisons de pingu?","6"));
            listquestion.add(new Question("Combien y a t il d'épisodes de pingu?","156"));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_layout);

        question = listquestion.remove(0);
        txtQuestion = (TextView) findViewById(R.id.textView);
        bar = (SeekBar) findViewById(R.id.seekBar);
        textbar = (TextView) findViewById(R.id.textBar);
        Button valider = (Button) findViewById(R.id.valider);
        textbar.setText("Progress: " + bar.getProgress() );
        txtQuestion.setText(question.getQuestion());

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((bar.getProgress()+"").equals(question.getBonneReponse())){
                    System.out.println("gg");
                    MainActivity.score++;
                }
            }
        });

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
