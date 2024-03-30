package com.canhptph44323.lab6_api;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView view;
    Button getdata;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            view = findViewById(R.id.view123);
            getdata = findViewById(R.id.btngui);
            getdata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VolleyFN volleyFN = new VolleyFN();
                    volleyFN.getAllDataFromAPI(context,view);
                }
            });
            return insets;
        });
    }
}