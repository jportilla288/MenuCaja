package com.carta.dx.menucaja;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuCaja extends AppCompatActivity {
    private ImageButton mesa1, mesa2, mesa3;
    private RequestQueue requestQueue;
    //private String consultarUrl = "http://172.17.10.81/menudigital/Modelos/consultar_pedido_mesaTodos.php";
    private String consultarUrl = "http://200.69.124.143/menudigital/Modelos/consultar_pedido_mesaTodos.php";
    ArrayList<Pedido> listapedidos;  //definimos un array List de tipo pedido
    String pedudi;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu_caja);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ImageButton mesa1 = (ImageButton) findViewById(R.id.btmesa1);
        ImageButton mesa2 = (ImageButton) findViewById(R.id.btmesa2);
        ImageButton mesa3 = (ImageButton) findViewById(R.id.btmesa3);
        final Button m1 = (Button) findViewById(R.id.btm1);
        final Button m2 = (Button) findViewById(R.id.btm2);
        final Button m3 = (Button) findViewById(R.id.btm3);


        final ImageButton btmesa1 = (ImageButton) findViewById(R.id.btmesa1);

        btmesa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent paso = new Intent(MenuCaja.this, PedidoMesa1.class);
                startActivity(paso);

            }
        });

        final ImageButton btmesa2 = (ImageButton) findViewById(R.id.btmesa2);

        btmesa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent paso = new Intent(MenuCaja.this, PedidoMesa2.class);
                startActivity(paso);

            }
        });

        final ImageButton btmesa3 = (ImageButton) findViewById(R.id.btmesa3);

        btmesa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent paso = new Intent(MenuCaja.this, PedidoMesa3.class);
                startActivity(paso);

            }
        });

        ImageButton histoPed = (ImageButton) findViewById(R.id.historial);


        histoPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList mostrar = new ArrayList();
                Pedido pedidocli = new Pedido();
                ArrayList<Platos> p1 = new ArrayList<Platos>();

                Bundle extras = getIntent().getExtras();
                if (getIntent().getSerializableExtra("pedidocliente") != null) {

                    //p1= (ArrayList<Platos>) extras.getSerializable("pedidocliente");
                    pedidocli = (Pedido) extras.getSerializable("pedidocliente");

                    assert pedidocli != null;
                }
            }


        });

        JsonArrayRequest req = new JsonArrayRequest(consultarUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Log.d(TAG, response.toString());

                        try {
                            String jsonResponse = "";
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject pedido = (JSONObject) response.get(i);

                                String idPedido = pedido.getString("IdPedido");
                                String idEmpleado = pedido.getString("idEmpleado");
                                JSONObject precio = pedido.getJSONObject("Precio");
                                String duracion = pedido.getString("Duracion");
                                String numMesa = pedido.getString("numero de Mesa");

                                jsonResponse += "IdPedido: " + idPedido + "\n\n";
                                jsonResponse += "idEmpleado: " + idEmpleado + "\n\n";
                                jsonResponse += "Precio: " + precio + "\n\n";
                                jsonResponse += "Duracion: " + duracion + "\n\n\n";
                                jsonResponse += "numero de Mesa: " + numMesa + "\n\n\n";


                                String mesa = pedido.getString("mesa");
                                if (!mesa.equals("")) {
                                    if (mesa.equals("1"))
                                        m1.setBackgroundColor(Color.parseColor("#00ff00"));
                                    if (mesa.equals("1"))
                                        m2.setBackgroundColor(Color.parseColor("#00ff00"));
                                    if (mesa.equals("1"))
                                        m3.setBackgroundColor(Color.parseColor("#00ff00"));
                                }
                            }


                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("error", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });


    }
}




