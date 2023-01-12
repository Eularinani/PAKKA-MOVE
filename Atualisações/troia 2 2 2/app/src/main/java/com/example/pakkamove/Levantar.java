package com.example.pakkamove;

import static com.example.pakkamove.Constants.API_LEVANTAR;
import static com.example.pakkamove.Constants.API_M_ESTADO;
import static com.example.pakkamove.Constants.HTTPS;
import static com.example.pakkamove.Constants.IP_LOCAL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Levantar extends AppCompatActivity {
    BottomNavigationView buttom_nav_option;

    JSONArray arraylevantar = null;
    // List view que irá conter os multibancos
    private ListView levantar;
    ArrayList<String> arrayLevantar;

    // Listview Adapter que irá proceder à conversão entre o array de strings e a lista
    ArrayAdapter<String> adapter;

    // Search EditText que irá efetuar a pesquisa
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levantar);
        // Preencher a list view com os dados iniciais
        // Array de strings que está definido no ficheiro strings.xml
        info task = new info();

        arrayLevantar = new ArrayList<>();

        try {
            arraylevantar= task.execute(HTTPS+IP_LOCAL+API_LEVANTAR).get();
            Log.d("arraylevantar: ", arraylevantar.toString());
            for (int i =0 ; i < arraylevantar.length(); i++){
                // criar um novo objecto com os dados recebidos
                JSONObject jsonObject = new JSONObject(arraylevantar.getString(i));
                // contruir uma nova string para adicionar na lista
                StringBuilder newString = new StringBuilder();
                // colocar nome na string
                newString.append(jsonObject.getString("serv_tipo"));
                // colocar o separador
                //pakkanewString.append(" - ");
                // colocar o direcionamento
               // newString.append(jsonObject.getString("tipo_mac_direcion"));

                // adicionar a string na lista
                arrayLevantar.add(newString.toString());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        levantar = (ListView) findViewById(R.id.list);

        // Ligar o edit text do design ao código
        inputSearch = (EditText) findViewById(R.id.searchEditText);

        // Criar o adaptador
        adapter = new ArrayAdapter<String>(this, R.layout.text_for_list, arrayLevantar);
        levantar.setAdapter(adapter);

        //fazendo os iten clicaves
        levantar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Bundle para mandar o titulo do banco
                //Bundle bundle = new Bundle();
                //bundle.putInt("id", position);
                Intent mapa  = new Intent(getApplicationContext(), MapsActivity.class);
                mapa.putExtra("id", position);
                startActivity(mapa);
                overridePendingTransition(0,0);
                Log.d("tag: ","cliquei na lista");
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Levantar.this.adapter.getFilter().filter(cs);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }

        });


        //Fazer um evento para detetar mudanças no texto do edit text

        //inputSearch.addTextChangedListener(new TextWatcher());
        buttom_nav_option = findViewById(R.id.bottom_navigation);

        // Set Home selected
        buttom_nav_option.setSelectedItemId(R.id.levantar_menu);

        // Perform item selected listener
        buttom_nav_option.setOnItemSelectedListener(item -> {

            switch(item.getItemId())
            {
                //O codigo abaixo serve para quando clicar no icone do Banco, apareça o layout com a barra de pesquisa e a list view
                case R.id.banco_menu:
                    Intent banco = new Intent(getApplicationContext(), Bancos.class);
                    startActivity(banco);
                    overridePendingTransition(0,0);
                    return true;

                case R.id.maquina_menu:
                    Intent toFriends = new Intent(getApplicationContext(), Maquinas.class);
                    startActivity(toFriends);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.levantar_menu:
                 Intent levanta = new Intent(getApplicationContext(), Levantar.class);
                startActivity(levanta);
                overridePendingTransition(0,0);
                return true;

                case R.id.inicio_menu:
                    Intent mapa  = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(mapa);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });

    }

}