package com.example.lazycards.server;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server_Endpoints extends AsyncTask<Void, Void, Void> {
    private static String host;
    private static final int TIMEOUT = 1000;
    public static final String FAST_SUB = "http://192.168.1.226/lazycards/fast_sub";

    static void setHost(){
        get192();
    }

    // get 192
    private static void get192(){
        final String host = "192.168.1.";

        for(int i = 0; i < 255; i++){
            String ip = host + i;
            Log.d("IP", ip);
            try {
                if (InetAddress.getByName(ip).isReachable(TIMEOUT)) {
                    Log.d("IP REACHABLE", "REACHABLE" + ip);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("DONE", "DONE");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        setHost();
        return null;
    }

    // get 192 EXTENDED RANGE

    // get 172

    // get 10
}
