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

    public CardView cardViewExpansivelTop;
    public CardView cardViewExpansivelBottom;
    public CardView cardViewCenter;
    public CardView cardViewContaTop;
    public CardView cardviewTopBar;
    public CardView cardViewButtonsInput;
    public CardView cardViewTransparente;
    public CardView cardViewAlternarconta;
    public CardView cardViewinputs;
    public EditText inputSenha;
    public ImageView btnExpandirAppBar;
    public FrameLayout containerFrame;
    public Button btnAcessar;

    public Button btnNum1;
    public Button btnNum2;
    public Button btnNum3;
    public Button btnNum4;
    public Button btnNum5;
    public Button btnBackSpace;

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
        cardViewExpansivelBottom = findViewById(R.id.cardViewExpansivelBottom);
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
        btnBackSpace = findViewById(R.id.btnBackspace);

        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSenha.append("●");
            }
        });

        btnNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSenha.append("●");
            }
        });

        btnNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSenha.append("●");
            }
        });

        btnNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSenha.append("●");
            }
        });

        btnNum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSenha.append("●");
            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inputSenhaSize = inputSenha.getText().toString().length();


            }
        });

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, TabMenuActivity.class));
            }
        });

        controller.numbersRandomKeyboard();

        inputSenha.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                controller.inputPassword();
                return true;
            }
        });

        cardViewTransparente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                controller.appBarScroll();
            }
        });

        btnExpandirAppBar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                controller.appBarScroll();
            }
        });
    }




}