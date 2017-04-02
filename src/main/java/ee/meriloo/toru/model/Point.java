package ee.meriloo.toru.model;

import java.math.BigDecimal;

public class Point {

    private BigDecimal xCoord;
    private BigDecimal yCoord;

    public Point(BigDecimal xCoord, BigDecimal yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public BigDecimal getxCoord() {
        return xCoord;
    }

    public void setxCoord(BigDecimal xCoord) {
        this.xCoord = xCoord;
    }

    public BigDecimal getyCoord() {
        return yCoord;
    }

    public void setyCoord(BigDecimal yCoord) {
        this.yCoord = yCoord;
    }
}
