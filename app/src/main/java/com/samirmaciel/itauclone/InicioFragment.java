package com.samirmaciel.itauclone;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class InicioFragment extends Fragment {

    private ImageView iconExpandir;

    private CardView cardViewSaldo;
    private CardView cardViewValorSaldo;


    public InicioFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        iconExpandir = (ImageView) view.findViewById(R.id.iconSetaExpandir);
        cardViewSaldo = (CardView) view.findViewById(R.id.cardViewSaldo);
        cardViewValorSaldo = (CardView) view.findViewById(R.id.cardViewValorSaldo);

        iconExpandir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardViewValorSaldo.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewSaldo, new AutoTransition());
                    iconExpandir.animate().rotationX(180f).start();
                    cardViewValorSaldo.setVisibility(View.VISIBLE);

                }else{
                    TransitionManager.beginDelayedTransition(cardViewSaldo, new AutoTransition());
                    iconExpandir.animate().rotationX(0f).start();
                    cardViewValorSaldo.setVisibility(View.GONE);
                }
            }
        });




        return view;
    }
}