package com.samirmaciel.itauclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewExpansivelTop;
    private CardView CardViewExpansivelBottom;
    private CardView cardViewCenter;
    private CardView cardViewContaTop;
    private CardView cardview;
    private ImageView btnExpandir1;
    private ImageView btnExpandir2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExpandir1 = findViewById(R.id.expandirInfos1);
        btnExpandir2 = findViewById(R.id.expandirInfos2);


        cardViewCenter = findViewById(R.id.cardViewCenter);
        cardview = findViewById(R.id.cardView);
        cardViewContaTop = findViewById(R.id.cardViewContaTop);
        cardViewExpansivelTop = findViewById(R.id.cardViewExpansivelTop);
        CardViewExpansivelBottom = findViewById(R.id.cardViewExpansivelBottom);


        btnExpandir1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(cardViewExpansivelTop.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
                    cardViewContaTop.setVisibility(View.GONE);
                    cardViewCenter.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.VISIBLE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                }
            }
        });

        btnExpandir2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(cardViewExpansivelTop.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
                    cardViewCenter.setVisibility(View.GONE);
                    cardViewContaTop.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.GONE);
                    cardViewExpansivelTop.setVisibility(View.GONE);
                }
            }
        });



    }
}