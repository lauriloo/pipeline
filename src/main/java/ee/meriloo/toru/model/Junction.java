package ee.meriloo.toru.model;

public class Junction {

    private Double firstPipeDiameter;
    private Double secondPipeDiameter;

    public Junction(Double first, Double second) {
        firstPipeDiameter = first;
        secondPipeDiameter = second;
    }

    public Double getFirstPipeDiameter() {
        return firstPipeDiameter;
    }

    public Double getSecondPipeDiameter() {
        return secondPipeDiameter;
    }

}
