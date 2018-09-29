// service component for getting allt the events in the requested city
package com.nikolastojanov.meetup_app;

import java.net.URI;
import java.util.Iterator;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;


public class EventGetter implements Request{
    
    String city;

    @Override
    public String SendRequest(String PathCode, String key) throws Exception {
        System.out.println(city);
        String responseString = "";
 
        URI request = new URIBuilder()			
		.setScheme("http")
		.setHost("api.meetup.com")
		.setPath(PathCode)
                .setParameter("country", "rs")
		.setParameter("city", city)
		.setParameter("key", key)
		.build();
 
	HttpGet get = new HttpGet(request);			
 
	CloseableHttpClient client = HttpClients.createDefault();
	CloseableHttpResponse response = client.execute(get);
	responseString = EntityUtils.toString(response.getEntity());
                
	return responseString;

    }
    
    public EventGetter(int x){
        Iterator i = Main.cities.iterator();
        int k = 0;
        JSONObject name = null;
        while(i.hasNext()){
            JSONObject obj = (JSONObject) i.next();
            if(k == x){
                name = obj;
                break;
            }else{
                k++;
            }
        }
        this.city = (String) name.get("city");
    }
    
}
