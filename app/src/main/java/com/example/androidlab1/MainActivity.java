package com.example.androidlab1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button greetButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetButton = findViewById(R.id.greetingButton);
        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText greetingText = findViewById(R.id.greetingTextarea);
                String greeting = greetingText.getText().toString();
                Intent intent = new Intent(MainActivity.this, GetNameActivity.class);
                intent.putExtra("greeting", greeting);
                startActivity(intent);
            }
        });

        TextView result = new TextView(MainActivity.this);
        Bundle parameters = getIntent().getExtras();
        if (parameters != null) {
            String greeting = parameters.get("greeting").toString();
            String name = parameters.get("name").toString();
            /*result.setText(greeting + name);
            setContentView(result);*/
            Toast.makeText(MainActivity.this, greeting + ", " + name + "!", Toast.LENGTH_SHORT).show();
        }
    }
}