package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<CurrencyModel> currencyModelArrayList=new ArrayList<>();
final static String url="https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);



        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("data");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String name=jsonObject.getString("name");
                        String symbol=jsonObject.getString("symbol");
                        String price=jsonObject.getJSONObject("quote").getJSONObject("USD").getString("price");
                        currencyModelArrayList.add(new CurrencyModel("NAME = "+name,"SYMBOL = "+symbol,"PRICE = $"+price.substring(0,10)));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        CurrencyAdaptor currencyAdaptor=new CurrencyAdaptor(currencyModelArrayList,getApplicationContext());
                        recyclerView.setAdapter(currencyAdaptor);

                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Eroor Occured"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("X-CMC_PRO_API_KEY","5abad1d1-d66f-48b7-8ac3-2f1b06824d1f");
                return hashMap;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
}