package main.java.utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class ValueParser {
    static Logger log = Logger.getLogger(ValueParser.class);
    public static String getValue(String result,String key){
        log.info("Converting String to JSON");
        Object obj = JSONValue.parse(result);
        JSONObject json = (JSONObject)obj;
        JSONObject main = (JSONObject)json.get("main");
        log.info("Getting value of "+key);
        return main.get(key).toString();
    }
}
