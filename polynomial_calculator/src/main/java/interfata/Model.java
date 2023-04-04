package interfata;

import polinom.Polynom;

import java.util.Map;

public class Model {
    static final String INITIAL_VALUE = "0";
    //static final Map<Integer,Double> INITIAL_VALUE = null;
    private Polynom m_total;  // The total current value state.
    private Polynom m_rest;
    public Model() {
        reset();
    }
    public void reset() {
        m_total = new Polynom();
    }
    public void addBy(Polynom p1,Polynom p2) {m_total = p1.add(p2);}
    public void subtractBy(Polynom p1,Polynom p2) {m_total = p1.substract(p2);}
    public void multiplyBy(Polynom p1, Polynom p2) { m_total = p1.multiply(p2);}
    public void divideBy(Polynom p1, Polynom p2, Polynom rest) { m_total = p1.divide(p2,rest); m_rest = rest;}
    public void derivateBy(Polynom p1) { m_total = p1.derivate();}
    public void integrateBy(Polynom p1) { m_total = p1.integrate();}
    public void setValue(Map<Integer, Double> p1) {m_total = new Polynom(p1);}
    public String getValue(int a)
    {
        if (a==1)
            return m_total.afis();
        else
            return "cat: " + m_total.afis() + " rest: " + m_rest.afis();
    }
}
