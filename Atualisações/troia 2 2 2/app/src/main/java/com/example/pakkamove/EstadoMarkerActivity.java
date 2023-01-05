 package com.example.pakkamove;

 import static com.example.pakkamove.Constants.API_PUT_ESTADO;
 import static com.example.pakkamove.Constants.HTTPS;
 import static com.example.pakkamove.Constants.IP_LOCAL;

 import android.content.Intent;
 import android.os.Bundle;
 import android.util.Log;
 import android.view.View;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.TextView;
 import android.widget.Toast;

 import androidx.appcompat.app.AppCompatActivity;

 import com.google.android.material.button.MaterialButton;

 import org.json.JSONException;
 import org.json.JSONObject;

 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import java.util.Locale;

 public class EstadoMarkerActivity extends AppCompatActivity {

     TextView titulo, distancia_rodape, subtitle;
     CheckBox papel, dinheiro, estado;
     Button submit;
     int id_mac = 1;
     int id_estado = 4;

     @Override
     protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_estado);

         titulo = findViewById(R.id.marker_title);
         subtitle = findViewById(R.id.marker_subtitile);
         estado = findViewById(R.id.estado);
         dinheiro = findViewById(R.id.dinheiro);
         papel = findViewById(R.id.papel);
         submit = findViewById(R.id.submit);

         submit.setVisibility(View.VISIBLE);

         Bundle extras = getIntent().getExtras();

         if (extras != null){
             titulo.setText(extras.getString("titulo"));
             subtitle.setText(extras.getString("subtitulo"));
             estado.setChecked(extras.getBoolean("estado"));
             papel.setChecked(extras.getBoolean("papel"));
             dinheiro.setChecked(extras.getBoolean("dinheiro"));
         }

         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 //TODO: fazer este json para enviar num POST //"{"id": "4","id_estado":"2"}
                 JSONObject jsonObject = new JSONObject();
                 try {
                     id_mac = Integer.parseInt(titulo.getText().toString().split("-")[0]);
                     jsonObject.put("id_mac", id_mac);

                     //TODO:ifs com estado da checkbox (estado.ischecked())

                     if(estado.isChecked() && !papel.isChecked() && !dinheiro.isChecked())
                         id_estado = 1;

                     else if(estado.isChecked() && !papel.isChecked() && dinheiro.isChecked())
                        id_estado = 2;

                     else if(estado.isChecked() && papel.isChecked() && dinheiro.isChecked())
                         id_estado = 3;

                     else if(estado.isChecked() && papel.isChecked() && !dinheiro.isChecked())
                         id_estado = 5;

                     else //desligado
                         id_estado = 4;

                     jsonObject.put("id_estado", id_estado);

                     //enviar o jsonobject no post
                     Log.d("jsonObject a enviar: ", jsonObject.toString());


                     //Enviar um PUT
                     // Create the connection
                     URL url = new URL(HTTPS+IP_LOCAL+API_PUT_ESTADO);
                     HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    // Set the request method to PUT
                     connection.setRequestMethod("PUT");

                    // Set the request body
                     connection.setDoOutput(true);
                     OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                     writer.write(jsonObject.toString());
                     writer.close();

                    // Connect to the endpoint
                     connection.connect();

                    // Get the response code
                     int responseCode = connection.getResponseCode();
                     Log.d("responseCode: ", String.valueOf(responseCode));

                    // Read the response data
                     BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                     String line;
                     while ((line = reader.readLine()) != null) {
                         // Process the response data
                     }
                     reader.close();

                    // Disconnect from the endpoint
                     connection.disconnect();
                 }catch (JSONException jsonE){
                     Log.e("Erro at object 4 post: ", jsonE.toString());
                 }catch (Exception e){
                     Log.e("Erro: ", e.toString());
                 }

                 Intent i = new Intent(EstadoMarkerActivity.this, MapsActivity.class);
                 i.putExtra("estado", estado.isChecked());
                 i.putExtra("papel", papel.isChecked());
                 i.putExtra("dinheiro", dinheiro.isChecked());
                 i.putExtra("id_mac", id_mac);
                 i.putExtra("id_estado", id_estado);
                 startActivity(i);

             }
         });


     }


      

 }


