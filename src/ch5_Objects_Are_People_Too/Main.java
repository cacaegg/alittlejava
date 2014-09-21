package ch5_Objects_Are_People_Too;

/**
 * Created by cacaegg on 9/15/14.
 */
abstract class PieD {
    RemAV raFn = new RemAV();
    abstract PieD remA();


    RemFishV rfFn = new RemFishV();
    abstract PieD remFish(FishD f);

    RemIntV riFn = new RemIntV();
    abstract PieD remInt(Integer i);

    RemV remFn = new RemV();
    abstract PieD rem(Object o);

    SubstFishV sfFn = new SubstFishV();
    abstract PieD substFish(FishD n, FishD o);

    SubstIntV siFn = new SubstIntV();
    abstract PieD substInt(Integer n, Integer o);

    SubstV substFn = new SubstV();
    abstract PieD subst(Object n, Object o);
}

class Bot extends PieD{
    // ----------------
    public String toString(){
        return "new " + getClass().getName() + "()";
    }

    @Override
    PieD remA() {
        return raFn.forBot();
    }

    @Override
    PieD remFish(FishD f) {
        return rfFn.forBot(f);
    }

    @Override
    PieD remInt(Integer i) {
        return riFn.forBot(i);
    }

    @Override
    PieD rem(Object o) {
        return remFn.forBot(o);
    }

    @Override
    PieD substFish(FishD n, FishD o) {
        return sfFn.forBot(n, o);
    }

    @Override
    PieD substInt(Integer n, Integer o) {
        return siFn.forBot(n, o);
    }

    @Override
    PieD subst(Object n, Object o) {
        return substFn.forBot(n, o);
    }
}

class Top extends PieD{
    Object t;
    PieD r;
    Top(Object _t, PieD _r){
        t = _t;
        r = _r;
    }
    // -----------------
    public String toString(){
        return "new " + getClass().getName() + "(" + t + ", " + r + ")";
    }

    @Override
    PieD remA() {
        return raFn.forTop(t, r);
    }

    @Override
    PieD remFish(FishD f) {
        return rfFn.forTop(t, r, f);
    }

    @Override
    PieD remInt(Integer i) {
        return riFn.forTop(t, r, i);
    }

    @Override
    PieD rem(Object o) {
        return remFn.forTop(t, r, o);
    }

    @Override
    PieD substFish(FishD n, FishD o) {
        return sfFn.forTop(t, r, n, o);
    }

    @Override
    PieD substInt(Integer n, Integer o) {
        return siFn.forTop(t, r, n, o);
    }

    @Override
    PieD subst(Object n, Object o) {
        return substFn.forTop(t, r, n, o);
    }
}

abstract class FishD {
}

class Anchovy extends FishD {
    public String toString(){
        return "new " + getClass().getName() + "()";
    }

    public boolean equals(Object o){
        return (o instanceof Anchovy);
    }

}

class Salmon extends FishD {
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
    public boolean equals(Object o){
        return (o instanceof Salmon);
    }
}

class Tuna extends FishD {
    public String toString(){
        return "new " + getClass().getName() + "()";
    }
    public boolean equals(Object o){
        return (o instanceof Tuna);
    }
}

class RemAV {
    PieD forBot(){
        return new Bot();
    }

    PieD forTop(Object t, PieD r){
        if(new Anchovy().equals(t)){
            return r.remA();
        }else {
            return new Top(t, r.remA());
        }
    }
}

class RemFishV {
    PieD forBot(FishD f){
        return new Bot();
    }

    PieD forTop(Object t, PieD r, FishD f){
        if(f.equals(t)){
            return r.remFish(f);
        }else{
            return new Top(t, r.remFish(f));
        }
    }
}

class RemIntV{
    PieD forBot(Integer i){
        return new Bot();
    }

    PieD forTop(Object t, PieD r, Integer i){
        if(t.equals(i)){
            return r.remInt(i);
        }else{
            return new Top(t, r.remInt(i));
        }
    }
}

class RemV{
    PieD forBot(Object o){
        return new Bot();
    }

    PieD forTop(Object t, PieD r, Object o){
        if(t.equals(o)){
            return r.rem(o);
        }else{
            return new Top(t, r.rem(o));
        }
    }
}

abstract class NumD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

class OneMoreThan extends NumD{
    NumD predecessor;
    OneMoreThan(NumD _p){
        predecessor = _p;
    }
    // ------------------------
    public boolean equals(Object o){
        if(o instanceof OneMoreThan){
            return predecessor.equals(
                    ((OneMoreThan) o).predecessor);
        }else{
            return false;
        }
    }
}

class Zero extends NumD {
    public boolean equals(Object o){
        return (o instanceof Zero);
    }
}

class SubstFishV {
    PieD forBot(FishD n, FishD o){
        return new Bot();
    }

    PieD forTop(Object t, PieD r, FishD n, FishD o){
        if(o.equals(t))
            return new Top(n, r.substFish(n, o));
        else
            return new Top(t, r.substFish(n, o));
    }
}

class SubstIntV{
    PieD forBot(Integer n, Integer o){
        return new Bot();
    }
    PieD forTop(Object t, PieD r, Integer n, Integer o){
        if(o.equals(t))
            return new Top(n, r.substInt(n, o));
        else
            return new Top(t, r.substInt(n, o));
    }
}

class SubstV{
    PieD forBot(Object n, Object o){
        return new Bot();
    }
    PieD forTop(Object t, PieD r, Object n, Object o){
        if(o.equals(t))
            return new Top(n, r.subst(n, o));
        else
            return new Top(t, r.subst(n, o));
    }
}

public class Main {
    public static void main(String args[]){
        System.out.println(
            new Top(new Anchovy(),
              new Top(new Tuna(),
                new Top(new Anchovy(),
                  new Bot()))) + "\n" +
            new Top(new Tuna(),
              new Top(new Integer(42),
                new Top(new Anchovy(),
                  new Top(new Integer(5),
                    new Bot())))) + "\n" +
            new Top(new Anchovy(),
              new Bot()).remFish(new Anchovy()) + "\n" +
            new Top(new Integer(2),
              new Top(new Integer(3),
                new Top(new Integer(2),
                  new Bot()))).remInt(new Integer(3)) + "\n" +
            new Top(new Integer(2),
              new Top(new Integer(3),
                new Top(new Integer(2),
                  new Bot()))).rem(new Integer(3)) + "\n" +
            new Top(new Anchovy(),
              new Bot()).rem(new Anchovy()) + "\n" +
            new Top(new Anchovy(),
              new Top(new Integer(3),
                new Top(new Zero(),
                  new Bot()))).rem(new Integer(3)) + "\n" +
            new Top(new Anchovy(),
              new Top(new Integer(3),
                new Top(new Zero(),
                  new Bot()))).rem(new Zero()) + "\n" +
            new Top(new Integer(3),
              new Top(new Integer(2),
                new Top(new Integer(3),
                  new Bot()))).subst(new Integer(5), new Integer(3)) + "\n" +
            new Top(new Anchovy(),
              new Top(new Tuna(),
                new Top(new Anchovy(),
                  new Bot()))).subst(new Salmon(), new Anchovy())
        );
    }
}
