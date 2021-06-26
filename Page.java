package com.example.huffaznote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Page extends AppCompatActivity {

    private Button tambah_bacaan;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        tambah_bacaan = findViewById(R.id.tambah_bacaan);
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Page.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Page.this, StartActivity.class));
            }
        });

        tambah_bacaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Page.this, MainActivity.class));
                finish();
            }
        });

    }
}