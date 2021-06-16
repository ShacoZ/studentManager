package com.lyd.bean;

import java.util.Date;

public class Product {
    private String nid;
    private String ntitle;
    private double nprice;
    private String nimg;
    private Date createdate;
    public String getNid() {
        return nid;
    }
    public void setNid(String nid) {
        this.nid = nid;
    }
    public String getNtitle() {
        return ntitle;
    }
    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }
    public double getNprice() {
        return nprice;
    }
    public void setNprice(double nprice) {
        this.nprice = nprice;
    }
    public String getNimg() {
        return nimg;
    }
    public void setNimg(String nimg) {
        this.nimg = nimg;
    }
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}
