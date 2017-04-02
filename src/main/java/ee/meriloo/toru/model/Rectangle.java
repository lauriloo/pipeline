package ee.meriloo.toru.model;

import java.math.BigDecimal;

public class Rectangle {

    private BigDecimal length;
    private BigDecimal width;
    private Point leftDownCornerA;
    private Point rightDownCornerB;
    private Point leftUpCornerC;
    private Point rightUpCornerD;


    public Rectangle(BigDecimal length, BigDecimal shortSide) {
        this.length = length;
        this.width = shortSide;
    }

    public BigDecimal getLength() {
        return length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public Point getLeftDownCornerA() {
        return leftDownCornerA;
    }

    public void setLeftDownCornerA(Point leftDownCornerA) {
        this.leftDownCornerA = leftDownCornerA;
    }

    public Point getRightDownCornerB() {
        return rightDownCornerB;
    }

    public void setRightDownCornerB(Point rightDownCornerB) {
        this.rightDownCornerB = rightDownCornerB;
    }

    public Point getLeftUpCornerC() {
        return leftUpCornerC;
    }

    public void setLeftUpCornerC(Point leftUpCornerC) {
        this.leftUpCornerC = leftUpCornerC;
    }

    public Point getRightUpCornerD() {
        return rightUpCornerD;
    }

    public void setRightUpCornerD(Point rightUpCornerD) {
        this.rightUpCornerD = rightUpCornerD;
    }
}
