package com.caves;

import com.caves.items.*;

public class Player {

    // SANDWICHES
    public int sandwiches = 1;
    public void eatSandwich(){
        sandwiches -= 1;
    }
    public void useSandwich(){
        sandwiches -= 1;
    }

    // NAME
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // PHONE
    private Phone phone = new Phone();
    public boolean hasPhone() {
        return this.phone != null;
    }
    public void breakPhone() {
        this.phone = null;
    }

    // GEMSHORN
    private Gemshorn gemshorn;
    public boolean hasGemshorn() {
        return this.gemshorn != null;
    }
    public void receiveGemshorn() {
        this.gemshorn = new Gemshorn();
    }

    // CABLE
    private Cable cable;
    public boolean hasCable() {
        return this.cable != null;
    }
    public void receiveCable() {this.cable = new Cable();}
}
