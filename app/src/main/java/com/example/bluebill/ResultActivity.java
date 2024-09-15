package com.example.bluebill;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    private TextView txtConsumo, txtValorConsumo, txtTotalAPagar;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtConsumo = findViewById(R.id.txtConsumo);
        txtValorConsumo = findViewById(R.id.txtValorConsumo);
        txtTotalAPagar = findViewById(R.id.txtTotalAPagar);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Recebendo os valores da MainActivity
        Intent intent = getIntent();
        double consumo = intent.getDoubleExtra("consumo", 0);
        double valorConsumo = intent.getDoubleExtra("valorConsumo", 0);
        double totalAPagar = intent.getDoubleExtra("totalAPagar", 0);

        // Exibindo os valores
        txtConsumo.setText("Consumo: " + consumo + " m³");
        txtValorConsumo.setText("Valor Consumo: " + valorConsumo + " MT");
        txtTotalAPagar.setText("Total a Pagar: " + totalAPagar + " MT");

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retorna à MainActivity
                finish();
            }
        });
    }
}