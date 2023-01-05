package com.example.pakkamove;

import static com.example.pakkamove.Constants.API_M_ESTADO;
import static com.example.pakkamove.Constants.HTTPS;
import static com.example.pakkamove.Constants.IP_LOCAL;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.pakkamove.databinding.ActivityMapsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private ArrayList<MarkerOptions> mMarkerArray;
    private LatLng minhaLatLng = new LatLng(0,0);
    JSONArray arraytipoMaqcompania = null;
    ArrayList<String> arrayBancosEstado;
    BottomNavigationView buttom_nav_option;
    boolean estadoPut, dinheiroPut, papelPut;
    int markerPut, markerEstadoPut;
    String maquina_m_estado;
    TextView titulo, distancia_rodape, subtitle;
    CheckBox papel, dinheiro, estado;
    Button submit;
    int markerId = -1; //quando n vem markerId da lista de bancos
    boolean vimDoBancos = false, vimDoEstadoMarker = false;


    public static double distance(LatLng latLng1, LatLng latLng2) {
        double earthRadius = 6371; // km
        double dLat = Math.toRadians(latLng2.latitude-latLng1.latitude);
        double dLng = Math.toRadians(latLng2.longitude-latLng1.longitude);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(latLng1.latitude)) * Math.cos(Math.toRadians(latLng2.latitude));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;

        return dist;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.containsKey("id")) {
                vimDoBancos = true;
                Log.d("MapsActivity: ", "Vim do Bancos");
                markerId = extras.getInt("id");
                Log.d("Recebi um id da lista: ", String.valueOf(markerId));
            }
            else if(extras.containsKey("estado")){
                vimDoEstadoMarker = true;
                Log.d("MapsActivity: ", "Vim do EstadoMarkerActivity");
                estadoPut = extras.getBoolean("estado");
                papelPut = extras.getBoolean("papel");
                dinheiroPut = extras.getBoolean("dinheiro");
                markerPut = extras.getInt("id_mac");
                markerEstadoPut = extras.getInt("id_estado");
            }
        }

        //receber dados dos bancos
        info task = new info();

        arrayBancosEstado = new ArrayList<>();

        try {
            arraytipoMaqcompania = task.execute(HTTPS+IP_LOCAL+API_M_ESTADO).get();
            Log.d("arraytipoMaqcompania: ", arraytipoMaqcompania.toString());
            for (int i =0 ; i < arraytipoMaqcompania.length(); i++){
                // criar um novo objecto com os dados recebidos
                JSONObject jsonObject = new JSONObject(arraytipoMaqcompania.getString(i));
                // contruir uma nova string para adicionar na lista
                StringBuilder newString = new StringBuilder();
                // colocar nome na string
                newString.append(jsonObject.getString("tipo_mac_nome"));
                // colocar o separador
                newString.append(" - ");
                // colocar o direcionamento
                newString.append(jsonObject.getString("tipo_mac_direcion"));
                // adicionar a string na lista
                arrayBancosEstado.add(newString.toString());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        //binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);


        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            // Permission is granted, so we can get the location
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            @SuppressLint("MissingPermission") Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                minhaLatLng = new LatLng(latitude, longitude);

                //TODO: Para dar fake // RETIRAR DEPOIS
                minhaLatLng = new LatLng(38.707573, -9.152852);
                Log.d("minhaLatLng: ", minhaLatLng.toString());
            }
        } else {
            // Permission is not granted, so we request it from the user
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }


        // Initialize and assign variable
        buttom_nav_option = findViewById(R.id.bottom_navigation);

        // Set Home selected
        buttom_nav_option.setSelectedItemId(R.id.inicio_menu);

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
        //recever nome do ATM

    }

    public ArrayList<MarkerOptions> saveMarkers(){
        ArrayList<MarkerOptions> markers = new ArrayList<>();

        //colocar marcadores vindos da BD

        if(arraytipoMaqcompania == null){
            SystemClock.sleep(4000);
        }
        else{
            for(int i = 0; i < arraytipoMaqcompania.length() ; i++) {
                try {
                    String mac_id = ((JSONObject) arraytipoMaqcompania.get(i)).getString("mac_id");
                    String latitude = ((JSONObject) arraytipoMaqcompania.get(i)).getString("local_latitude");
                    String longitude = ((JSONObject) arraytipoMaqcompania.get(i)).getString("local_longitude");
                    String estado_user = ((JSONObject) arraytipoMaqcompania.get(i)).getString("estado_nome") +
                            " | definido por: " + ((JSONObject) arraytipoMaqcompania.get(i)).getString("user_nome");
                    String maq_direction = ((JSONObject) arraytipoMaqcompania.get(i)).getString("tipo_mac_nome") + " - " +
                            ((JSONObject) arraytipoMaqcompania.get(i)).getString("tipo_mac_direcion");


                    LatLng latlng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
                    markers.add(new MarkerOptions().position(latlng).snippet(estado_user).title(mac_id + "-" + maq_direction));
                }catch(Exception e){
                    Log.e("ERRO: on marker place: ", e.toString());
                }
            }
        }
        /*else{ //correu algo mal vindo da BD, vamos por markes a mao

            // Add a marker in Santander
            LatLng santander = new LatLng(38.707572, -9.152853);
            markers.add(new MarkerOptions().position(santander)
                    .snippet("Sem papel | definido por: João").title("Santander"));

            // Add a marker in CaixaGeral
            LatLng CaixaGeral = new LatLng(38.7082116, -9.152711);
            markers.add(new MarkerOptions().position(CaixaGeral)
                    .snippet("Ligado, Sem papel | definido por: Mingo").title("Caixa Geral"));

            // Add a marker in Montepio
            LatLng Montepio = new LatLng(38.7084643, -9.1527901);
            markers.add(new MarkerOptions().position(Montepio)
                    .snippet("Ligado, Sem sistema | definido por: Ari").title("Montepio"));

            // Add a marker in Euronet
            LatLng Euronet = new LatLng(38.708449, -9.153157);
            markers.add(new MarkerOptions().position(Euronet)
                    .snippet("Desligado | definido por: Lari").title("Euronet"));
        }

         */

        return markers;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMarkerArray = saveMarkers();

        //TODO: remover depois do update funcionar
        if(vimDoEstadoMarker){
            for(int i = 0 ; i < mMarkerArray.size() ; i++) {
                if(markerPut-1 == i){
                    if(markerEstadoPut == 1)
                        mMarkerArray.get(i).snippet("Ligado, Sem Papel, Sem Dinheiro");

                    if(markerEstadoPut == 2)
                        mMarkerArray.get(i).snippet("Ligado, Sem Papel, Com Dinheiro");

                    if(markerEstadoPut == 3)
                        mMarkerArray.get(i).snippet("Ligado, Com Papel, Com Dinheiro");

                    if(markerEstadoPut == 4)
                        mMarkerArray.get(i).snippet("Desligado");

                    if(markerEstadoPut == 5)
                        mMarkerArray.get(i).snippet("Ligado, Com Papel, Sem Dinheiro");

                }
            }
        }


        for(int i = 0 ; i < mMarkerArray.size() ; i++) {
            Marker m = mMap.addMarker(mMarkerArray.get(i));
            m.setTag(mMarkerArray.get(i).getTitle().split("-")[0]);
        }

        if(!mMarkerArray.isEmpty())
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mMarkerArray.get(0).getPosition(), 19));

        if(markerId != -1){
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mMarkerArray.get(markerId).getPosition(), 19));

        }


        /*mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                marker.showInfoWindow();

                return true;
            }
        });
        */

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                // Inflate the layout for the info window
                View v = getLayoutInflater().inflate(R.layout.check_estado, null);
                titulo = v.findViewById(R.id.marker_title);
                subtitle = v.findViewById(R.id.marker_subtitile);
                estado = v.findViewById(R.id.estado);
                dinheiro = v.findViewById(R.id.dinheiro);
                papel = v.findViewById(R.id.papel);
                submit = v.findViewById(R.id.submit);
                distancia_rodape = v.findViewById(R.id.distanciaRodape);

                if(marker.getSnippet().toLowerCase(Locale.ROOT).startsWith("ligado")){
                    estado.setChecked(true);
                }
                if(marker.getSnippet().toLowerCase(Locale.ROOT).contains("com papel")){
                    papel.setChecked(true);
                }
                if(marker.getSnippet().toLowerCase(Locale.ROOT).contains("com dinheiro")){
                    dinheiro.setChecked(true);
                }

                titulo.setText(marker.getTitle());
                subtitle.setText(marker.getSnippet());

                Log.d("distancia: ", "estou a " + (distance(minhaLatLng, marker.getPosition())*1000) + "m deste marker");
                if((distance(minhaLatLng, marker.getPosition())*1000) <= 40){
                    submit.setVisibility(View.VISIBLE);
                    submit.setEnabled(true);
                    distancia_rodape.setVisibility(View.GONE);
                    Intent i = new Intent(getApplicationContext(), EstadoMarkerActivity.class);
                    i.putExtra("estado", estado.isChecked());
                    i.putExtra("papel", papel.isChecked());
                    i.putExtra("dinheiro", dinheiro.isChecked());
                    i.putExtra("titulo", marker.getTitle());
                    i.putExtra("subtitulo", marker.getSnippet());
                    startActivity(i);
                }
                else{
                    submit.setVisibility(View.INVISIBLE);
                    submit.setEnabled(false);
                    distancia_rodape.setVisibility(View.VISIBLE);
                }


                estado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            estado.setChecked(false);
                            Log.d("estado checkbox: ", String.valueOf(estado.isChecked()));
                        } else {
                            estado.setChecked(true);
                        }
                    }
                });

                papel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            papel.setChecked(false);
                        } else {
                            papel.setChecked(true);
                        }
                    }
                });

                dinheiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            dinheiro.setChecked(false);
                        } else {
                            dinheiro.setChecked(false);
                        }
                    }
                });



                // Return the info window view
                return v;
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Return null to use the default info window frame

                return null;
            }
        });


    }

}