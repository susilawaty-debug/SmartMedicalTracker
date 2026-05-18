package com.kelompok15.tracker.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etValue;
    RadioGroup radioGroup;
    Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etValue = findViewById(R.id.etValue);
        radioGroup = findViewById(R.id.radioGroup);
        btnProcess = findViewById(R.id.btnProcess);

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String valueStr = etValue.getText().toString().trim();

                if (name.isEmpty() || valueStr.isEmpty()
                        || radioGroup.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(MainActivity.this,
                            "Semua input wajib diisi",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                double value = Double.parseDouble(valueStr);

                RadioButton selectedRadio =
                        findViewById(radioGroup.getCheckedRadioButtonId());

                String device = selectedRadio.getText().toString();

                String status = "Normal";

                if (device.equals("Termometer Digital") && value > 37.5) {
                    status = "Anomali";
                } else if (device.equals("Oksimeter") && value < 95) {
                    status = "Anomali";
                } else if (device.equals("Tensimeter") && value > 130) {
                    status = "Anomali";
                }

                MedicalRecord record =
                        new MedicalRecord(name, device, value, status);

                Log.d("DEBUGA_MEDICAL_APP",
                        "Nama: " + name +
                                ", Device: " + device +
                                ", Value: " + value +
                                ", Status: " + status);

                Intent intent =
                        new Intent(MainActivity.this,
                                DetailActivity.class);

                intent.putExtra("dataMedical", record);

                startActivity(intent);
            }
        });
    }
}