package com.samirmaciel.itauclone.views.fragments;

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
import android.widget.TextView;

import com.samirmaciel.itauclone.R;


public class InicioFragment extends Fragment {

    private ImageView iconExpandirSaldo;
    private ImageView iconExpandirCredito;

    private LinearLayout linearLayoutContainer;
    private CardView cardViewValorSaldo;
    private CardView cardViewValorCredito;

    private TextView expandirSaldo;
    private TextView expandirCredito;



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
        expandirCredito = (TextView) view.findViewById(R.id.textExpandirCredito);
        expandirSaldo = (TextView) view.findViewById(R.id.textExpandirSaldo);

        expandirSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardViewValorSaldo.getHeight() == 0){
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    iconExpandirSaldo.animate().rotationX(180f).start();
                    cardViewValorSaldo.getLayoutParams().height = 550;
                    expandirSaldo.setText("ocultar");

                }else{
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    cardViewValorSaldo.getLayoutParams().height = 0;
                    expandirSaldo.setText("expandir");
                    iconExpandirSaldo.animate().rotationX(0f).start();
                }
            }
        });

        expandirCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardViewValorCredito.getHeight() == 0){
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    iconExpandirCredito.animate().rotationX(180f).start();
                    cardViewValorCredito.getLayoutParams().height = 260;
                    expandirCredito.setText("ocultar");

                }else{
                    TransitionManager.beginDelayedTransition(linearLayoutContainer, new AutoTransition());
                    cardViewValorCredito.getLayoutParams().height = 0;
                    expandirCredito.setText("expandir");
                    iconExpandirCredito.animate().rotationX(0f).start();
                }
            }
        });



        return view;
    }
}