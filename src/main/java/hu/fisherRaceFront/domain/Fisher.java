package hu.fisherRaceFront.domain;

public class Fisher {
    private int startNumber;
    private String name;
    private String country;
    private String picture;

    public Fisher(int startNumber, String name, String country, String picture) {
        this.startNumber = startNumber;
        this.name = name;
        this.country = country;
        this.picture = picture;
    }

    public Fisher(int startNumber, String country) {
        this.startNumber = startNumber;
        this.country = country;
    }

    public Fisher() {
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
