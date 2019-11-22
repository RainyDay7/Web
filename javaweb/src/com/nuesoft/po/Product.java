package com.nuesoft.po;

public class Product {

    private int pid;
    private String pname;
    private Double price;
    private String  imgurl;
    private String pdesc;
    private int cid;

    public Product() {
    }

    public Product(int pid, String pname, Double price, String imgurl, String pdesc, int cid) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.imgurl = imgurl;
        this.pdesc = pdesc;
        this.cid = cid;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price='" + price + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", cid=" + cid +
                '}';
    }
}
