package main.java.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ValueParser {
    public static String getValue(String result,String key){
        Object obj = JSONValue.parse(result);
        JSONObject json = (JSONObject)obj;
        JSONObject main = (JSONObject)json.get("main");
        return main.get(key).toString();
    }
}
