package com.samirmaciel.itauclone.controllers;

import android.widget.Button;

import com.samirmaciel.itauclone.views.activities.LoginActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LoginController {
    private LoginActivity view;

    public LoginController(LoginActivity view) {
        this.view = view;
    }

    public void numbersRandom(){
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
        /*for(int x = 0; x < 5; x++){

            int num1 = numbers.get(random.nextInt(numbers.size() + 1));
            numbers.remove(num1-1);
            int num2 = numbers.get(random.nextInt(numbers.size() + 1));
            numbers.remove(num2-1);
            buttons.get(x).setText(num1 + " ou " + num2);

        }*/
        

    }
}
