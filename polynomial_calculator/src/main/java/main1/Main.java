package main1;
import polinom.Polynom;
import interfata.View;
import interfata.Model;
import interfata.Controller;

public class Main
{
    public static void main(String[] args)
    {
        Model m=new Model();
        View v=new View(m);
        Controller c=new Controller(m,v);
        v.setVisible(true);
    }
}