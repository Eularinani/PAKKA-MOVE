package com.example.pakkamove;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class info extends AsyncTask<String, Void, JSONArray> {

    @Override
    protected JSONArray doInBackground(String... urls) {

        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;

        try{

            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();
            while(data != -1)
            {
                char current = (char)data;
                result += current;
                data = reader.read();
            }


            //JSONObject jsonObject = new JSONObject(result);
            //String tipomaqcompania = jsonObject.getString("tipomaqcompania");
            JSONArray arr = new JSONArray(result);
            Log.d("aqui arr: ", arr.toString());

            return arr;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }



    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        super.onPostExecute(jsonArray);
    }
    public interface clicaritem{

    }
}
