package com.wyu.pojo;
//
public class zyb {
    private int id;
  private String name;
  private String borthday;
  private String degree;
    private String office_major;
    private String performance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorthday() {
        return borthday;
    }

    public void setBorthday(String borthday) {
        this.borthday = borthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOffice_major() {
        return office_major;
    }

    public void setOffice_major(String office_major) {
        this.office_major = office_major;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public zyb() {
    }

    @Override
    public String toString() {
        return "zyb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borthday='" + borthday + '\'' +
                ", degree='" + degree + '\'' +
                ", office_major='" + office_major + '\'' +
                ", performance='" + performance + '\'' +
                '}';
    }

    public zyb(int id, String name, String borthday, String degree, String office_major, String performance) {
        this.id = id;
        this.name = name;
        this.borthday = borthday;
        this.degree = degree;
        this.office_major = office_major;
        this.performance = performance;




    }
}

