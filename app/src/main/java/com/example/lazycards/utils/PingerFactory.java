package com.example.lazycards.utils;

public class PingerFactory {
    public static Pinger newPinger(byte b){
        if(b == -64){
            return new Ping192();
        }
        else if(b == -84){
            return new Ping172();
        }
        return new Ping10();
    }
}
