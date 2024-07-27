package com.example.weatherapp;

public class WeatherModel {
    String temp,time,con,icon;

    public WeatherModel(String temp, String time, String con, String icon) {
        this.temp = temp;
        this.time = time;
        this.con = con;
        this.icon = icon;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
