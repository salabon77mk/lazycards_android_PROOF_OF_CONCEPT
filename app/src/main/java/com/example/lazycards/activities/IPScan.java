package com.example.lazycards.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.lazycards.R;
import com.example.lazycards.adapter.NetworkDevice;
import com.example.lazycards.model.Device;

import java.util.ArrayList;

public class IPScan extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipscan);

        ArrayList<Device> devices = new ArrayList<Device>();
        devices.add(new Device("123", "Yoda"));
        devices.add(new Device("456", "Achilles"));
        devices.add(new Device("789", "Watermelon"));


        mRecyclerView = findViewById(R.id.recycler_view_network_devices);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new NetworkDevice(devices, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        print(devices);
    }

    private void print(ArrayList<Device> l){
        for(Device d : l){
            Log.e("ITEM",d.getIPAddress());
        }
    }
}
