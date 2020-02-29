package fr.iut.pinguquizz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static int score = 0;

    private ImageView wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wallpaper = findViewById(R.id.main_imageview_wallpaper);

        TextView score = (TextView) findViewById(R.id.score);
        score.setVisibility(View.INVISIBLE);
        final Button button_start = (Button) findViewById(R.id.main_button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                MainActivity.score = 0;
                                                for (int i = 0; i < 1
                                                        ; i++) {
                                                    Intent myIntent = new Intent(MainActivity.this, SelectionActivity.class);
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
        score.setText("Score : "+MainActivity.score);
        score.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score : "+MainActivity.score);
        super.onResume();
    }
}
