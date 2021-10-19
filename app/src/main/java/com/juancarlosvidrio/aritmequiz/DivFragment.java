package com.juancarlosvidrio.aritmequiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DivFragment extends Fragment {

    private Button boton_reg;
    private int num1;
    private int num2;
    private TextView num1txt;
    private TextView num2txt;
    private double resp;
    private int score;
    private ImageButton boton_send;
    private EditText resptxt;
    private TextView resprealtxt;
    private TextView scoretxtD;
    private Button continuarD;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_division,container,false);
        Fragment fragment = new MenuFragment();
        num1 = (int) (Math.random() * 10) + 1;
        num2 = (int) (Math.random()*10)+1;
        resp =(double) Double.parseDouble(String.valueOf(num1))/Double.parseDouble(String.valueOf(num2));
        score=MainActivity.scorefinal ;
        // resp = (double)num1/num2;
        num1txt= v.findViewById(R.id.num1_txtd);
        num1txt.setText(String.valueOf(num1));
        num2txt= v.findViewById(R.id.num2_txtd);
        num2txt.setText(String.valueOf(num2));
        boton_reg= v.findViewById(R.id.btn_regresard);
        boton_send = v.findViewById(R.id.DsendBtn);
        resptxt = v.findViewById(R.id.respuesta_txtd);
        resprealtxt= v.findViewById(R.id.tvRespD);
        scoretxtD = v.findViewById(R.id.score_txtd);
        scoretxtD.setText(String.valueOf(score));
        continuarD= v.findViewById(R.id.btn_continuar2);
        boton_reg.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
            }
        });
        boton_send.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (resp==(Double.parseDouble(String.valueOf(resptxt.getText())))){
                    score+=1;
                    scoretxtD.setText(String.valueOf(score));
                }
                resprealtxt.setText(""+(double)resp);
                boton_send.setEnabled(false);
                resptxt.setEnabled(false);
                MainActivity.scorefinal = score;
            }
        });
        continuarD.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                num1 = (int) (Math.random() * 10) + 1;
                num2 = (int) (Math.random()*10)+1;

                resp =(double) Double.parseDouble(String.valueOf(num1))/Double.parseDouble(String.valueOf(num2));
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
