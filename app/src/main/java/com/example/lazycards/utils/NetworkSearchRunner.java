package com.example.lazycards.utils;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class NetworkSearchRunner implements Runnable {
    private List<InetAddress> addresses = new ArrayList<>();
    @Override
    public void run() {

    }

    public List<InetAddress> getAddresses(){ return addresses; }
}
