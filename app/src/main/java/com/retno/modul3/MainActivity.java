package com.retno.modul3;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private String lifeCycle = "androidlifecycle";
    AutoCompleteTextView ac;
    EditText lv;
    String[] stringdatafak = {"Prodi Teknik Informatika", "Prodi Sistem Informasi", "Prodi Teknik Sipil", "Prodi Desain komunikasi Visual", "Prodi Manajemen Informatika"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        ac = findViewById(R.id.dataautocomplete);
        lv = findViewById(R.id.datalistview);

        // Set TextWatcher
        ac.addTextChangedListener(this);
    }

    public void pilihfakultas(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Fakultas Ilmu Komputer Universitas Kuningan");
        builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatafak[item]);
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Posisi lagi start", LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Posisi lagi stop ", LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Posisi lagi Resume", LENGTH_LONG).show();
        Log.i(lifeCycle, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Posisi lagi pause", LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearParent);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.bg_color_paused));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Posisi udah hancur", LENGTH_LONG).show();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}