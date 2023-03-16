package com.wyu.pojo;

public class ysb {
    private int ysbh;
    private String xm;
    private String ks;
    private String sz;
    private String pf;
    private int syrs;
    private int zp;

    public ysb(int ysbh, String xm, String ks, String sz, String pf, int syrs, int zp) {
        this.ysbh = ysbh;
        this.xm = xm;
        this.ks = ks;
        this.sz = sz;
        this.pf = pf;
        this.syrs = syrs;
        this.zp = zp;
    }

    public int getYsbh() {
        return ysbh;
    }

    public void setYsbh(int ysbh) {
        this.ysbh = ysbh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public int getSyrs() {
        return syrs;
    }

    public void setSyrs(int syrs) {
        this.syrs = syrs;
    }

    public int getZp() {
        return zp;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    @Override
    public String toString() {
        return "ysb{" +
                "ysbh=" + ysbh +
                ", xm='" + xm + '\'' +
                ", ks='" + ks + '\'' +
                ", sz='" + sz + '\'' +
                ", pf='" + pf + '\'' +
                ", syrs=" + syrs +
                ", zp=" + zp +
                '}';
    }

    public ysb() {
    }
}