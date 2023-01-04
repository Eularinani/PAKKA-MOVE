package com.example.pakkamove;

import static com.example.pakkamove.Constants.API_TIPOMAC;
import static com.example.pakkamove.Constants.HTTPS;
import static com.example.pakkamove.Constants.IP_LOCAL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Maquinas extends AppCompatActivity {

    JSONArray arraytipoMaqcompania= null;
    // List view que irá conter os multibancos
    private ListView lv;
    ArrayList<String> arrayMaquinas;

    // Listview Adapter que irá proceder à conversão entre o array de strings e a lista
    ArrayAdapter<String> adapter;

    // Search EditText que irá efetuar a pesquisa
    EditText inputSearch;

    BottomNavigationView buttom_nav_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar_mapas_main);
        // Preencher a list view com os dados iniciais
        // Array de strings que está definido no ficheiro strings.xml
        info task = new info();

        arrayMaquinas = new ArrayList<>();

        try {
            arraytipoMaqcompania= task.execute(HTTPS+IP_LOCAL+API_TIPOMAC).get();

            for (int i =0 ; i < arraytipoMaqcompania.length(); i++){
                // criar um novo objecto com os dados recebidos
                JSONObject jsonObject = new JSONObject(arraytipoMaqcompania.getString(i));
                // contruir uma nova string para adicionar na lista
                StringBuilder newString = new StringBuilder();
                // colocar nome na string
                newString.append(jsonObject.getString("tipomacnome"));
                // colocar o separador
                newString.append(" - ");
                // colocar o direcionamento
                newString.append(jsonObject.getString("direcionamento"));
                // adicionar a string na lista
                arrayMaquinas.add(newString.toString());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        catch (JSONException e){
            e.printStackTrace();
       }


        lv = (ListView) findViewById(R.id.list);

        // Ligar o edit text do design ao código
        inputSearch = (EditText) findViewById(R.id.searchEditText);

        // Criar o adaptador
        adapter = new ArrayAdapter<String>(this, R.layout.text_for_list, arrayMaquinas);
        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Maquinas.this.adapter.getFilter().filter(cs);
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

        //inputSearch.addTextChangedListener(new TextWatcher());
        buttom_nav_option = findViewById(R.id.bottom_navigation);

        // Set Home selected
        buttom_nav_option.setSelectedItemId(R.id.maquina_menu);

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
                //case R.id.levantar_menu:
                // Intent toMaps = new Intent(getApplicationContext(), GroupChatActivity.class/MapsActivity.class/);
                //startActivity(toMaps);
                //overridePendingTransition(0,0);
                //return true;

                case R.id.inicio_menu:
                    Intent mapa  = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(mapa);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });

        //Fazer um evento para detetar mudanças no texto do edit text
        //inputSearch.addTextChangedListener(new TextWatcher());
    }



    //o codigo abaixo é para pegar os dados e fornecer na barra de pesuisa
        //EditText searchView = findViewById(R.id.searchEditText);
        //searchView.addTextChangedListener(view -> {});s
     }
