package com.example.paiseslista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.paiseslista.WebServices.Asynchtask;
import com.example.paiseslista.WebServices.WebService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity
        extends AppCompatActivity
        implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        ArrayList<ListaPaises> lstPaises = new ArrayList<ListaPaises>();

        JSONObject lista = new JSONObject(result);
        JSONObject JSONlista = lista.getJSONObject("Results");

        lstPaises = ListaPaises.JsonObjectsBuild(JSONlista);

        Adaptador adaptadorPaises
                = new Adaptador(this, lstPaises);
        ListView lstOpciones = (ListView)findViewById(R.id.lstPaises);
        lstOpciones.setAdapter(adaptadorPaises);
    }
}