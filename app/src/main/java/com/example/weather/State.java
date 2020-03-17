package com.example.weather;

public class State {

private String name;
private  String capital;
private  int flagResource;

public State(String name, String capital, int flagResource){
    this.name=name;
    this.capital=capital;
    this.flagResource=flagResource;
}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}
