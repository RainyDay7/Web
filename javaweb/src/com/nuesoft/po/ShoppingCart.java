package com.nuesoft.po;

public class ShoppingCart {

    private int carid;
    private int  pid;
    private String pname;
    private double price;
    private int count;
    private String imgurl;
    private int uid;

    public ShoppingCart() {
    }

    public ShoppingCart(int carid, int pid, String pname, double price, int count, String imgurl, int uid) {
        this.carid = carid;
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.count = count;
        this.imgurl = imgurl;
        this.uid = uid;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "carid=" + carid +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", imgurl='" + imgurl + '\'' +
                ", uid=" + uid +
                '}';
    }
}
