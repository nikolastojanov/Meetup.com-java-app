
package com.nikolastojanov.meetup_app;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class EventDecoder implements JSONDecoder{

    @Override
    public void decode(String requested) throws Exception {
        try{
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(requested);
            JSONArray results = (JSONArray) object.get("results");
            System.out.println("Ovo je lista svih meetupa za izabrani grad\n");
            
            Iterator k = results.iterator();
            
            while(k.hasNext()){
                JSONObject event = (JSONObject) k.next();
                
                System.out.println("Naziv dogadjaja : " + event.get("name"));
				
                System.out.println("\t vreme odrzavanja : " + event.get("time"));
                
                System.out.println("\t opis dogadjaja : " + event.get("description"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
