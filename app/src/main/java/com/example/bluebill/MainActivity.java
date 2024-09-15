package com.example.bluebill;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText edtLeituraPassada, edtLeituraAtual;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLeituraPassada = findViewById(R.id.edtLeituraPassada);
        edtLeituraAtual = findViewById(R.id.edtLeituraAtual);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularConsumo();
            }
        });
    }

    private void calcularConsumo() {
        String leituraPassadaStr = edtLeituraPassada.getText().toString();
        String leituraAtualStr = edtLeituraAtual.getText().toString();

        // Validação de entrada
        if (TextUtils.isEmpty(leituraPassadaStr) || TextUtils.isEmpty(leituraAtualStr)) {
            Toast.makeText(this, "Preencha ambos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertendo para números
        double leituraPassada = Double.parseDouble(leituraPassadaStr);
        double leituraAtual = Double.parseDouble(leituraAtualStr);

        if (leituraAtual < leituraPassada) {
            Toast.makeText(this, "A leitura atual não pode ser menor que a leitura passada!", Toast.LENGTH_SHORT).show();
            return;
        }

        double consumo = leituraAtual - leituraPassada;
        double tarifa = 45; // Tarifa por metro cúbico
        double valorConsumo = consumo * tarifa;
        double taxaAluguer = 100; // Supondo uma taxa de aluguer fixa
        double iva = 0.16 * (valorConsumo + taxaAluguer); // IVA de 16%
        double totalAPagar = valorConsumo + taxaAluguer + iva;

        // Enviar os resultados para a nova Activity
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("consumo", consumo);
        intent.putExtra("valorConsumo", valorConsumo);
        intent.putExtra("totalAPagar", totalAPagar);
        startActivity(intent);
    }
}