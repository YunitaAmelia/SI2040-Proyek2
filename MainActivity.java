package com.example.huffaznote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText suratAwal;
    private EditText ayatAwal;
    private EditText suratAkhir;
    private EditText ayatAkhir;
    private Button lanjut;

    FirebaseAuth db = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        suratAwal = findViewById(R.id.surat_awal);
        ayatAwal = findViewById(R.id.ayat_awal);
        suratAkhir = findViewById(R.id.surat_akhir);
        ayatAkhir = findViewById(R.id.ayat_akhir);
        lanjut = findViewById(R.id.lanjut);

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surat_awal = suratAwal.getText().toString();
                String ayat_awal = ayatAwal.getText().toString();
                String surat_akhir = suratAkhir.getText().toString();
                String ayat_akhir = ayatAkhir.getText().toString();

                if (surat_awal.isEmpty()){
                    Toast.makeText(MainActivity.this, "Isi surat awal", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance().getReference().child("Surat awal :").setValue(surat_awal);
                }

                if (ayat_awal.isEmpty()){
                    Toast.makeText(MainActivity.this, "Isi ayat awal", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance().getReference().child("Ayat awal :").setValue(ayat_awal);
                }

                if (surat_akhir.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Isi surat akhir", Toast.LENGTH_SHORT).show();
                }else {
                    FirebaseDatabase.getInstance().getReference().child("Surat akhir :").setValue(surat_akhir);
                }

                if (ayat_akhir.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Isi ayat akhir", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance().getReference().child("Ayat akhir :").setValue(ayat_akhir);
                }


                startActivity(new Intent(MainActivity.this, Page.class));
                finish();
        }




    });



    }
}