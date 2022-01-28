package hu.fisherRaceFront.domain;

public class FishList {
    private int id;
    private String race;
    private String picture;
    private int sumWeight;

    public FishList() {
    }

    public FishList(int id, String race, String picture, int sumWeight) {
        this.id = id;
        this.race = race;
        this.picture = picture;
        this.sumWeight = sumWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(int sumWeight) {
        this.sumWeight = sumWeight;
    }
}
