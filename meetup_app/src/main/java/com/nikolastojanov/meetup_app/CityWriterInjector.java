//Injector class that creates a Writer for cities
package com.nikolastojanov.meetup_app;


public class CityWriterInjector implements getWriter {

    @Override
    public Writer createWriter() {
        CityGetter g = new CityGetter();
        CityDecoder d = new CityDecoder();
        Writer w = new Writer(g,d);
        return w;
    }
    
}
