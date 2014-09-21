package ch1_modern_toys;

/**
 * Created by cacaegg on 9/8/14.
 */

abstract class SeasoningD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

class Salt extends SeasoningD {}

class Pepper extends SeasoningD {}

class Thyme extends SeasoningD {}

class Sage extends SeasoningD {}

abstract class PointD {
}

class CartesianPt extends PointD {
    int x;
    int y;
    CartesianPt(int _x, int _y){
        x = _x;
        y = _y;
    }
    // ---------------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + x + ", " + y +")";
    }
}

class ManhattanPt extends PointD {
    int x;
    int y;
    ManhattanPt(int _x, int _y){
        x = _x;
        y = _y;
    }
    // --------------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + x + ", " + y +")";
    }
}

abstract class NumD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

class Zero extends NumD {}

class OneMoreThan extends NumD {
    NumD predecessor;
    OneMoreThan(NumD _p){
        predecessor = _p;
    }
    // --------------------------
    public String toString() {
        return "new " + getClass().getName() + "(" + predecessor +")";
    }
}

abstract class LayerD {}

class Base extends LayerD {
    Object o;
    Base(Object _o){
        o = _o;
    }
    // --------------------------
    public String toString() {
        return "new " + getClass().getName() + "(" + o +")";
    }
}

class Slice extends LayerD {
    LayerD l;
    Slice(LayerD _l){
        l = _l;
    }
    // --------------------------
    public String toString() {
        return "new " + getClass().getName() + "(" + l +")";
    }
}

public class Main {
    public static void main(String args[]){
        Salt salt = new Salt();
        Pepper pepper = new Pepper();
        Thyme thyme = new Thyme();
        Sage sage = new Sage();

        CartesianPt cartesianPt = new CartesianPt(2,3);
        ManhattanPt manhattanPt = new ManhattanPt(2,3);

        Zero zero = new Zero();
        OneMoreThan oneMoreThan = new OneMoreThan(new Zero());
        OneMoreThan oneMoreThan1 = new OneMoreThan(new OneMoreThan(new Zero()));

        Base base = new Base(new Zero());
        Base base1 = new Base(new Salt());
        Base base2 = new Base(new Integer(5));
        Base base3 = new Base(new Boolean(false));

        System.out.println(
            salt + "\n" +
            pepper + "\n" +
            thyme + "\n" +
            sage + "\n" +
            cartesianPt + "\n" +
            manhattanPt + "\n" +
            zero + "\n" +
            oneMoreThan + "\n" +
            oneMoreThan1 + "\n" +
            base + "\n" +
            base1 + "\n" +
            base2 + "\n" +
            base3
        );
    }
}
