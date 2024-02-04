package com.caves;

public abstract class Item {
    boolean playerHas;

    public boolean get(){return this.playerHas;}

    public void set(boolean b){this.playerHas = b;}
}
