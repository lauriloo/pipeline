package ee.meriloo.toru.asjad;

/**
 * Created by Lauri on 30.03.2017.
 */
public class Rectangle {

    private Long longSide;
    private Long shortSide;
    private boolean alongThePipe;
    private Punkt a;
    private Punkt b;
    private Punkt c;
    private Punkt d;


    public Rectangle(Long longSide, Long shortSide) {
        this.longSide = longSide;
        this.shortSide = shortSide;
    }

    public Long getLongSide() {
        return longSide;
    }

    public Long getShortSide() {
        return shortSide;
    }

    public boolean isAlongThePipe() {
        return alongThePipe;
    }

    public void setAlongThePipe(boolean alongThePipe) {
        this.alongThePipe = alongThePipe;
    }

    public Punkt getA() {
        return a;
    }

    public void setA(Punkt a) {
        this.a = a;
    }

    public Punkt getB() {
        return b;
    }

    public void setB(Punkt b) {
        this.b = b;
    }

    public Punkt getC() {
        return c;
    }

    public void setC(Punkt c) {
        this.c = c;
    }

    public Punkt getD() {
        return d;
    }

    public void setD(Punkt d) {
        this.d = d;
    }
}
