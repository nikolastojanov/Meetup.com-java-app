// Injector class that creates a Writer for Events
package com.nikolastojanov.meetup_app;


public class EventWriterInjector implements getWriter {

    @Override
    public Writer createWriter() {
        EventGetter e = new EventGetter(Main.x);
        EventDecoder d = new EventDecoder();
        Writer w = new Writer(e,d);
        return w;
    }
    
}
