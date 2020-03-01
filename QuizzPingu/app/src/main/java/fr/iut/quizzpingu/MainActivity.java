package fr.iut.quizzpingu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Button button_start = (Button) findViewById(R.id.main_button_start);

        button_start.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                MainActivity.score = 0;
                                                Intent myIntent = new Intent(MainActivity.this, QuestionActivity.class);
                                                startActivity(myIntent);
                                                myIntent = new Intent(MainActivity.this, SelectionActivity.class);
                                                startActivity(myIntent);
                                                myIntent = new Intent(MainActivity.this, CheckActivity.class);
                                                startActivity(myIntent);

                                                onPause();
                                            }
                                        }
        );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score : " + MainActivity.score);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score : " + MainActivity.score);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score : " + MainActivity.score);
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
}
