package ch7_oh_my;

/**
 * Created by cacaegg on 9/20/14.
 */
abstract class FruitD {
    // ----------------
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
}

class Peach extends FruitD {
    public boolean equals(Object o){
        return (o instanceof Peach);
    }
}

class Apple extends FruitD {
    public boolean equals(Object o){
        return (o instanceof Apple);
    }
}

class Pear extends FruitD {
    public boolean equals(Object o){
        return (o instanceof Pear);
    }
}

class Lemon extends FruitD {
    public boolean equals(Object o){
        return (o instanceof Lemon);
    }
}

class Fig extends FruitD {
    public boolean equals(Object o){
        return (o instanceof Fig);
    }
}

abstract class TreeD {}

class Bud extends TreeD {
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
}

class Flat extends TreeD {
    FruitD f;
    TreeD t;
    Flat(FruitD _f, TreeD _t){
        f = _f;
        t = _t;
    }
    // -----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + o + ", " + t + ")";
    }
}

class Split extends TreeD {
    TreeD l;
    TreeD r;
    Split(TreeD _l, TreeD _r){
        l = _l;
        r = _r;
    }
    // -----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + l + ", " + r + ")";
    }
}

public class Main {
    public static void main(String args[]) {
        System.out.println();
    }
}
