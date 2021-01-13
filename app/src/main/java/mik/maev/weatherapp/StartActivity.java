package mik.maev.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
    private EditText edit_city;
    private Button btn_find_weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        edit_city = findViewById(R.id.city_edit);
        btn_find_weather = findViewById(R.id.btn_find_weather);

        btn_find_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_city.getText().toString().length() != 0){
                    SharedPreferences prefs = getSharedPreferences("City", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("city", edit_city.getText().toString());
                    editor.apply();
                    Intent intent = new Intent (StartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                }
            }
        });

    }
}