package com.example.androidlab1;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GetNameActivity extends AppCompatActivity {
    Button nameButton;
    String greeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
        Bundle parameters = getIntent().getExtras();

        if (parameters != null) {
            greeting = parameters.get("greeting").toString();
            Toast.makeText(GetNameActivity.this, greeting, Toast.LENGTH_SHORT).show();
        }

        nameButton = findViewById(R.id.nameButton);
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameText = findViewById(R.id.nameTextarea);
                String name = nameText.getText().toString();
                Intent intent = new Intent(GetNameActivity.this, MainActivity.class);
                intent.putExtra("greeting", greeting);
                intent.putExtra("name", name);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

    }
}