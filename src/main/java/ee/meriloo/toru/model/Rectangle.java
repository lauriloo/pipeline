package ee.meriloo.toru.model;

public class Rectangle {

    private Double length;
    private Double width;
    private Point leftDownCornerA;
    private Point rightDownCornerB;
    private Point leftUpCornerC;
    private Point rightUpCornerD;


    public Rectangle(Double length, Double shortSide) {
        this.length = length;
        this.width = shortSide;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
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
