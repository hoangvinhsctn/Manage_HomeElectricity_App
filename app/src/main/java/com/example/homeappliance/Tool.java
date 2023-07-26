package com.example.homeappliance;

import java.io.Serializable;

public class Tool implements Serializable {
    private String name;
    private Double p;
    private Double t;

    public Tool(String name, Double p, Double t) {
        this.name = name;
        this.p = p;
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getT() {
        return t;
    }

    public void setT(Double t) {
        this.t = t;
    }

    public Double getPt(){
        return p * t;
    }
}
