package com.wyu.pojo;

public class ghb {
    private String username;
    private String sj;
    private String hospital;
    private String office;
    private String doctor;
    private String reason;

    public ghb(String username, String sj, String hospital, String office, String doctor, String reason) {
        this.username = username;
        this.sj = sj;
        this.hospital = hospital;
        this.office = office;
        this.doctor = doctor;
        this.reason = reason;
    }

    public ghb() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ghb{" +
                "username='" + username + '\'' +
                ", sj='" + sj + '\'' +
                ", hospital='" + hospital + '\'' +
                ", office='" + office + '\'' +
                ", doctor='" + doctor + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
