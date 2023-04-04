package polinom;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polynom
{
    private Map<Integer,Double> p;
    public Polynom(){
        this.p=new HashMap<>();
    }
    public Polynom(Map<Integer,Double> t)
    {
        this.p=t;
    }
    public void read(String s)
    {
        Pattern pattern = Pattern.compile("([+-]?\\d*\\.?\\d*)\\*?[xX]\\^(\\d+)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            double coeff = Double.parseDouble(matcher.group(1));
            int exponent = Integer.parseInt(matcher.group(2));
            this.p.put(exponent,coeff);
        }

    }
    public Polynom add(Polynom b)
    {
        Polynom sum=new Polynom();
        for (int exp : this.p.keySet())
        {
            double coeff = this.p.get(exp);
            sum.p.put(exp, coeff);
        }
        for (int exp : b.p.keySet())
        {
            double coeff = b.p.get(exp);
            if (sum.p.containsKey(exp))
            {
                coeff += sum.p.get(exp);
            }
            sum.p.put(exp, coeff);
        }
        return sum;
    }
    public Polynom substract(Polynom b)
    {
        Polynom sub=new Polynom();
        for (int exp : this.p.keySet())
        {
            double coeff = this.p.get(exp);
            sub.p.put(exp, coeff);
        }
        for (int exp : b.p.keySet())
        {
            double coeff = b.p.get(exp);
            if (sub.p.containsKey(exp))
            {
                coeff = sub.p.get(exp) - coeff;
            }
            sub.p.put(exp, coeff);
        }
        return sub;
    }
    public Polynom multiply(Polynom b)
    {
        Polynom product = new Polynom();
        for(int exp:this.p.keySet())
        {
            double coeff1 = this.p.get(exp);
            for(int exp1:b.p.keySet())
            {
                double coeff2 = b.p.get(exp1);
                coeff2 *= coeff1;

                if(product.p.get(exp+exp1)!=null)
                {
                    double coeff3=product.p.get(exp+exp1);
                    coeff3+=coeff2;
                    product.p.put(exp+exp1,coeff3);
                }
                else
                    product.p.put(exp+exp1,coeff2);
            }
        }
        return product;
    }
    public int degree()
    {
        int c=0;
        for (int exp:this.p.keySet())
        {
            if(this.p.get(exp)!=0.0 && exp>=0)
                c=exp;
        }
        return c;
    }
    public Polynom divide(Polynom b, Polynom r)
    {
        double[] dividend = new double[this.degree()+1];
        double[] divisor = new double[b.degree()+1];
        for(int exp:this.p.keySet())
        {
            if (this.p.get(exp) != 0)
                dividend[exp] = this.p.get(exp);
            else
                dividend[exp] = 0.0;
        }
        for(int exp:b.p.keySet())
        {
            if (b.p.get(exp) != 0)
                divisor[exp] = b.p.get(exp);
            else
                divisor[exp] = 0.0;
        }
        int dividendDegree = dividend.length - 1;
        int divisorDegree = divisor.length - 1;
        if (divisorDegree <= 0 || dividendDegree < divisorDegree) {
            System.out.println("Divizorul este invalid sau gradul acestuia este mai mare decât gradul dividentului.");
        }
        double[] remainder = new double[dividendDegree + 1];
        System.arraycopy(dividend, 0, remainder, 0, dividendDegree + 1);
        double[] quotient = new double[dividendDegree - divisorDegree + 1];
        for (int i = dividendDegree - divisorDegree; i >= 0; i--)
        {
            quotient[i] = remainder[i + divisorDegree] / divisor[divisorDegree];
            for (int j = 0; j <= divisorDegree; j++) {
                remainder[i + j] -= quotient[i] * divisor[j];
            }
        }
        Polynom q = new Polynom();
        for (int i = quotient.length - 1; i >= 0; i--) {
            q.p.put(i,quotient[i]);
        }
        for (int i = remainder.length - 1; i >= 0; i--) {
            r.p.put(i,remainder[i]);
        }
        return q;
    }
    public Polynom derivate()
    {
        Polynom d=new Polynom();
        for(int exp:this.p.keySet())
        {
            if(exp>0)
            {
                double coeff = this.p.get(exp) * exp;
                d.p.put(exp-1,coeff);
            }
        }
        return d;
    }
    public Polynom integrate()
    {
        Polynom i=new Polynom();
        for(int exp:this.p.keySet())
        {
            double coeff = this.p.get(exp) / (exp+1);
            i.p.put(exp+1,coeff);
        }
        i.p.put(0,666.6666);
        return i;
    }
    public String afis()
    {
        String s="";
        int c=0;
        for (int exp : this.p.keySet())
            if(this.p.get(exp)!=0.0)
                c=1;
        if(c==1)
        {
            for (int exp : this.p.keySet())
            {
                double coeff = this.p.get(exp);
                if(exp!=0)
                    s = s + " + ";
                if(coeff==666.6666)
                    s = s + "C*x^" + exp;
                else
                {
                    DecimalFormat df = new DecimalFormat("#.##");
                    String nr = df.format(coeff);
                    s = s + nr + "*x^" + exp;
                }
            }
        }
        else
            s="0.0";
        return s;
    }
}
