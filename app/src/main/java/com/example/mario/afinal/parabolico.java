package com.example.mario.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class parabolico extends AppCompatActivity {

    Button regreso;
    String A, T, O, V, D, r, re, r1;

    Double AA, TT, OO, VV, DD, rr, rrr, r11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parabolico);

        regreso = (Button) findViewById(R.id.regresar);

        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regreso = new Intent(parabolico.this, inicio.class);
                startActivity(regreso);
            }
        });
    }

    public void calcular(View view) {

        final TextView aa = (TextView) findViewById(R.id.a);
        final TextView tt = (TextView) findViewById(R.id.t);
        final TextView voo = (TextView) findViewById(R.id.vo);
        final TextView grad = (TextView) findViewById(R.id.grados);
        final TextView dd = (TextView) findViewById(R.id.di);


        A = aa.getText().toString();
        T = tt.getText().toString();
        O = grad.getText().toString();
        V = voo.getText().toString();
        D = dd.getText().toString();

        if (A.equals("")) {
            aa.setText("0");
            A = aa.getText().toString();
        }
        if (T.equals("")) {
            tt.setText("0");
            T = tt.getText().toString();
        }
        if (O.equals("")) {
            grad.setText("0");
            O = grad.getText().toString();
        }
        if (V.equals("")) {
            voo.setText("0");
            V = voo.getText().toString();
        }
        if (D.equals("")) {
            dd.setText("0");
            D = dd.getText().toString();
        }


        AA = Double.valueOf(A);
        TT = Double.valueOf(T);
        OO = Double.valueOf(O);
        VV = Double.valueOf(V);
        DD = Double.valueOf(D);


        if (VV != 0 && OO != 0) {
            rr = ((VV * VV) * Math.sin(2 * OO * 0.0174533)) / 9.8;
            re = String.valueOf(rr);


            rrr = ((2 * VV * (Math.sin((OO * 0.0174533))))) / 9.8;
            r = String.valueOf(rrr);


            r11 = (VV*VV)*((Math.sin(OO * 0.0174533))*(Math.sin(OO * 0.0174533)))/(2*9.8);
            r1 = String.valueOf(r11);

            aa.setText(r1);
            dd.setText(re);
            tt.setText(r);
            voo.setEnabled(false);
            grad.setEnabled(false);
        }
        if (OO !=0 && DD !=0 ){
            rr = (Math.sqrt((DD*9.8)/(2*(Math.sin((OO*Math.PI)/180))*Math.cos((OO*Math.PI)/180))));
            re = String.valueOf(rr);

            voo.setText(re);

            V = voo.getText().toString();
            VV = Double.valueOf(V);

            rrr = (2* VV*(Math.sin((OO*Math.PI)/180)))/(9.8);
            r = String.valueOf(rrr);

            tt.setText(r);

            r11 = (VV*VV)*((Math.sin((OO*Math.PI)/180))*(Math.sin((OO*Math.PI)/180)))/(2*9.8);
            r1 = String.valueOf(r11);

            aa.setText(r1);

            grad.setEnabled(false);
            dd.setEnabled(false);
        }


    }

    public void reset(View view) {
        final TextView aa = (TextView) findViewById(R.id.a);
        final TextView tt = (TextView) findViewById(R.id.t);
        final TextView voo = (TextView) findViewById(R.id.vo);
        final TextView vv = (TextView) findViewById(R.id.grados);
        final TextView dd = (TextView) findViewById(R.id.di);

        aa.setText("");
        tt.setText("");
        voo.setText("");
        vv.setText("");
        dd.setText("");

        aa.setEnabled(true);
        dd.setEnabled(true);
        voo.setEnabled(true);
        vv.setEnabled(true);
        tt.setEnabled(true);


    }
}