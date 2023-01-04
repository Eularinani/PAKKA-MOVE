 package com.example.pakkamove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;

 public class MainActivity extends AppCompatActivity {

     JSONArray arrayWeather = null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Criar um objeto do tipo DownloadTask
        LagacaoApi Api = new LagacaoApi();
        // Variável para guardar o resultado da task
        String RApi = null;
        try {
            //O codigo abaixo é para aguarda A uRL que é vindora da do servidor

        }
       TextView btn=findViewById(R.id.textViewSign);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivityregisto.class));
            }
        });
        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

       MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

       //user and password
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("pakka") && password.getText().toString().equals("move")){
                    //correct
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
            }else
                   //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
        }
        });
    }





 }