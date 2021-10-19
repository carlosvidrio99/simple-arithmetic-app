package com.juancarlosvidrio.aritmequiz;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private Button boton_mult;
    private Button boton_div;
    private Button boton_resta;
    private Button boton_suma;
    private Button boton_salir;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_menu,container,false);
        Fragment fragment = new MultFragment();
        Fragment fragment2 = new DivFragment();
        Fragment fragment3 = new RestFragment();
        Fragment fragment4 = new SumaFragment();
        boton_mult= v.findViewById(R.id.btn_mult);
        boton_div= v.findViewById(R.id.btn_div);
        boton_resta= v.findViewById(R.id.btn_resta);
        boton_suma= v.findViewById(R.id.btn_suma);
        boton_salir= v.findViewById(R.id.salir_btn);
        boton_mult.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
            }
        });
        boton_div.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment2).addToBackStack(null).commit();
            }
        });
        boton_resta.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment3).addToBackStack(null).commit();
            }
        });
        boton_suma.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment4).addToBackStack(null).commit();
            }
        });
        boton_salir.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                System.exit(0);
            }
        });
        return v;
    }
}
