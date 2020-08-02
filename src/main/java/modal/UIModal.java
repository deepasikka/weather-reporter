package main.java.modal;

public class UIModal {
    private String temperature_degree;
    private String temperature_fah;
    private String humidity;
    private String condition;
    private String wind;

    public UIModal(String temperature_degree,String temperature_fah,String condition,String humidity,String wind){
        this.temperature_degree = temperature_degree;
        this.temperature_fah = temperature_fah;
        this.humidity = humidity;
        this.condition = condition;
        this.wind = wind;
    }
    public UIModal(String temperature_degree,String humidity){
        this.temperature_degree = temperature_degree;
        this.humidity= humidity;
    }

    public UIModal() {

    }

    public String getTemperature_degree() {
        return temperature_degree;
    }

    public String getTemperature_fah() {
        return temperature_fah;
    }

    public String getCondition() {
        return condition;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setTemperature_degree(String temperature_degree) {
        this.temperature_degree = temperature_degree;
    }

    public void setTemperature_fah(String temperature_fah) {
        this.temperature_fah = temperature_fah;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String toString(){
        return "weather:{\"Condition\":\""+condition+"\",\"wind\":\""+wind+"\",\"humidity\":\""+humidity+"\",\"temp_in_deg\":\""+temperature_degree+"\",\"temp_in_fah\":\""+temperature_fah+"\"}";
    }
}
