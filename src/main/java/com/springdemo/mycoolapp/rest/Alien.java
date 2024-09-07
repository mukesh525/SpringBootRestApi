package com.springdemo.mycoolapp.rest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")// this will  generate object at run time
public class Alien {

    private int aid;
    private String  name;
    private String  tech;

    public Alien() {
        System.out.println("Object Created");
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public  void  show(){
        System.out.println("In show");
    }
}
