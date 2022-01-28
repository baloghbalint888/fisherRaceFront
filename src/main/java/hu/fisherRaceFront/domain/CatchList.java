package hu.fisherRaceFront.domain;

public class CatchList {
    private String fishName;
    private int sumWeight;

    public CatchList(String fishName, int sumWeight) {
        this.fishName = fishName;
        this.sumWeight = sumWeight;
    }

    public CatchList() {
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public int getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(int sumWeight) {
        this.sumWeight = sumWeight;
    }
}
