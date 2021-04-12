package com.samirmaciel.itauclone.views.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.samirmaciel.itauclone.R;
import com.samirmaciel.itauclone.controllers.LoginController;

public class LoginActivity extends AppCompatActivity {

    private CardView cardViewExpansivelTop;
    private CardView CardViewExpansivelBottom;
    private CardView cardViewCenter;
    private CardView cardViewContaTop;
    private CardView cardviewTopBar;
    private CardView cardViewButtonsInput;
    private CardView cardViewTransparente;
    private CardView cardViewAlternarconta;
    private CardView cardViewinputs;
    private EditText inputSenha;
    private ImageView btnExpandirAppBar;
    private FrameLayout containerFrame;
    public Button btnAcessar;

    public Button btnNum1;
    public Button btnNum2;
    public Button btnNum3;
    public Button btnNum4;
    public Button btnNum5;

    private LoginController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        controller = new LoginController(this);

        btnExpandirAppBar = findViewById(R.id.arrowDownUp);

        cardViewButtonsInput = findViewById(R.id.cardViewButtons);
        cardViewCenter = findViewById(R.id.cardViewCenter);
        cardviewTopBar = findViewById(R.id.cardViewTopBar);
        cardViewContaTop = findViewById(R.id.cardViewContaTop);
        cardViewExpansivelTop = findViewById(R.id.cardViewExpansivelTop);
        CardViewExpansivelBottom = findViewById(R.id.cardViewExpansivelBottom);
        cardViewTransparente = findViewById(R.id.cardViewTransparente);
        cardViewAlternarconta = findViewById(R.id.cardViewAlternarconta);
        cardViewinputs = findViewById(R.id.cardViewInputs);
        inputSenha = findViewById(R.id.inputSenha);
        containerFrame = findViewById(R.id.container_frame);
        btnAcessar = findViewById(R.id.btnAcessar);

        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);

        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSenha.append("●");
            }
        });

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, TabMenuActivity.class));
            }
        });

        controller.numbersRandom();

        inputSenha.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(cardViewButtonsInput.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewinputs, new AutoTransition());
                    cardViewButtonsInput.setVisibility(View.VISIBLE);
                }
                hideSoftKeyboard(LoginActivity.this);
                return true;
            }
        });

        cardViewTransparente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(cardViewContaTop.getVisibility() == View.VISIBLE){
                    TransitionManager.beginDelayedTransition(cardviewTopBar, new AutoTransition().setDuration(50));
                    cardViewContaTop.setVisibility(View.GONE);
                    cardViewAlternarconta.setVisibility(View.VISIBLE);
                    TransitionManager.beginDelayedTransition(containerFrame, new AutoTransition());
                    cardViewTransparente.setVisibility(View.VISIBLE);
                    cardViewCenter.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.VISIBLE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                }else{
                    TransitionManager.beginDelayedTransition(cardviewTopBar, new AutoTransition());
                    cardViewContaTop.setVisibility(View.VISIBLE);
                    cardViewTransparente.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(containerFrame, new AutoTransition());
                    cardViewAlternarconta.setVisibility(View.GONE);
                    cardViewCenter.setVisibility(View.GONE);
                    CardViewExpansivelBottom.setVisibility(View.GONE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                    btnExpandirAppBar.animate().rotationX(0f).start();
                }
            }
        });

        btnExpandirAppBar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(cardViewContaTop.getVisibility() == View.VISIBLE){
                    TransitionManager.beginDelayedTransition(cardviewTopBar, new AutoTransition());
                    TransitionManager.beginDelayedTransition(containerFrame, new AutoTransition());
                    cardViewContaTop.setVisibility(View.GONE);
                    cardViewAlternarconta.setVisibility(View.VISIBLE);
                    cardViewTransparente.setVisibility(View.VISIBLE);
                    cardViewCenter.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.VISIBLE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                    btnExpandirAppBar.animate().rotationX(180f).start();
                }else{
                    TransitionManager.beginDelayedTransition(cardviewTopBar, new AutoTransition());
                    TransitionManager.beginDelayedTransition(containerFrame, new AutoTransition());
                    cardViewTransparente.setVisibility(View.GONE);
                    cardViewAlternarconta.setVisibility(View.GONE);
                    cardViewCenter.setVisibility(View.GONE);
                    cardViewContaTop.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.GONE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                    btnExpandirAppBar.animate().rotationX(0f).start();
                }
            }
        });
    }

    public void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}