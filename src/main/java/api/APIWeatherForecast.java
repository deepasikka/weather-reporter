package main.java.api;

import main.java.constants.Constants;
import main.java.modal.Modal;
import main.java.utils.ValueParser;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class APIWeatherForecast {
    private String url;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    static Modal modal = new Modal();
    static Logger log = Logger.getLogger(APIWeatherForecast.class);
    @BeforeClass
    public void init(){
        url= Constants.API_URL+"?q="+Constants.CITY+"&appid="+Constants.API_KEY+"&units="+Constants.API_TEMP_UNITS;
        log.info("API URL : "+url);
    }
    @Test
    public void getWeather(){

        HttpGet request = new HttpGet(url);
        log.info("Creating get request");
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            int status = response.getStatusLine().getStatusCode();
            log.info("Request Status : "+status);
           if(status==200){
               HttpEntity entity = response.getEntity();
               if (entity != null) {
                   String result = EntityUtils.toString(entity);
                   log.info("Getting result"+result);
                   modal.setHumidity(ValueParser.getValue(result,"humidity"));
                   modal.setTemperature_degree(ValueParser.getValue(result,"temp"));


               }
           }else{
               log.error("Error Status :"+response.getStatusLine().getStatusCode());
               throw new Exception("API Request returned with status :"+response.getStatusLine().getStatusCode());
           }



        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public Modal getModal(){
        return modal;
    }

}
