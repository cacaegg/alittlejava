package ch4_come_to_our_carousel;

/**
 * Created by cacaegg on 9/14/14.
 */

abstract class ShishD{
    OnlyOnionsV ooFn = new OnlyOnionsV();
    IsVegetarianV ivFn = new IsVegetarianV();

    public String toString(){
        return "new " + getClass().getName() + "()";
    }
    abstract public boolean onlyOnions();
    abstract public boolean isVegtarian();
}

class Skewer extends ShishD{
    public boolean onlyOnions(){
        return ooFn.forSkewer();
    }

    @Override
    public boolean isVegtarian() {
        return ivFn.forSkewer();
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
        return ooFn.forOnion(s);
    }

    @Override
    public boolean isVegtarian() {
        return ivFn.forOnion(s);
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
        return ooFn.forLamb(s);
    }

    @Override
    public boolean isVegtarian() {
        return ivFn.forLamb(s);
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
        return ooFn.forTomato(s);
    }

    @Override
    public boolean isVegtarian() {
        return ivFn.forTomato(s);
    }

}

class OnlyOnionsV {
    boolean forSkewer(){
        return true;
    }
    boolean forOnion(ShishD s){
        return s.onlyOnions();
    }
    boolean forLamb(ShishD s){
        return false;
    }
    boolean forTomato(ShishD s){
        return false;
    }
}

class IsVegetarianV {
    boolean forSkewer(){
        return true;
    }
    boolean forOnion(ShishD s){
        return s.isVegtarian();
    }
    boolean forLamb(ShishD s){
        return false;
    }
    boolean forTomato(ShishD s){
        return s.isVegtarian();
    }
}

abstract class PizzaD {
    RemAV remFn = new RemAV();
    TopAwCV topFn = new TopAwCV();
    SubAbC subFn = new SubAbC();

    public String toString(){
        return "new " + getClass().getName() + "()";
    }
    abstract PizzaD remA();
    abstract PizzaD topAwC();
    abstract PizzaD subAbC();
}

class Crust extends PizzaD {

    // ----------------------
    @Override
    PizzaD remA() {
        return remFn.forCrust();
    }

    @Override
    PizzaD topAwC() {
        return topFn.forCrust();
    }

    @Override
    PizzaD subAbC() {
        return subFn.forCrust();
    }
}

class Cheese extends PizzaD {
    PizzaD p;
    Cheese(PizzaD _p){
        p = _p;
    }
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + p + ")";
    }

    @Override
    PizzaD remA() {
        return remFn.forCheese(p);
    }

    @Override
    PizzaD topAwC() {
        return topFn.forCheese(p);
    }

    @Override
    PizzaD subAbC() {
        return subFn.forCheese(p);
    }
}

class Olive extends PizzaD {
    PizzaD p;
    Olive(PizzaD _p){
        p = _p;
    }
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + p + ")";
    }

    @Override
    PizzaD remA() {
        return remFn.forOlive(p);
    }

    @Override
    PizzaD topAwC() {
        return topFn.forOlive(p);
    }

    @Override
    PizzaD subAbC() {
        return subFn.forOlive(p);
    }
}

class Anchovy extends PizzaD {
    PizzaD p;
    Anchovy(PizzaD _p){
        p = _p;
    }
    // ----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + p + ")";
    }

    @Override
    PizzaD remA() {
        return remFn.forAnchovy(p);
    }

    @Override
    PizzaD topAwC() {
        return topFn.forAnchovy(p);
    }

    @Override
    PizzaD subAbC() {
        return subFn.forAnchovy(p);
    }
}

class Sausage extends PizzaD {
    PizzaD p;
    Sausage(PizzaD _p){
        p = _p;
    }
    // -----------------------
    public String toString(){
        return "new " + getClass().getName() + "(" + p + ")";
    }

    @Override
    PizzaD remA() {
        return remFn.forSausage(p);
    }

    @Override
    PizzaD topAwC() {
        return topFn.forSausage(p);
    }

    @Override
    PizzaD subAbC() {
        return subFn.forSausage(p);
    }
}

class RemAV {
    PizzaD forCrust(){
        return new Crust();
    }

    PizzaD forCheese(PizzaD p){
        return new Cheese(p.remA());
    }

    PizzaD forOlive(PizzaD p){
        return new Olive(p.remA());
    }

    PizzaD forAnchovy(PizzaD p){
        return p.remA();
    }

    PizzaD forSausage(PizzaD p){
        return new Sausage(p.remA());
    }
}

class TopAwCV{
    PizzaD forCrust(){
        return new Crust();
    }
    PizzaD forCheese(PizzaD p){
        return new Cheese(p.topAwC());
    }
    PizzaD forOlive(PizzaD p){
        return new Olive(p.topAwC());
    }
    PizzaD forAnchovy(PizzaD p){
        return new Cheese(new Anchovy(p.topAwC()));
    }
    PizzaD forSausage(PizzaD p){
        return new Sausage(p.topAwC());
    }
}

class SubAbC{
    PizzaD forCrust(){
        return new Crust();
    }
    PizzaD forCheese(PizzaD p){
        return new Cheese(p.subAbC());
    }
    PizzaD forOlive(PizzaD p){
        return new Olive(p.subAbC());
    }
    PizzaD forAnchovy(PizzaD p){
        return new Cheese(p.subAbC());
    }
    PizzaD forSausage(PizzaD p){
        return new Sausage(p.subAbC());
    }
}

public class Main {
    public static void main(String args[]){
        System.out.println(
            new Onion(new Onion(new Skewer())).onlyOnions() + "\n" +
            new Anchovy(new Olive(new Anchovy(new Cheese(new Crust())))).remA()
        );
    }
}
