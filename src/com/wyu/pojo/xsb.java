package com.wyu.pojo;

public class xsb {

            private int xh;
            private String xm;
            private int mm;
            private String xb;
            private  String cssj;
            private String zy_id;
            private String zxf;
            private String bz;
            private String zp;

    public xsb(int xh, String xm, int mm, String xb, String cssj, String zy_id, String zxf, String bz, String zp) {
        this.xh = xh;
        this.xm = xm;
        this.mm = mm;
        this.xb = xb;
        this.cssj = cssj;
        this.zy_id = zy_id;
        this.zxf = zxf;
        this.bz = bz;
        this.zp = zp;
    }

    public xsb() {
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getCssj() {
        return cssj;
    }

    public void setCssj(String cssj) {
        this.cssj = cssj;
    }

    public String getZy_id() {
        return zy_id;
    }

    public void setZy_id(String zy_id) {
        this.zy_id = zy_id;
    }

    public String getZxf() {
        return zxf;
    }

    public void setZxf(String zxf) {
        this.zxf = zxf;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    @Override
    public String toString() {
        return "xsb{" +
                "xh=" + xh +
                ", xm='" + xm + '\'' +
                ", mm=" + mm +
                ", xb='" + xb + '\'' +
                ", cssj='" + cssj + '\'' +
                ", zy_id='" + zy_id + '\'' +
                ", zxf='" + zxf + '\'' +
                ", bz='" + bz + '\'' +
                ", zp='" + zp + '\'' +
                '}';
    }
}
