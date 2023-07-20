package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    static Double J;
    private static JButton b;
    static JLabel cur1, cur2, amount, res, textRes;
    private static JTextField  textC1;
    private static JTextField textC2;
    static JTextField textAmount;
    public GUI(String s){
        super(s);
        setLayout(new FlowLayout());

        b = new JButton("Count");
        cur1 = new JLabel("Currency 1");
        cur2 = new JLabel("Currency 2");
        amount = new JLabel("Amount     ");
        res = new JLabel("Result");
        textC1 = new JTextField(10);
        textC2 = new JTextField(10);
        textAmount = new JTextField(10);
        textRes = new JLabel();
        eHendler eHendler = new eHendler();

        add(cur1);
        add(textC1);
        add(cur2);
        add(textC2);
        add(amount);
        add(textAmount);
        add(b);
        add(res);
        add(textRes);
        b.addActionListener(eHendler);
    }
    public  class eHendler implements ActionListener {
        private double j;
        private Currency currency;
        public eHendler(){
            this.currency = currency;
        }

        public void actionPerformed(ActionEvent e) {
            try{
                if(e.getSource() == b){
                    String amountText = textAmount.getText().trim();
                    if(amountText.isEmpty()) {
                        j = Currency.getRate() * Double.parseDouble(amountText);
                        textRes.setText(Double.toString(j));
                        Currency currency = new Currency(Currency.getDate(), Double.toString(Currency.getRate()));
                        Currency.setBoughtAmount(j);
                        currency.getInvoice();
                    }
//                    j = Currency.getRate() * Double.parseDouble(textAmount.getText());
//                    textRes.setText(Double.toString(j));
//                    currency.setBoughtAmount(j);
                   }
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}