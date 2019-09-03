package com.example.lazycards;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class TestPost{ /*extends AsyncTask<String, Void, String> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    @Override
    protected String doInBackground(String... strings) {
        String strURL = strings[0];
        String result = "";
        String inputLine;

        try {
            //Create a URL object holding our url
            URL myUrl = new URL(strURL);         //Create a connection
            HttpURLConnection connection =(HttpURLConnection)
                    myUrl.openConnection();         //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Connect to our url
            connection.connect();         //Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());         //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();         //Check if the line we are reading is not null
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }         //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();         //Set our result equal to our stringBuilder
            result = stringBuilder.toString();
        }
        catch(Exception ex){

        }
        return result;

    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
    }

    public static void fastPost(JSONObject word){


        String url = "http://192.168.226/lazy_cards/fast_sub";

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(word.toString().getBytes());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            Log.d("efw", "\nSending 'POST' request to URL : " + url);
            Log.d("wf","Post parameters : " + word);
            Log.d("wfewfw" ,"Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            Log.d("wefwef", response.toString());

        }
        catch(Exception ex){
            System.out.println("woops");
            ex.printStackTrace();
        }
    }
    */
}
