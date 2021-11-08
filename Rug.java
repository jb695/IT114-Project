package com.example.assignment1;


public class Rug {


    private String make;
    private String designer;
    private String productcode;
    private double length;
    private double width;
    private int year;
    private double price;
    private String imgurl;


    public Rug(String make, String designer, String productcode, double length, double width, int year, double price, String imgurl) {

        this.make = make;
        this.designer = designer;
        this.productcode = productcode;
        this.length = length;
        this.width = width;
        this.year = year;
        this.price = price;
        this.imgurl = imgurl;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public double getArea() {

        return length * width;

    }

    public int getAge(){

        DateUtil date = new DateUtil();
        return date.get_current_year()- year;

    }






}
