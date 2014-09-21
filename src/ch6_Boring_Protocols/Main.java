package ch6_Boring_Protocols;

/**
 * Created by cacaegg on 9/17/14.
 */
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

abstract class FishD {}

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

abstract interface PieVisitorI{
    abstract PieD forBot();
    abstract PieD forTop(Object t, PieD r);
}

class RemV implements PieVisitorI{
    Object o;
    RemV(Object _o){
        o = _o;
    }

    public PieD forBot(){
        return new Bot();
    }

    public PieD forTop(Object t, PieD r){
        if(t.equals(o)){
            return r.accept(this);
        }else{
            return new Top(t, r.accept(this));
        }
    }
}

class SubstV implements PieVisitorI{
    Object n;
    Object o;
    SubstV(Object _n, Object _o){
        n = _n;
        o = _o;
    }
    // -------------------------------

    public PieD forBot(){
        return new Bot();
    }
    public PieD forTop(Object t, PieD r){
        if(o.equals(t))
            return new Top(n, r.accept(this));
        else
            return new Top(t, r.accept(this));
    }
}

class LtdSubst implements PieVisitorI{
    int i;
    Object n;
    Object o;
    LtdSubst(int _i, Object _n, Object _o){
        i = _i;
        n = _n;
        o = _o;
    }

    @Override
    public PieD forBot() {
        return new Bot();
    }

    @Override
    public PieD forTop(Object t, PieD r) {
        if(i == 0){
            return new Top(t, r);
        }else if(t.equals(o)){
            return new Top(n, r.accept(new LtdSubst(i-1, n, o)));
        }else{
            return new Top(t, r.accept(this));
        }
    }
}

abstract class PieD{
    // RemV remFn = new RemV();
    // SubstV substFn = new SubstV();
    // abstract PieD rem(PieVisitorI remFn);
    // abstract PieD subst(PieVisitorI substFn);
    abstract PieD accept(PieVisitorI ask);
}

class Bot extends PieD{

    // ----------------
    public String toString(){
        return "new " + getClass().getName() + "()";
    }

    /*
    @Override
    PieD rem(PieVisitorI pvFn) {
        return pvFn.forBot();
    }

    @Override
    PieD subst(PieVisitorI pvFn) {
        return pvFn.forBot();
    }
    */

    @Override
    PieD accept(PieVisitorI ask) {
        return ask.forBot();
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

    /*
    @Override
    PieD rem(PieVisitorI pvFn) {
        return pvFn.forTop(t, r);
    }

    @Override
    PieD subst(PieVisitorI pvFn) {
        return pvFn.forTop(t, r);
    }
    */

    @Override
    PieD accept(PieVisitorI ask) {
        return ask.forTop(t, r);
    }
}

public class Main {
    public static void main(String args[]){
        System.out.println(
          new Top(new Anchovy(),
            new Top(new Integer(3),
              new Top(new Zero(),
                new Bot()))).accept(new RemV(new Zero())) + "\n" +
          new Top(new Integer(3),
            new Top(new Integer(2),
              new Top(new Integer(3),
                new Bot()))).accept(new SubstV(new Integer(5), new Integer(3))) + "\n" +
          new Top(new Integer(3),
            new Top(new Integer(2),
              new Top(new Integer(3),
                new Bot()))).accept(new SubstV(new Integer(7), new Integer(2))) + "\n" +
          new Top(new Anchovy(),
            new Top(new Tuna(),
              new Top(new Anchovy(),
                new Top(new Tuna(),
                  new Top(new Anchovy(),
                    new Bot())))))
            .accept(new LtdSubst(2, new Salmon(), new Anchovy()))
        );
    };
}
