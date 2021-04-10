package com.samirmaciel.itauclone;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;


public class InicioFragment extends Fragment {

    private ImageView iconExpandirSaldo;
    private ImageView iconExpandirCredito;

    private LinearLayout linearLayoutContainer;
    private CardView cardViewValorSaldo;
    private CardView cardViewValorCredito;



    public InicioFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        iconExpandirSaldo = (ImageView) view.findViewById(R.id.iconSetaExpandir);
        iconExpandirCredito = (ImageView) view.findViewById(R.id.iconSetaExpandirCredito);
        cardViewValorSaldo = (CardView) view.findViewById(R.id.cardViewValorSaldo);
        cardViewValorCredito = (CardView) view.findViewById(R.id.cardViewValorCredito);
        linearLayoutContainer = (LinearLayout) view.findViewById(R.id.linearLayoutContainer);

        iconExpandirSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardViewValorSaldo.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    iconExpandirSaldo.animate().rotationX(180f).start();
                    cardViewValorSaldo.setVisibility(View.VISIBLE);

                }else{
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    cardViewValorSaldo.setVisibility(View.GONE);
                    iconExpandirSaldo.animate().rotationX(0f).start();
                }
            }
        });

        iconExpandirCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardViewValorCredito.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    iconExpandirCredito.animate().rotationX(180f).start();
                    cardViewValorCredito.setVisibility(View.VISIBLE);

                }else{
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    cardViewValorCredito.setVisibility(View.GONE);
                    iconExpandirCredito.animate().rotationX(0f).start();
                }
            }
        });



        return view;
    }
}