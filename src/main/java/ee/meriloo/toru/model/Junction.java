package ee.meriloo.toru.model;

import java.math.BigDecimal;

public class Junction {

    private BigDecimal firstPipeDiameter;
    private BigDecimal secondPipeDiameter;

    public Junction(BigDecimal first, BigDecimal second) {
        firstPipeDiameter = first;
        secondPipeDiameter = second;
    }

    public BigDecimal getFirstPipeDiameter() {
        return firstPipeDiameter;
    }

    public BigDecimal getSecondPipeDiameter() {
        return secondPipeDiameter;
    }

}
