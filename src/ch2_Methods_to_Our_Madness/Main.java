package ch2_Methods_to_Our_Madness;
/**
 * Created by cacaegg on 9/8/14.
 */

abstract class PointD {
    int x;
    int y;
    PointD(int _x, int _y){
        x = _x;
        y = _y;
    }
    // ---------------------------

    abstract int distanceToO();

    boolean closerToO(PointD p){
        return distanceToO() <= p.distanceToO();
    }
}

class CartesianPt extends PointD {
    CartesianPt(int _x, int _y){
        super(_x, _y);
    }
    // ---------------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + x + ", " + y +")";
    }

    @Override
    int distanceToO(){
        return (int) Math.sqrt(x*x + y*y);
    }

}

class ManhattanPt extends PointD {
    ManhattanPt(int _x, int _y){
        super(_x, _y);
    }
    // --------------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + x + ", " + y +")";
    }

    @Override
    int distanceToO() {
        return x + y;
    }



}

abstract class ShishD{
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
    abstract public boolean onlyOnions();
    abstract public boolean isVegtarian();
}

class Skewer extends ShishD{
    public boolean onlyOnions(){
        return true;
    }

    @Override
    public boolean isVegtarian() {
        return true;
    }
}

class Onion extends ShishD{
    ShishD s;
    Onion(ShishD _s){
        s = _s;
    }
    // -------------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + s +")";
    }
    public boolean onlyOnions(){
        return s.onlyOnions();
    }

    @Override
    public boolean isVegtarian() {
        return s.isVegtarian();
    }
}

class Lamb extends ShishD{
    ShishD s;
    Lamb(ShishD _s){
        s = _s;
    }
    // --------------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + s +")";
    }
    public boolean onlyOnions(){
        return false;
    }

    @Override
    public boolean isVegtarian() {
        return false;
    }
}

class Tomato extends ShishD{
    ShishD s;
    Tomato(ShishD _s){
        s = _s;
    }
    // --------------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + s +")";
    }

    @Override
    public boolean onlyOnions() {
        return false;
    }

    @Override
    public boolean isVegtarian() {
        return s.isVegtarian();
    }

}

abstract class KebabD {
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
    abstract public boolean isVeggie();
    abstract public Object whatHolder();
}

class Holder extends KebabD {
    Object o;
    Holder(Object _o){
        o = _o;
    }
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + o +")";
    }

    @Override
    public boolean isVeggie() {
        return true;
    }

    @Override
    public Object whatHolder() {
        return o;
    }
}

class Shallot extends KebabD {
    KebabD k;
    Shallot(KebabD _k){
        k = _k;
    }
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + k +")";
    }

    @Override
    public boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    public Object whatHolder() {
        return k.whatHolder();
    }
}

class Shrimp extends KebabD {
    KebabD k;
    Shrimp(KebabD _k){
        k = _k;
    }
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + k +")";
    }

    @Override
    public boolean isVeggie() {
        return false;
    }

    @Override
    public Object whatHolder() {
        return k.whatHolder();
    }
}

class Radish extends KebabD {
    KebabD k;
    Radish(KebabD _k){
        k = _k;
    }
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + k +")";
    }

    @Override
    public boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    public Object whatHolder() {
        return k.whatHolder();
    }
}

class Pepper extends KebabD {
    KebabD k;
    Pepper(KebabD _k){
        k = _k;
    }
    // -----------------------


    @Override
    public boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    public Object whatHolder() {
        return k.whatHolder();
    }
}

class Zucchini extends KebabD {
    KebabD k;
    Zucchini(KebabD _k){
        k = _k;
    }
    // -----------------------


    @Override
    public boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    public Object whatHolder() {
        return k.whatHolder();
    }
}

abstract class RodD {
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
}

class Dagger extends RodD {}

class Sabre extends RodD {}

class Sword extends RodD {}


abstract class PlateD {
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
}

class Gold extends PlateD {}

class Sliver extends PlateD {}

class Brass extends PlateD {}

class Copper extends PlateD {}

class Wood extends PlateD {}

abstract class NumD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

class Zero extends NumD {}


public class Main {
    public static void main(String args[]){
        ManhattanPt manhattanPt = new ManhattanPt(3, 4);
        CartesianPt cartesianPt = new CartesianPt(3, 4);

        Skewer skewer = new Skewer();
        Onion onion = new Onion(new Skewer());
        Onion onion1 = new Onion(
                            new Lamb(
                                new Onion(
                                    new Skewer())));
        Lamb lamb = new Lamb(new Skewer());
        Onion onion2 = new Onion(
                            new Onion(
                                new Onion(
                                    new Skewer())));

        Tomato tomato = new Tomato(new Skewer());
        Onion onion3 = new Onion(new Tomato(new Skewer()));
        Tomato tomato1 = new Tomato(new Onion(new Tomato(new Skewer())));


        System.out.println(
          manhattanPt.distanceToO() + "\n" +
          cartesianPt.distanceToO() + "\n" +
          skewer + "\n" +
          onion + "\n" +
          onion1 + "\n" +
          skewer.onlyOnions() + "\n" +
          onion.onlyOnions() + "\n" +
          lamb.onlyOnions() + "\n" +
          onion2.onlyOnions() + "\n" +
          onion1.onlyOnions() + "\n" +
          tomato.isVegtarian() + "\n" +
          onion3.isVegtarian() + "\n" +
          tomato1.isVegtarian() + "\n" +
          new Holder(new Dagger()) + "\n" +
          new Holder(new Gold()) + "\n" +
          new Shallot(new Radish(new Holder(new Dagger()))).isVeggie() + "\n" +
          new Shallot(new Radish(new Holder(new Gold()))).isVeggie() + "\n" +
          new Shallot(new Radish(new Holder(new Integer(52)))).isVeggie() + "\n" +
          new Shallot(new Radish(new Holder(new Zero()))).isVeggie() + "\n" +
          new Shallot(new Radish(new Holder(new Boolean(false)))).isVeggie() + "\n" +
          new Shallot(new Radish(new Holder(new Integer(52)))).whatHolder() + "\n" +
          new Shallot(new Radish(new Holder(new Dagger()))).whatHolder() + "\n" +
          new Shallot(new Radish(new Holder(new Gold()))).whatHolder() + "\n" +
          new Holder(new Integer(52)).whatHolder() + "\n" +
          new Holder(new Sword()).whatHolder() + "\n" +
          new Radish(new Shallot(new Shrimp(new Holder(new Integer(52))))).whatHolder() + "\n" +
          new Shallot(new Shrimp(new Holder(new Integer(52)))).whatHolder() + "\n" +
          new Shrimp(new Holder(new Integer(52))).whatHolder() + "\n" +
          new ManhattanPt(3, 4).closerToO(new ManhattanPt(1, 5)) + "\n" +
          new ManhattanPt(1, 5).closerToO(new ManhattanPt(3, 4)) + "\n" +
          new CartesianPt(12, 5).closerToO(new CartesianPt(3, 4)) + "\n" +
          new CartesianPt(3, 4).closerToO(new CartesianPt(12, 5)) + "\n" +
          new CartesianPt(3, 4).closerToO(new ManhattanPt(1, 5))
        );
    }
}
