package com.example.exptriate;

public class shapes {

    private String shapename; //textview
    private int shapeimage;  //imageview
    private String type;

    public shapes(String shapename, int shapeimage, String type) {
        this.shapename = shapename;
        this.shapeimage = shapeimage;
        this.type = type;
    }

    public String getShapename() {
        return shapename;
    }

    public void setShapename(String shapename) {
        this.shapename = shapename;
    }

    public int getShapeimage() {
        return shapeimage;
    }

    public void setShapeimage(int shapeimage) {
        this.shapeimage = shapeimage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}