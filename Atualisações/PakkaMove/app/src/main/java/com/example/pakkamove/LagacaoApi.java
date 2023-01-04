package com.example.pakkamove;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LagacaoApi extends AsyncTask<String, Void, JSONArray> {
    @Override
    protected JSONArray doInBackground(String... urls) {
        //Declaração de variaves
        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        String R ="Failed";
        try {
            // Criar a ligação
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            // Criar uma Stream para leitura de dados
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();
            while(data != -1)
            {
                char current = (char)data;
                result += current;
                data = reader.read();
            }

            JSONObject jsonObject = new JSONObject(result);
            //na linha abaixo é para mostrar a pasta ou melhor a parte do resulatado que vc quer buscar "nome"
            String weatherInfo = jsonObject.getString("");
            JSONArray arr = new JSONArray(weatherInfo);

            return arr;

        }catch (Exception e){
            e.printStackTrace();
            return R;
        }
    }
}
