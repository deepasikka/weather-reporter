package main.java.api;

import main.java.constants.Constants;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.ws.http.HTTPException;

public class APIWeatherForecast {
    private String url;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    @BeforeClass
    public void init(){
        url= Constants.API_URL+"?q="+Constants.CITY+"&appid="+Constants.API_KEY+"&units="+Constants.API_TEMP_UNITS;

    }
    @Test
    public void getWeather(){

        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            int status = response.getStatusLine().getStatusCode();
           if(status==200){
               HttpEntity entity = response.getEntity();
               if (entity != null) {
                   String result = EntityUtils.toString(entity);

               }
           }else{
               throw new Exception("API Request returned with status :"+response.getStatusLine().getStatusCode());
           }



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
