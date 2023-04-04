package interfata;

import interfata.View;
import polinom.Polynom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model m_model;
    private View m_view;
    public Controller(Model model, View view)
    {
        m_model = model;
        m_view  = view;
        view.addAddListener(new AddListener());
        view.addSubstractListener(new SubtractListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDivideListener(new DivideListener());
        view.addDerivateListener(new DerivateListener());
        view.addIntegrateListener(new IntegrateListener());
        view.addClearListener(new ClearListener());
    }
    class AddListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            String pol1 = "";
            String pol2 = "";
            pol1 = m_view.getUserInput(1);
            Polynom p1=new Polynom();
            pol2 = m_view.getUserInput(2);
            Polynom p2=new Polynom();
            p1.read(pol1);
            p2.read(pol2);
            m_model.addBy(p1,p2);
            m_view.setTotal(m_model.getValue(1));
        }
    }
    class SubtractListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String pol1 = "";
            String pol2 = "";
            pol1 = m_view.getUserInput(1);
            Polynom p1=new Polynom();
            pol2 = m_view.getUserInput(2);
            Polynom p2=new Polynom();
            p1.read(pol1);
            p2.read(pol2);
            m_model.subtractBy(p1,p2);
            m_view.setTotal(m_model.getValue(1));
        }
    }
    class MultiplyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String pol1 = "";
            String pol2 = "";
            pol1 = m_view.getUserInput(1);
            Polynom p1=new Polynom();
            pol2 = m_view.getUserInput(2);
            Polynom p2=new Polynom();
            p1.read(pol1);
            p2.read(pol2);
            m_model.multiplyBy(p1,p2);
            m_view.setTotal(m_model.getValue(1));
        }
    }
    class DivideListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String pol1 = "";
            String pol2 = "";
            pol1 = m_view.getUserInput(1);
            Polynom p1=new Polynom();
            pol2 = m_view.getUserInput(2);
            Polynom p2=new Polynom();
            p1.read(pol1);
            p2.read(pol2);
            Polynom rest=new Polynom();
            m_model.divideBy(p1,p2,rest);
            m_view.setTotal(m_model.getValue(2));
        }
    }
    class DerivateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String pol1 = "";
            pol1 = m_view.getUserInput(1);
            Polynom p1=new Polynom();
            p1.read(pol1);
            m_model.derivateBy(p1);
            m_view.setTotal(m_model.getValue(1));
        }
    }
    class IntegrateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String pol1 = "";
            pol1 = m_view.getUserInput(1);
            Polynom p1=new Polynom();
            p1.read(pol1);
            m_model.integrateBy(p1);
            m_view.setTotal(m_model.getValue(1));
        }
    }
    class ClearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            m_model.reset();
            m_view.reset();
        }
    }
}
