package ee.meriloo.toru.model;

public class PipeJunction {

    private Double firstPipeDiameter;
    private Double secondPipeDiameter;

    public PipeJunction(Double first, Double second) {
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
