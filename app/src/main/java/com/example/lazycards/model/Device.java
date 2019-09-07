package com.example.lazycards.model;

public class Device {
    private String name;
    private String ip;

    public Device(String ipAddress, String deviceName){
        name = deviceName;
        ip = ipAddress;
    }

    public Device(){
        name = "";
        ip = "";
    }

    public String getIPAddress(){
        return ip;
    }

    public void setIPAddress(String ipAddress){
        ip = ipAddress;
    }

    public String getName(){
        return name;
    }

    public void setName(String deviceName){
        name = deviceName;
    }

}
