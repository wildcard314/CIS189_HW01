package com.example.cis189_hw01;

import java.io.Serializable;

public class ColorInfo implements Serializable
{

    private int red;
    private int blue;
    private int green;
    private String hex;

    public ColorInfo()
    {

    }

    public ColorInfo(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
        hex = String.format("#%02X%02X%02X",r,g,b);

    }

    public int getRed()
    {
        return red;
    }

    public void setRed(int red)
    {
        this.red = red;
    }

    public int getBlue()
    {
        return blue;
    }

    public void setBlue(int blue)
    {
        this.blue = blue;
    }

    public int getGreen()
    {
        return green;
    }

    public void setGreen(int green)
    {
        this.green = green;
    }

    public String getHex()
    {
        return hex;
    }

}
