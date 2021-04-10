package com.samirmaciel.itauclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private LinearLayout inicioLinearLayout;
    private LinearLayout extratoLinearLayout;
    private LinearLayout transacoesLinearLayout;
    private LinearLayout servicosLinearLayout;

    private TextView inicioText;
    private TextView extratoText;
    private TextView transacoesText;
    private TextView servicosText;

    private ImageView inicioIcon;
    private ImageView extratoIcon;
    private ImageView transacoesIcon;
    private ImageView servicosIcon;

    private int indexBottomNavigation = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inicioLinearLayout = findViewById(R.id.inicioLinearLayout);
        extratoLinearLayout = findViewById(R.id.extratoLinearLayout);
        transacoesLinearLayout = findViewById(R.id.transacoesBtn);
        servicosLinearLayout = findViewById(R.id.servicoLinearLayout);

        inicioText = findViewById(R.id.inicioText);
        extratoText = findViewById(R.id.extratoText);
        transacoesText = findViewById(R.id.textTransacoes);
        servicosText = findViewById(R.id.servicoText);

        inicioIcon = findViewById(R.id.inicioIcon);
        extratoIcon = findViewById(R.id.extratoIcon);
        transacoesIcon = findViewById(R.id.transacoesIcon);
        servicosIcon = findViewById(R.id.servicoIcon);


        itemSelected(R.drawable.ic_menu_home_selected,
                inicioIcon,
                inicioLinearLayout,
                inicioText);

        inicioLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexBottomNavigation != 1) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_container, new InicioFragment())
                            .commit();
                    itemUnselected(indexBottomNavigation);
                    itemSelected(R.drawable.ic_menu_home_selected,
                            inicioIcon,
                            inicioLinearLayout,
                            inicioText);
                    indexBottomNavigation = 1;
                }
            }
        });

        extratoLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexBottomNavigation != 2) {
                    itemUnselected(indexBottomNavigation);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_container, new ExtratoFragment())
                            .commit();
                    itemSelected(R.drawable.ic_menu_extrato_selected,
                            extratoIcon,
                            extratoLinearLayout,
                            extratoText);
                    indexBottomNavigation = 2;
                }
            }
        });


        transacoesLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexBottomNavigation != 3) {
                    itemUnselected(indexBottomNavigation);
                    itemSelected(R.drawable.ic_menu_transacoes_selected,
                            transacoesIcon,
                            transacoesLinearLayout,
                            transacoesText);
                    indexBottomNavigation = 3;
                }
            }
        });

        servicosLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexBottomNavigation != 4) {
                    itemUnselected(indexBottomNavigation);
                    itemSelected(R.drawable.ic_menu_servicos_selected,
                            servicosIcon,
                            servicosLinearLayout,
                            servicosText);
                    indexBottomNavigation = 4;
                }
            }
        });

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_container, new InicioFragment())
                    .commit();
        }
    }


    private void itemSelected(int resourceSelected, ImageView icon, LinearLayout btn, TextView text){

        icon.setImageResource(resourceSelected);
        icon.getLayoutParams().height = 140;
        icon.getLayoutParams().width = 140;
        icon.requestLayout();
        btn.setPadding(0, 20, 0, 0);
        text.setVisibility(View.GONE);
    }

    private void itemUnselected(int id){

        switch (id){
            case 1:
                inicioIcon.setImageResource(R.drawable.ic_menu_home);
                inicioIcon.getLayoutParams().height = 120;
                inicioIcon.getLayoutParams().width = 120;
                inicioLinearLayout.setPadding(0, 0, 0, 0);
                inicioText.setVisibility(View.VISIBLE);
            case 2:
                extratoIcon.setImageResource(R.drawable.ic_menu_extrato);
                extratoIcon.getLayoutParams().height = 120;
                extratoIcon.getLayoutParams().width = 120;
                extratoIcon.setMaxHeight(40);
                extratoLinearLayout.setPadding(0, 0, 0, 0);
                extratoText.setVisibility(View.VISIBLE);
            case 3:
                transacoesIcon.setImageResource(R.drawable.ic_menu_transacoes);
                transacoesIcon.getLayoutParams().height = 120;
                transacoesIcon.getLayoutParams().width = 120;
                transacoesLinearLayout.setPadding(0, 0, 0, 0);
                transacoesText.setVisibility(View.VISIBLE);
            case 4:
                servicosIcon.setImageResource(R.drawable.ic_menu_servicos);
                servicosIcon.getLayoutParams().height = 120;
                servicosIcon.getLayoutParams().width = 120;
                servicosLinearLayout.setPadding(0, 0, 0, 0);
                servicosText.setVisibility(View.VISIBLE);
        }
    }
}