package main.java.modal;

public class APIModal {
    private String temperature_deg;
    private String humidty;
    private String wind;

    public APIModal(){

    }
    public APIModal(String temperature_deg,String humidty,String wind){
        this.temperature_deg=temperature_deg;
        this.humidty=humidty;
        this.wind=wind;
    }
    public String getTemperature_deg() {
        return temperature_deg;
    }

    public String getWind() {
        return wind;
    }

    public String getHumidty() {
        return humidty;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setHumidty(String humidty) {
        this.humidty = humidty;
    }

    public void setTemperature_deg(String temperature_deg) {
        this.temperature_deg = temperature_deg;
    }
}
