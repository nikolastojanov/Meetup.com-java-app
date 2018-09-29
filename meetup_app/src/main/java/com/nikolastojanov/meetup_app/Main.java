
package com.nikolastojanov.meetup_app;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;


public class Main {
    
    public static JSONArray cities;
    public static String Key = "505e3a68102d27334b59663cb6e744";
    public static String citypathcode = "/2/cities";
    public static String eventpathcode = "/2/open_events";
    public static int x;
    
    
    
    public static void main(String[] args) {
        getWriter injector = null;
        Writer writer = null;
        // write cities
        injector = new CityWriterInjector();
        writer = injector.createWriter();
        writer.process(citypathcode);
        // select a city
        Scanner s = new Scanner(System.in);
        System.out.println("Unesite redni broj grada koji zelite da izaberete");
        x = s.nextInt();
        //write events
        injector = new EventWriterInjector();
        writer = injector.createWriter();
        writer.process(eventpathcode);
        //end of program
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("program je zavrsio sa radom i automatski ce se ugasiti za 60 sekundi.\nAko zelite informacije za drugi grad ponovo pokrenite program");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
