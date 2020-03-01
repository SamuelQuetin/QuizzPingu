package fr.iut.quizzpingu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int score = 0;

    private ImageView wallpaper;

    private List<I_QuestionActivity> questionActivityList = new ArrayList<I_QuestionActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wallpaper = findViewById(R.id.main_imageview_wallpaper);

        TextView score = (TextView) findViewById(R.id.score);
        score.setVisibility(View.INVISIBLE);
        Button button_start = (Button) findViewById(R.id.main_button_start);

        button_start.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                MainActivity.score = 0;
                                                Intent myIntent = new Intent(MainActivity.this, QuestionActivity.class);
                                                startActivity(myIntent);

                                                for (int i = 0; i < QuestionActivity.listquestion.size(); i++) {
                                                    myIntent = new Intent(MainActivity.this, QuestionActivity.class);
                                                    startActivity(myIntent);
                                                }
                                                myIntent = new Intent(MainActivity.this, SelectionActivity.class);
                                                startActivity(myIntent);

                                                for (int i = 0; i < SelectionActivity.listquestion.size(); i++) {
                                                    myIntent = new Intent(MainActivity.this, SelectionActivity.class);
                                                    startActivity(myIntent);
                                                }
                                            }
                                        }
        );

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score : " + MainActivity.score);
        score.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score : " + MainActivity.score);
        super.onResume();
    }
}
