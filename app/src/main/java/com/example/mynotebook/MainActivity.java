package com.example.mynotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private TextView tvResult;
    private int counter = 0;
    private final static String KEY = "key"; //ключевое слово

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        //создание таблицы по ключевому слову
        pref = getSharedPreferences(KEY, MODE_PRIVATE);
        //показать сохраненное значение
        counter = pref.getInt(KEY, 0);
        //записать значение в таблицу
        tvResult.setText(String.valueOf(counter));
    }

    //метод увеличивающий счетчик на еденицу
    public void onClickAdd(View view) {
        counter++;
        //записать значение в таблицу
        tvResult.setText(String.valueOf(counter));
        saveData(counter);
    }
    //метод для сохранения данных
    private void saveData(int dataToSave){
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(KEY, dataToSave);
        editor.apply();
    }
}