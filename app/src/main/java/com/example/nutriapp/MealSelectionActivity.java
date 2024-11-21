package com.example.nutriapp;


import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MealSelectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_selection);

        // Referências aos botões
        Button breakfastButton = findViewById(R.id.breakfastButton);
        Button lunchButton = findViewById(R.id.lunchButton);
        Button snackButton = findViewById(R.id.snackButton);

        // Configurando os cliques nos botões
        breakfastButton.setOnClickListener(v -> sendMealChoice("Café da Manhã"));
        lunchButton.setOnClickListener(v -> sendMealChoice("Almoço"));
        snackButton.setOnClickListener(v -> sendMealChoice("Café da Tarde"));
    }

    // Método para enviar a escolha da refeição
    private void sendMealChoice(String meal) {
        Toast.makeText(this, "Você escolheu: " + meal, Toast.LENGTH_SHORT).show();

        // Configurando os detalhes do e-mail
        String recipientEmail = "cozinheiros@escola.com"; // Substitua pelo e-mail real
        String subject = "Relatório de Refeições";
        String body = "A refeição selecionada foi: " + meal;

        // Enviando o e-mail
        new Thread(() -> {
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(recipientEmail, subject, body);
        }).start();
    }
}