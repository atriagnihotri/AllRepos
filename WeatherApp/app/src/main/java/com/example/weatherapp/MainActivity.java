package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    LinearLayout linearLayout;
    EditText searchbox;
    TextView temp, wind, condition, name;
    ImageView conimg, search;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<WeatherModel> modelArrayList=new ArrayList<>();
    boolean check =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchbox = findViewById(R.id.searchcity);
        search = findViewById(R.id.search);
        linearLayout = findViewById(R.id.linear);
        temp = findViewById(R.id.temperature);
        wind = findViewById(R.id.wind);
        condition = findViewById(R.id.condition);
        name = findViewById(R.id.city);
        conimg = findViewById(R.id.conditionimg);
        recyclerView = findViewById(R.id.recycler);
        progressBar=findViewById(R.id.progress_loader);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=true;
                if (searchbox.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Your City", Toast.LENGTH_SHORT).show();
                } else {
                    Data(searchbox.getText().toString());
                    searchbox.setText("");
                }
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        } else {

                getCurrentLocation();


        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            } else {
                Toast.makeText(this, "Location permission is required to fetch the current city", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (addresses != null && !addresses.isEmpty()) {
                        String city = addresses.get(0).getLocality();
                        if (check==false) {
                            Data(city);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Unable to get city name from location", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) {}

            @Override
            public void onProviderDisabled(String provider) {}
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    private void Data(String city) {
        String url = "http://api.weatherapi.com/v1/forecast.json?key=87e904a24f9f43d389f65503242402&q=" + city + "&days=1&aqi=yes&alerts=yes";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onResponse(JSONObject response) {
                try {
                    progressBar.setVisibility(View.GONE);
                    String names = response.getJSONObject("location").getString("name");
                    String tempe = response.getJSONObject("current").getString("temp_c");
                    String condtions = response.getJSONObject("current").getJSONObject("condition").getString("text");
                    String conimgs = response.getJSONObject("current").getJSONObject("condition").getString("icon");
                    int is_day = response.getJSONObject("current").getInt("is_day");
                    String winds = response.getJSONObject("current").getString("wind_kph");

                    temp.setText(tempe.substring(0, 2) + "°C");
                    name.setText(names);
                    wind.setText(winds + "km/h");
                    condition.setText(condtions);
                    Picasso.get().load("http:" + conimgs).into(conimg);
                    if (is_day == 0) {
                        linearLayout.setBackgroundResource(R.drawable.nightbg);
                        temp.setTextColor(getResources().getColor(R.color.white));
                        name.setTextColor(getResources().getColor(R.color.white));
                        wind.setTextColor(getResources().getColor(R.color.white));
                        condition.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        linearLayout.setBackgroundResource(R.drawable.daybg);
                    }
                    JSONObject forecast=response.getJSONObject("forecast");
                    JSONObject forecastday=forecast.getJSONArray("forecastday").getJSONObject(0);
                    JSONArray hourarr=forecastday.getJSONArray("hour");
                    for (int i=0;i<hourarr.length();i++){
                        JSONObject object=hourarr.getJSONObject(i);
                        String tempc=object.getString("temp_c");
                        String timec=object.getString("time");
                        String conc=object.getJSONObject("condition").getString("text");
                        String imgc=object.getJSONObject("condition").getString("icon");
                        WeatherModel weatherModel=new WeatherModel(tempc+"°C",timec.substring(10,16),conc,imgc);
                        modelArrayList.add(weatherModel);
                        WeatherRecycler weatherRecycler=new WeatherRecycler(modelArrayList,getApplicationContext());
                        recyclerView.setAdapter(weatherRecycler);



                    }





                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);
    }
}
