package com.example.mario.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mu;
    String A, T, Vo, V, D, r, re;
    Double AA, TT, VO, VV, DD, rr, rrr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mu = (Button) findViewById(R.id.regresar);

        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(MainActivity.this, inicio.class);
                startActivity(inicio);
            }
        });
    }

    public void calcular (View view){

        final TextView aa= (TextView) findViewById(R.id.a);
        final TextView tt= (TextView) findViewById(R.id.t);
        final TextView voo= (TextView) findViewById(R.id.vo);
        final TextView vv = (TextView) findViewById(R.id.grados);
        final TextView dd= (TextView) findViewById(R.id.di);


        A = aa.getText().toString();
        T = tt.getText().toString();
        Vo= voo.getText().toString();
        V = vv.getText().toString();
        D= dd.getText().toString();

        if (A.equals("")){
            aa.setText("0");
            A = aa.getText().toString();
        }
        if(T.equals("")) {
            tt.setText("0");
            T = tt.getText().toString();
        }
        if(Vo.equals("")) {
            voo.setText("0");
            Vo= voo.getText().toString();
        }
        if(V.equals("")) {
            vv.setText("0");
            V = vv.getText().toString();
        }
        if(D.equals("")) {
            dd.setText("0");
            D= dd.getText().toString();
        }

        AA = Double.valueOf(A);
        TT = Double.valueOf(T);
        VO = Double.valueOf(Vo);
        VV = Double.valueOf(V);
        DD = Double.valueOf(D);

        //formula para obtener aceleracion y movimiento
        if (VV!=0 && TT !=0 && VO !=0) {
            rr = (VV - VO) / TT;
            re = String.valueOf(rr);
            rrr= ((VV-VO)/2)*TT;
            r = String.valueOf(rrr);
            dd.setText(r);
            aa.setText(re);
            voo.setEnabled(false);
            vv.setEnabled(false);
            tt.setEnabled(false);

        }
        // formula para saber velocidad final y tiempo
        if (VO!=0 && AA !=0 && DD!=0){
            rr =Math.sqrt((VO*VO)+(2*AA*DD));
            re =String.valueOf(rr);
            rrr = (rr-VO)/AA;
            r = String.valueOf(rrr);

            tt.setText(r);
            vv.setText(re);
            voo.setEnabled(false);
            aa.setEnabled(false);
            dd.setEnabled(false);

        }
        //fornula para saber desplazamiento SIN aceleracion
        if (VO!=0 && TT!=0 && VV !=0){
            rrr = (VV - VO) / TT;
            r = String.valueOf(rrr);
            rr =(((VO+VV)/2)*TT);
            re = String.valueOf(rr);

            dd.setText(re);
            aa.setText(r);

            voo.setEnabled(false);
            tt.setEnabled(false);
            vv.setEnabled(false);
        }
        // formula para saber desplazamiento CON aceleracion
        if (VO != 0 && AA != 0 && TT != 0) {
            rr = ((VO*TT)+(0.5*AA*(TT*TT)));
            re = String.valueOf(rr);
            rrr =Math.sqrt((VO*VO)+(2*AA*rr));
            r = String.valueOf(rrr);

            dd.setText(re);
            vv.setText(r);

            voo.setEnabled(false);
            aa.setEnabled(false);
            tt.setEnabled(false);
        }
        if (TT != 0 && VO != 0 && DD != 0 ){
            rr = (((2*DD)/TT)-VO);
            re = String.valueOf(rr);
            vv.setText(re);

            V = vv.getText().toString();
            VV = Double.valueOf(V);

            rrr = (VV-VO)/TT;
            r = String.valueOf(rrr);
            aa.setText(r);

            tt.setEnabled(false);
            dd.setEnabled(false);
            voo.setEnabled(false);

        }
        // nuevos (se obtiene tiempo y aceleracion)
        if (VO!= 0 && VV != 0 && DD!= 0){
            rr = (2*DD)/(VV+VO);
            re = String.valueOf(rr);
            tt.setText(re);

            T = tt.getText().toString();
            TT = Double.valueOf(T);

            rrr = (VV-VO)/TT;
            r = String.valueOf(rrr);
            aa.setText(r);

            vv.setEnabled(false);
            dd.setEnabled(false);
            voo.setEnabled(false);
        }
        if (AA != 0 && VV != 0 && DD!= 0){
            rr =Math.sqrt((VV*VV)-(2*AA*DD));
            re =String.valueOf(rr);
            voo.setText(re);

            Vo = voo.getText().toString();
            VO = Double.valueOf(Vo);

            rrr = (VV-VO)/AA;
            r = String.valueOf(rrr);
            tt.setText(r);

            aa.setEnabled(false);
            dd.setEnabled(false);
            vv.setEnabled(false);
        }


        if (AA != 0 && VV != 0 && VO!= 0 ){
            rr = ((VV*VV)*(VO*VO))/(2*AA);
            re = String.valueOf(rr);
            dd.setText(re);

            D = dd.getText().toString();
            DD = Double.valueOf(D);

            rrr = (VV-VO)/AA;
            r = String.valueOf(rrr);
            tt.setText(r);

            vv.setEnabled(false);
            aa.setEnabled(false);
            voo.setEnabled(false);
        }
        if (AA != 0 && VV != 0 && VO!= 0 && DD!= 0){
            rr = (VV-VO)/AA;
            re = String.valueOf(rr);
            tt.setText(re);

            vv.setEnabled(false);
            aa.setEnabled(false);
            voo.setEnabled(false);
            dd.setEnabled(false);
        }
        if ( VV != 0 && DD!= 0 &&  TT!= 0){
            rr = ((2*DD)/TT)-VV;
            re = String.valueOf(rr);
            voo.setText(re);

            Vo = voo.getText().toString();
            VO = Double.valueOf(Vo);

            rrr = (VV-VO)/TT;
            r = String.valueOf(rrr);
            aa.setText(r);

            vv.setEnabled(false);
            dd.setEnabled(false);
            tt.setEnabled(false);

        }
        if (TT != 0 && VV != 0 && VO!= 0 && DD!= 0){
            rr = (VV-VO)/TT;
            re = String.valueOf(rr);

            aa.setText(re);

            vv.setEnabled(false);
            tt.setEnabled(false);
            voo.setEnabled(false);
            dd.setEnabled(false);
        }

        if (TT != 0 && AA!= 0 && DD!= 0){
            rr = (DD-(0.5*AA*(TT*TT)))/TT;
            re = String.valueOf(rr);
            voo.setText(re);

            Vo = voo.getText().toString();
            VO = Double.valueOf(Vo);

            rrr = (VO+(AA*TT));
            r = String.valueOf(rrr);
            vv.setText(r);

            aa.setEnabled(false);
            tt.setEnabled(false);
            dd.setEnabled(false);
        }



    }
    public void reset (View view){
        final TextView aa= (TextView) findViewById(R.id.a);
        final TextView tt= (TextView) findViewById(R.id.t);
        final TextView voo= (TextView) findViewById(R.id.vo);
        final TextView vv = (TextView) findViewById(R.id.grados);
        final TextView dd= (TextView) findViewById(R.id.di);

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