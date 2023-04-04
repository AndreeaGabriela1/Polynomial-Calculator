import org.junit.*;
import interfata.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import polinom.Polynom;

public class PolynomTest {
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;
    public PolynomTest()
    {
        System.out.println("S-a executat un test!");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
    }
    @Test
    public void testAddBy() {
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        Polynom rez;
        p1.read("1x^2-1x^0");
        p2.read("1x^1+1x^0");
        rez = p1.add(p2);
        String t = rez.afis();
        Assertions.assertNotNull(t);
        Assertions.assertEquals(t,"0*x^0 + 1*x^1 + 1*x^2");
        nrTesteCuSucces++;
    }
    @Test
    public void testSubtractBy() {
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        Polynom rez;
        p1.read("1x^2-1x^0");
        p2.read("1x^1+1x^0");
        rez = p1.substract(p2);
        String t = rez.afis();
        Assertions.assertNotNull(t);
        Assertions.assertEquals(t,"-2*x^0 + 1*x^1 + 1*x^2");
        nrTesteCuSucces++;
    }
    @Test
    public void testMultiplyBy() {
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        Polynom rez;
        p1.read("1x^2-1x^0");
        p2.read("1x^1+1x^0");
        rez = p1.multiply(p2);
        String t = rez.afis();
        Assertions.assertNotNull(t);
        Assertions.assertEquals(t,"-1*x^0 + -1*x^1 + 1*x^2 + 1*x^3");
        nrTesteCuSucces++;
    }
    @Test
    public void testDivideBy() {
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        Polynom rez;
        Polynom rest = new Polynom();
        p1.read("1x^2-1x^0");
        p2.read("1x^1+1x^0");
        rez = p1.divide(p2,rest);
        String t = "cat: "+rez.afis()+" rest: "+rest.afis();
        Assertions.assertNotNull(t);
        Assertions.assertEquals(t,"cat: -1*x^0 + 1*x^1 rest: 0.0");
        nrTesteCuSucces++;
    }
    @Test
    public void testDerivateBy() {
        Polynom p1 = new Polynom();
        Polynom rez;
        p1.read("1x^2-1x^0");
        rez = p1.derivate();
        String t = rez.afis();
        Assertions.assertNotNull(t);
        Assertions.assertEquals(t," + 2*x^1");
        nrTesteCuSucces++;
    }
    @Test
    public void testIntegrateBy() {
        Polynom p1 = new Polynom();
        Polynom rez;
        p1.read("1x^2-1x^0");
        rez = p1.integrate();
        String t = rez.afis();
        Assertions.assertNotNull(t);
        Assertions.assertEquals(t,"C*x^0 + -1*x^1 + 0,33*x^3");
        nrTesteCuSucces++;
    }
}
