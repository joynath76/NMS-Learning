package com.java.streamAPI;

import com.java.streamAPI.App.Color;

public class Dress {
    private String name;
    private int size;
    private Color color;

    
    public Dress(String name, int size, Color color) {
        this.name = name;
        this.size = size;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    
}
