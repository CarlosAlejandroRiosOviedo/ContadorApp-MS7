package com.carlosalejandroriosoviedo.android.contadorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mCampoConteo;
    Button mBotonContar, mBotonReiniciar;
    Contador C = new Contador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampoConteo = (EditText) findViewById(R.id.CampoConteo);
        mBotonContar = (Button) findViewById(R.id.BotonContar);
        mBotonReiniciar = (Button) findViewById(R.id.BotonReiniciar);


        mBotonContar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Se suma uno al contador en cada ActionPerformed
                C.SetCuenta();
                int i = C.GetConteo();
                //Asignamos al EditText el conteo actual
                mCampoConteo.setText(Integer.toString(C.GetConteo()));
            }
        });

        mBotonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se asigna en 0 la variable contador en el metodo Contador.
                C.Reinicio();
                //Conteo actual = 0. Asignamos al EditText el conteo actual.
                mCampoConteo.setText(Integer.toString(C.GetConteo()));
            }
        });
    }

    public class Contador {
        private int contador;

        public void Iniciar(){
            this.contador = 0;
        }

        public void SetCuenta (){
            this.contador = this.contador +1;
        }
        public int GetConteo(){
            return this.contador;
        }
        public void Reinicio(){
            this.contador = 0;
        }
    }
}
