package com.example.lazycards.activities;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.lazycards.R;
import com.example.lazycards.server.Anki_Actions;
import com.example.lazycards.server.JSON_Keys;
import com.example.lazycards.server.Server_Endpoints;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    Server_Endpoints srv = new Server_Endpoints();
    //    srv.execute();

        //Server_Endpoints.setHost();
    }

    /* Fast submit that creates an array of
    *   word : word to add to anki
    *   tags : tags to add to card
    *   deck : which deck to add to // fig this out, make an anki req to create a spinner
    *   populated with current decks
    *
    *   Meant to be fast and dumb (just add a new card and forget)
     */
    public void submit(View view){
  //      Intent intent = new Intent(this, Submit.class);
        EditText word_et = findViewById(R.id.editText_word);
        EditText deck_et = findViewById(R.id.editText_deck);
        EditText tags_et = findViewById(R.id.editText_tags);

        final String word = word_et.getText().toString();
        final String deck = deck_et.getText().toString();
        List<String> tags = splitTags(tags_et);

        JSONObject payload = new JSONObject();

        try {
            payload.put(JSON_Keys.WORD, word);
            payload.put(JSON_Keys.DECK, deck);
            payload.put(JSON_Keys.ANKACT, Anki_Actions.ADDNOTE); // for APIs

            JSONArray tags_j = new JSONArray();
            for(String s : tags){ tags_j.put(s); }

            payload.put(JSON_Keys.TAGS, tags_j);
        } catch (JSONException e) {
            Log.e("LAZYCARDS", "Unexpected JSON error in MainActivity.java:submit()");
        }


        TestPost newReq = new TestPost();
        try {
            String result = newReq.execute(payload).get();
            Log.d("RESULT", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private List<String> splitTags(EditText tags_et){
        String tags = tags_et.getText().toString();
        if(tags.length() == 0){
            return new ArrayList<>();
        }
        String[] items = tags.split(" ");
        return Arrays.asList(items);
    }

    // For debug, delete later
    public void gotoNetworkScan(View view){
        Intent intent = new Intent(this, IPScan.class);
        startActivity(intent);
    }

    private static class TestPost extends AsyncTask<JSONObject, Void, String> {
        // TODO clean this code of redundancy
        private static final String REQUEST_METHOD = "POST";
        private static final int READ_TIMEOUT = 15000;
        private static final int CONNECTION_TIMEOUT = 15000;
        @Override
        protected String doInBackground(JSONObject... objs) {
            JSONObject strURL = objs[0];
            String result = "";
            String inputLine;
            String URL = Server_Endpoints.FAST_SUB;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(URL);         //Create a connection
                HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();         //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");

                connection.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                Log.d("efwef", objs[0].toString());
                wr.write(objs[0].toString().getBytes());
                wr.flush();
                wr.close();


                //Connect to our url
                connection.connect();         //Create a new InputStreamReader

                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());         //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);

                StringBuilder stringBuilder = new StringBuilder();         //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }         //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();         //Set our result equal to our stringBuilder
                result = stringBuilder.toString();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }

    }
}
