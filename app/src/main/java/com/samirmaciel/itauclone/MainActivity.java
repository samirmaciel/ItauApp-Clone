package com.samirmaciel.itauclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewExpansivelTop;
    private CardView CardViewExpansivelBottom;
    private CardView cardViewCenter;
    private CardView cardViewContaTop;
    private CardView cardview;
    private CardView cardViewTransparente;
    private CardView cardViewAlternarconta;
    private EditText inputSenha;
    private ImageView btnExpandir2;

    private Button btnNum1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExpandir2 = findViewById(R.id.expandirInfos2);


        cardViewCenter = findViewById(R.id.cardViewCenter);
        cardview = findViewById(R.id.cardView);
        cardViewContaTop = findViewById(R.id.cardViewContaTop);
        cardViewExpansivelTop = findViewById(R.id.cardViewExpansivelTop);
        CardViewExpansivelBottom = findViewById(R.id.cardViewExpansivelBottom);
        cardViewTransparente = findViewById(R.id.cardViewTransparente);
        cardViewAlternarconta = findViewById(R.id.cardViewAlternarconta);
        inputSenha = findViewById(R.id.inputSenha);
        inputSenha.setTransformationMethod(new MyPasswordTransformationMethod());

        btnNum1 = findViewById(R.id.btnNum1);

        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSenha.append("5");
            }
        });


        inputSenha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                hideSoftKeyboard(MainActivity.this);
                return true;
            }
        });

        cardViewTransparente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(cardViewContaTop.getVisibility() == View.VISIBLE){
                    TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
                    cardViewContaTop.setVisibility(View.GONE);
                    cardViewAlternarconta.setVisibility(View.VISIBLE);
                    cardViewTransparente.setVisibility(View.VISIBLE);
                    cardViewCenter.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.VISIBLE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                }else{
                    TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
                    cardViewContaTop.setVisibility(View.VISIBLE);
                    cardViewTransparente.setVisibility(View.GONE);
                    cardViewAlternarconta.setVisibility(View.GONE);
                    cardViewCenter.setVisibility(View.GONE);
                    CardViewExpansivelBottom.setVisibility(View.GONE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                    btnExpandir2.setRotation(0);
                }

                Toast.makeText(getApplicationContext(), "Touch", Toast.LENGTH_SHORT).show();
            }
        });

        btnExpandir2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(cardViewContaTop.getVisibility() == View.VISIBLE){
                    TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
                    cardViewContaTop.setVisibility(View.GONE);
                    cardViewAlternarconta.setVisibility(View.VISIBLE);
                    cardViewTransparente.setVisibility(View.VISIBLE);
                    cardViewCenter.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.VISIBLE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                    btnExpandir2.setRotation(180);
                }else{
                    TransitionManager.beginDelayedTransition(cardview, new AutoTransition());
                    cardViewTransparente.setVisibility(View.GONE);
                    cardViewAlternarconta.setVisibility(View.GONE);
                    cardViewCenter.setVisibility(View.GONE);
                    cardViewContaTop.setVisibility(View.VISIBLE);
                    CardViewExpansivelBottom.setVisibility(View.GONE);
                    cardViewExpansivelTop.setVisibility(View.VISIBLE);
                    btnExpandir2.setRotation(0);
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

    public class MyPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;
            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }
            public char charAt(int index) {
                return '◯'; // This is the important part
            }
            public int length() {
                return mSource.length(); // Return default
            }
            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    };



}