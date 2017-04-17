package com.example.recyclerview;

/**
 * Created by 98613 on 2017/3/24 0024.
 */


public class Fruit1 {

    private String name;

    private String chinesename;

    private String number;

    private String shape;

    private String colour;

    private int imageId;

    public Fruit1(String chinesename,String name, int imageId,String number, String shape, String colour) {
        this.chinesename = chinesename;
        this.name = name;
        this.imageId = imageId;
        this.number = number;
        this.shape = shape;
        this.colour = colour;
    }

    public  String getChinesename(){
        return chinesename;
    }

    public String getNumber(){
        return number;
    }

    public String getShape(){
        return shape;
    }

    public String getColour(){
        return colour;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}
