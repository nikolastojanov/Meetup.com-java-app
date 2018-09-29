// service component for writing requested cities to console

package com.nikolastojanov.meetup_app;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class CityDecoder implements JSONDecoder {

    public void decode(String requested) throws Exception {
        try{
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(requested);
            JSONArray results = (JSONArray) object.get("results");
            Main.cities = results;
            System.out.println("Ovo je lista svih gradova u Srbiji u kojima postoji meetup");
            
            Iterator i = results.iterator();
            int k = 0;
            while(i.hasNext()){
                JSONObject city = (JSONObject) i.next();
                System.out.println(Integer.toString(k) + " : " + city.get("city"));
                k++;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
