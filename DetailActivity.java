package com.kelompok15.tracker.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvResult = findViewById(R.id.tvResult);

        MedicalRecord record =
                getIntent().getParcelableExtra("dataMedical");

        if(record != null){

            String hasil =
                    "Nama Pasien : " + record.getPatientName() +
                            "\nJenis Alat : " + record.getDeviceType() +
                            "\nNilai : " + record.getMeasurementValue() +
                            "\nStatus : " + record.getStatus();

            tvResult.setText(hasil);
        }
    }
}