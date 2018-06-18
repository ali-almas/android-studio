package com.example.hp450.whatisweather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jgabrielfreitas.core.BlurImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText cityName;
    TextView resultWeather;
    Button weatherButton;
    TextView cityNameTextView;

    public void findWeather(View view)
    {
        System.out.println(cityName.getText().toString());

        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(cityName.getWindowToken(), 0);

        try {
            String encodedCityName = URLEncoder.encode(cityName.getText().toString(), "UTF-8");

            DownloadTask task = new DownloadTask();

            task.execute("http://api.openweathermap.org/data/2.5/weather?q="+encodedCityName+"&appid=895f7f7d42d53c8c3907e3ffd5a9411a" );

        } catch (UnsupportedEncodingException e) {
            Toast.makeText(getApplicationContext(),"Could not find weather",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       @SuppressLint("WrongViewCast")
        BlurImageView backgroundImage = findViewById(R.id.backgroundImage);
        backgroundImage.setBlur(2);

        cityName = findViewById(R.id.cityName);
        resultWeather = findViewById(R.id.resultWeather);
        weatherButton = findViewById(R.id.weatherButton);
        cityNameTextView = findViewById(R.id.cityNameTextView);

        cityName.setTranslationY(2000f);
        resultWeather.setTranslationY(2000f);
        weatherButton.setTranslationY(2000);
        cityNameTextView.setTranslationY(2000f);

        cityNameTextView.animate().translationYBy(-2000f).setDuration(1000);
        cityName.animate().translationYBy(-2000f).setDuration(1200);
        weatherButton.animate().translationYBy(-2000f).setDuration(1400);
        resultWeather.animate().translationYBy(-2000f).setDuration(1600);
    }

    public class DownloadTask extends AsyncTask<String,Void,String >
    {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1)
                {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"Could not find weather",Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                String message = "";

                JSONObject jsonObject = new JSONObject(result);

                String weatherInfo = jsonObject.getString("weather");

                JSONArray arr = new JSONArray(weatherInfo);

                for(int i = 0; i < arr.length(); i++)
                {
                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = "";
                    String description = "";

                    main = jsonPart.getString("main");
                    description = jsonPart.getString("description");

                    if(main != "" && description != "")
                    {
                        message += main + " : " + description + "\r\n";
                    }
                }

                if(message != "")
                {
                    resultWeather.setText(message);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Could not find weather",Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),"Could not find weather",Toast.LENGTH_LONG).show();
            }
        }
    }
}




