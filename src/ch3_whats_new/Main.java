package ch3_whats_new;

/**
 * Created by cacaegg on 9/11/14.
 */
abstract class PizzaD {
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
        return new Crust();
    }

    @Override
    PizzaD topAwC() {
        return new Crust();
    }

    @Override
    PizzaD subAbC() {
        return new Crust();
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
            return new Cheese(p.remA());
        }

    @Override
    PizzaD topAwC() {
        return new Cheese(p.topAwC());
    }

    @Override
    PizzaD subAbC() {
        return new Cheese(p.subAbC());
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
        return new Olive(p.remA());
    }

    @Override
    PizzaD topAwC() {
        return new Olive(p.topAwC());
    }

    @Override
    PizzaD subAbC() {
        return new Olive(p.subAbC());
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
        return p.remA();
    }

    @Override
    PizzaD topAwC() {
        return new Cheese(new Anchovy(p.topAwC()));
    }

    @Override
    PizzaD subAbC() {
        return new Cheese(p.subAbC());
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
        return new Sausage(p.remA());
    }

    @Override
    PizzaD topAwC() {
        return new Sausage(p.topAwC());
    }

    @Override
    PizzaD subAbC() {
        return new Sausage(p.subAbC());
    }
}

class Spinach extends PizzaD {
    PizzaD p;
    Spinach(PizzaD _p){
        p = _p;
    }
    // ------------------------

    @Override
    PizzaD remA() {
        return new Spinach(p.remA());
    }

    @Override
    PizzaD topAwC() {
        return new Spinach(p.topAwC());
    }

    @Override
    PizzaD subAbC() {
        return new Spinach(p.subAbC());
    }
}

public class Main {
    public static void main(String args[]) {
    System.out.println(
            new Anchovy(new Olive(new Anchovy(new Anchovy(new Cheese(new Crust()))))) + "\n" +
            new Anchovy(new Olive(new Anchovy(new Anchovy(new Cheese(new Crust()))))).remA() + "\n" +
            new Sausage(new Olive(new Anchovy(new Sausage(new Cheese(new Crust()))))).remA() + "\n" +
            new Anchovy(new Crust()).remA() + "\n" +
            new Anchovy(new Anchovy(new Crust())).remA() + "\n" +
            new Olive(new Cheese(new Anchovy(new Anchovy(new Crust())))).remA() + "\n" +
            new Cheese(new Anchovy(new Cheese(new Crust()))).remA() + "\n" +
            (new Olive(new Anchovy(new Cheese(new Anchovy(new Crust())))).remA()).topAwC() + "\n" +
            (new Olive(new Anchovy(new Cheese(new Anchovy(new Crust())))).topAwC()).remA()
    );
    }
}
