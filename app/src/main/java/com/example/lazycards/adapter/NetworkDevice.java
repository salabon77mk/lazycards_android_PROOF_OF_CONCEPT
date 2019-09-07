package com.example.lazycards.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lazycards.R;
import com.example.lazycards.model.Device;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NetworkDevice extends RecyclerView.Adapter<NetworkDevice.NetworkDeviceViewHolder> {

    private List<Device> mDevs;
    private Context mContext;
    private int mRows;

    public NetworkDevice(List<Device> addresses, Context context){
        mDevs = addresses;
    }

    public NetworkDevice(List<Device> addresses, int rows, Context context){
        mDevs = addresses;
        mContext = context;
        mRows = rows;
    }

    // TODO: Change hardcoded int below
    @NonNull
    @Override
    public NetworkDeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_device, parent, false);
        return new NetworkDeviceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NetworkDeviceViewHolder holder, int idx) {
        Device dev = mDevs.get(idx);
        holder.deviceName.setText(dev.getName());
        holder.ip.setText(dev.getIPAddress());
    }

    @Override
    public int getItemCount() {
        return mDevs == null ? 0 : mDevs.size();
    }


    public static class NetworkDeviceViewHolder extends RecyclerView.ViewHolder{
        public TextView deviceName;
        public TextView ip;

        public NetworkDeviceViewHolder(View view){
            super(view);
            deviceName = view.findViewById(R.id.textView_deviceName);
            ip = view.findViewById(R.id.textView_ip);
        }

    }

}
