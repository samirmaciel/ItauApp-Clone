package com.samirmaciel.itauclone.controllers;

import android.app.Activity;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.samirmaciel.itauclone.views.activities.LoginActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LoginController {    private LoginActivity view;

    public LoginController(LoginActivity view) {
        this.view = view;
    }

    public void numbersRandomKeyboard(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        Random random = new Random();
        List<Button> buttons = Arrays.asList(new Button[]{
                view.btnNum1,
                view.btnNum2,
                view.btnNum3,
                view.btnNum4,
                view.btnNum5
        });
        for(int x = 0; x < 5; x++){

            int num1 = numbers.get(random.nextInt(numbers.size()));

            int count = 0;
            while(count < numbers.size()){
                if(numbers.get(count) == num1){
                    numbers.remove(count);
                    break;
                }
                count++;
            }
            int num2 = numbers.get(random.nextInt(numbers.size()));

            count = 0;
            while(count < numbers.size()){
                if(numbers.get(count) == num2){
                    numbers.remove(count);
                    break;
                }
                count++;
            }
            buttons.get(x).setText(num1 + " ou " + num2);
        }
    }

    public void appBarScroll(){

        if(view.cardViewContaTop.getVisibility() == View.VISIBLE){
            TransitionManager.beginDelayedTransition(view.cardviewTopBar, new AutoTransition());
            TransitionManager.beginDelayedTransition(view.containerFrame, new AutoTransition());
            view.cardViewContaTop.setVisibility(View.GONE);
            view.cardViewAlternarconta.setVisibility(View.VISIBLE);
            view.cardViewTransparente.setVisibility(View.VISIBLE);
            view.cardViewCenter.setVisibility(View.VISIBLE);
            view.cardViewExpansivelBottom.setVisibility(View.VISIBLE);
            view.cardViewExpansivelTop.setVisibility(View.VISIBLE);
            view.btnExpandirAppBar.animate().rotationX(180f).start();
        }else{
            TransitionManager.beginDelayedTransition(view.cardviewTopBar, new AutoTransition());
            TransitionManager.beginDelayedTransition(view.containerFrame, new AutoTransition());
            view.cardViewTransparente.setVisibility(View.GONE);
            view.cardViewAlternarconta.setVisibility(View.GONE);
            view.cardViewCenter.setVisibility(View.GONE);
            view.cardViewContaTop.setVisibility(View.VISIBLE);
            view.cardViewExpansivelBottom.setVisibility(View.GONE);
            view.cardViewExpansivelTop.setVisibility(View.VISIBLE);
            view.btnExpandirAppBar.animate().rotationX(0f).start();
        }
    }

    public void inputPassword(){

        if(view.cardViewButtonsInput.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(view.cardViewinputs, new AutoTransition());
            view.cardViewButtonsInput.setVisibility(View.VISIBLE);
        }
        hideSoftKeyboard(view);
    }

    private void hideSoftKeyboard(Activity activity) {
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
