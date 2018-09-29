// Service component for getting cities from web server
package com.nikolastojanov.meetup_app;

import java.net.URI;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class CityGetter implements Request {
    


    @Override
    public String SendRequest(String PathCode, String key) throws Exception {
        
        String response = "";
        String country = "rs";
        
        
        URI request = new URIBuilder()
                .setScheme("http")
                .setHost("api.meetup.com")
                .setPath(PathCode)
                .setParameter("country", country)
                .setParameter("key", key)
                .build();
        
        HttpGet get = new HttpGet(request);
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse httpresponse = httpclient.execute(get);
        
        response = EntityUtils.toString(httpresponse.getEntity());
        
        return response;
    }
    
}
