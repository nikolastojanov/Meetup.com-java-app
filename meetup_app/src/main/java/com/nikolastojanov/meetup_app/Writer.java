// This is a consumer class that utilises services getter and decoder
package com.nikolastojanov.meetup_app;


public class Writer {
    
    private Request request;
    private JSONDecoder decoder;
    
    public Writer(Request r, JSONDecoder d){
        request = r;
        decoder = d;
    }
    
    public void process(String PathCode){
        try{
            String s = request.SendRequest(PathCode, Main.Key);
            decoder.decode(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
