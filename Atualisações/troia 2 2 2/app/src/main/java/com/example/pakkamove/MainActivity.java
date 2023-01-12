 package com.example.pakkamove;

import static com.example.pakkamove.Constants.API_M_ESTADO;
import static com.example.pakkamove.Constants.HTTPS;
import static com.example.pakkamove.Constants.IP_LOCAL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

 public class MainActivity extends AppCompatActivity {

     JSONArray arrayusers = null;
     private ListView us;
     ArrayList<String>Listus;
     // Listview Adapter que irá proceder à conversão entre o array de strings e a lista
     ArrayAdapter<String> adapter;


     @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

         Listus = new ArrayList<>();
         info task = new info();
         try {
             arrayusers = task.execute(HTTPS+IP_LOCAL+API_M_ESTADO).get();
             Log.d("Osuarios_log: ", arrayusers.toString());
         }catch (ExecutionException e) {
             e.printStackTrace();

         } catch (InterruptedException e) {
             e.printStackTrace();

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
                    //Intent intent = new Intent(MainActivity.this, SearchBarMapasMainActivity.class);
                    Intent intent = new Intent(getApplicationContext(), tela_principal.class);
                    startActivity(intent);
            }else
                   //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
        }
        });
    }

    //registo


 }


