package com.juancarlosvidrio.aritmequiz;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class MultFragment extends Fragment {

    private Button boton_reg;
    private int num1;
    private int num2;
    private TextView num1txt;
    private TextView num2txt;
    private ImageButton boton_send;
    private int resp;
    private int score;
    private EditText resptxt;
    private TextView resprealtxt;
    private TextView scoretxtM;
    private Button continuarM;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_multiplicacion,container,false);
        Fragment fragment = new MenuFragment();
        num1 = (int) (Math.random() * 10) + 1;
        num2 = (int) (Math.random()*10)+1;
        resp = num1*num2;
        score=MainActivity.scorefinal ;
        num1txt= v.findViewById(R.id.num1_txtm);
        num1txt.setText(String.valueOf(num1));
        num2txt= v.findViewById(R.id.num2_txtm);
        num2txt.setText(String.valueOf(num2));
        boton_reg= v.findViewById(R.id.btn_regresarm);
        boton_send = v.findViewById(R.id.MsendBtn);
        resptxt= v.findViewById(R.id.respuesta_txtm);
        resprealtxt= v.findViewById(R.id.tvRespM);
        scoretxtM=v.findViewById(R.id.score_txtm);
        scoretxtM.setText(String.valueOf(score));
        continuarM= v.findViewById(R.id.btn_continuar);
        boton_reg.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
            }
        });
        boton_send.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (resp==(Integer.parseInt(String.valueOf(resptxt.getText())))){
                    score+=1;
                    scoretxtM.setText(String.valueOf(score));
                }
                resprealtxt.setText(String.valueOf(resp));
                boton_send.setEnabled(false);
                resptxt.setEnabled(false);
                MainActivity.scorefinal = score;
            }
        });
        continuarM.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                num1 = (int) (Math.random() * 10) + 1;
                num2 = (int) (Math.random()*10)+1;
                resp = num1*num2;
                num1txt.setText(String.valueOf(num1));
                num2txt.setText(String.valueOf(num2));
                boton_send.setEnabled(true);
                resptxt.setEnabled(true);
                resptxt.setText("");
                resprealtxt.setText("...");
            }
        });
        return v;
    }
}
