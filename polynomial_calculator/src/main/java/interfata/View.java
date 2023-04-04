package interfata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame{
        private JTextField m_pol1 = new JTextField(20);
        private JTextField m_pol2 = new JTextField(20);
        private JTextField m_result = new JTextField(20);
        private JButton m_addBtn = new JButton("Add");
        private JButton m_substractBtn = new JButton("Substract");
        private JButton m_multiplyBtn = new JButton("Multiply");
        private JButton m_divideBtn = new JButton("Divide");
        private JButton m_derivateBtn = new JButton("Derivate");
        private JButton m_integrateBtn = new JButton("Integrate");
        private JButton m_clearBtn = new JButton("Clear");
        private Model m_model;
        public View(Model model)
        {
                m_model = model;
                m_result.setEditable(false);
                JPanel content = new JPanel();
                content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
                JPanel content1 = new JPanel(new GridLayout(1, 2, 5, 5));
                content1.setBackground(Color.pink);
                Color c = new Color(255,102,102);
                content.setBackground(Color.pink);
                this.setBackground(Color.pink);
                JLabel a = new JLabel("First polynom");
                a.setBounds(70,160,200,20);
                JLabel b = new JLabel("Second polynom");
                b.setBounds(70,200,200,20);
                JLabel d = new JLabel("Result");
                d.setBounds(200,430,500,20);
                content1.add(a);
                m_pol1.setPreferredSize(new Dimension(200, 20));
                content1.add(m_pol1);
                JPanel content2 = new JPanel(new GridLayout(1, 2, 5, 5));
                content2.setBackground(Color.pink);
                content2.add(b);
                m_pol2.setBounds(260,190,600,10);
                content2.add(m_pol2);
                JPanel content3 = new JPanel(new GridLayout(1, 2, 5, 5));
                content3.setBackground(Color.pink);
                content3.add(d);
                m_result.setBounds(300,430,500,10);
                m_result.setBackground(Color.WHITE);
                content3.add(m_result);
                JPanel content4 = new JPanel(new GridLayout(1, 2, 5, 5));
                content4.setBackground(Color.pink);
                m_addBtn.setBackground(c);
                m_substractBtn.setBackground(c);
                m_multiplyBtn.setBackground(c);
                m_divideBtn.setBackground(c);
                m_derivateBtn.setBackground(c);
                m_integrateBtn.setBackground(c);
                m_clearBtn.setBackground(c);

                m_addBtn.setBounds(200, 280, 230, 20);
                m_substractBtn.setBounds(500, 280, 230, 20);
                m_multiplyBtn.setBounds(200, 310, 230, 20);
                m_divideBtn.setBounds(500, 310, 230, 20);
                m_derivateBtn.setBounds(200, 340, 230, 20);
                m_integrateBtn.setBounds(500, 340, 230, 20);

                content4.add(m_addBtn);
                content4.add(m_substractBtn);
                content4.add(m_multiplyBtn);
                content4.add(m_divideBtn);
                content4.add(m_derivateBtn);
                content4.add(m_integrateBtn);
                content4.add(m_clearBtn);

                content.add(content1);
                content.add(content2);
                content.add(content3);
                content.add(content4);
                this.add(content);
                this.setContentPane(content);
                this.pack();
                this.setTitle("polinom.Polynom calculator");
                this.setSize(700,380);
                content.setSize(700,380);
                this.setResizable(false);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        void reset()
        {
                m_result.setText("");
                m_pol1.setText("");
                m_pol2.setText("");
        }
        String getUserInput(int n)
        {
                if(n==1)
                        return m_pol1.getText();
                else
                        return m_pol2.getText();
        }
        void setTotal(String newTotal) {
                m_result.setText(newTotal);
        }
        void showError(String errMessage) {
                JOptionPane.showMessageDialog(this, errMessage);
        }
        void addAddListener(ActionListener mal) {
                m_addBtn.addActionListener(mal);
        }
        void addSubstractListener(ActionListener mal) { m_substractBtn.addActionListener(mal); }
        void addMultiplyListener(ActionListener mal) {
                m_multiplyBtn.addActionListener(mal);
        }
        void addDivideListener(ActionListener mal) {
                m_divideBtn.addActionListener(mal);
        }
        void addDerivateListener(ActionListener mal) { m_derivateBtn.addActionListener(mal); }
        void addIntegrateListener(ActionListener mal) { m_integrateBtn.addActionListener(mal); }
        void addClearListener(ActionListener cal) {
                m_clearBtn.addActionListener(cal);
        }

}
