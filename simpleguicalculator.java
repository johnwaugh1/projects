package solution;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;

public class Calculator extends JFrame
{
    private JFrame frame;
    private JTextField tf1;
    private JTextField tf2;

    public JFrame getFrame()
    {
        return frame;
    }

    public Calculator()
    {
        frame = new JFrame("Calculator");
        Color color = new Color(42, 117, 58, 100);
        //frame.setBackground(color);

        JPanel main = new JPanel();
        JPanel row1 = new JPanel();
        //row1.setBackground(color);
        JPanel row2 = new JPanel();
       // row2.setBackground(color);
        JPanel row3 = new JPanel();
        //row3.setBackground(color);
        JPanel row4 = new JPanel();
       // row4.setBackground(color);
        JPanel row5 = new JPanel();
       // row5.setBackground(color);


        row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
        row2.setLayout(new BoxLayout(row2, BoxLayout.LINE_AXIS));
        row3.setLayout(new BoxLayout(row3, BoxLayout.LINE_AXIS));
        row4.setLayout(new BoxLayout(row4, BoxLayout.LINE_AXIS));
        row5.setLayout(new BoxLayout(row5, BoxLayout.LINE_AXIS));

        JButton b1, b2, b3, b4, b5;

        b1 = new JButton(" ADD ");
        b1.setMargin(new Insets(5,5,5,5));
        b2 = new JButton(" SUB ");
        b2.setMargin(new Insets(5,5,5,5));
        b3 = new JButton("MULT");
        b3.setMargin(new Insets(5,5,5,5));
        b4 = new JButton(" DIV  ");
        b4.setMargin(new Insets(5,5,5,5));
        b5 = new JButton("CLEAR");
        b5.setMargin(new Insets(5,5,5,5));

        JButton a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;

        a0 = new JButton("0");
        a1 = new JButton("1");
        a2 = new JButton("2");
        a3 = new JButton("3");
        a4 = new JButton("4");
        a5 = new JButton("5");
        a6 = new JButton("6");
        a7 = new JButton("7");
        a8 = new JButton("8");
        a9 = new JButton("9");
        a10 = new JButton(" . ");

        JButton sqrt, sqr;

        sqrt = new JButton(" \u221A");
        sqr = new JButton("^2");

        row1.add(sqrt);
        row1.add(a1);
        row1.add(a2);
        row1.add(a3);
        row1.add(b1);

        row2.add(sqr);
        row2.add(a4);
        row2.add(a5);
        row2.add(a6);
        row2.add(b2);

        row3.add(Box.createHorizontalGlue());
        row3.add(a7);
        row3.add(a8);
        row3.add(a9);
        row3.add(b3);

        row4.add(Box.createHorizontalGlue());
        row4.add(a0);
        row4.add(a10);
        row4.add(b4);

        row5.add(Box.createHorizontalGlue());
        row5.add(b5);

        main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
        main.add(row1);
        main.add(row2);
        main.add(row3);
        main.add(row4);
        main.add(row5);
        //main.setBackground(Color.red);

        frame.add(main, BorderLayout.PAGE_END);

        JPanel rp = new JPanel();
        //rp.setBackground(color);

        JLabel r = new JLabel("Result =");
        r.setName("resultLabel");

        rp.add(r);
        frame.add(rp, BorderLayout.LINE_START);

        JPanel tp = new JPanel();
        //tp.setBackground(color);
        tf1 = new JTextField(10);
        tf1.setName("leftOperand");
        tf2 = new JTextField(10);
        tf2.setName("rightOperand");

        tp.add(tf1);
        tp.add(tf2);
        frame.add(tp, BorderLayout.PAGE_START);

        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    r.setText(String.format("Result = %.2f",
                        Double.parseDouble(tf1.getText())
                            + Double.parseDouble(tf2.getText())));
                }
                catch (Exception a)
                {
                    r.setText("Result = Error");
                }
            }
        });

        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    r.setText(String.format("Result = %.2f",
                        Double.parseDouble(tf1.getText())
                            - Double.parseDouble(tf2.getText())));
                }
                catch (Exception a)
                {
                    r.setText("Result = Error");
                }
            }
        });

        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    r.setText(String.format("Result = %.2f",
                        Double.parseDouble(tf1.getText())
                            * Double.parseDouble(tf2.getText())));
                }
                catch (Exception a)
                {
                    r.setText("Result = Error");
                }
            }
        });

        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if (Double.parseDouble(tf2.getText()) != 0)
                    {
                        r.setText(String.format("Result = %.2f",
                            Double.parseDouble(tf1.getText())
                                / Double.parseDouble(tf2.getText())));
                    }
                    else
                    {
                        r.setText("Result = Error");
                    }

                }
                catch (Exception a)
                {
                    r.setText("Result = Error");
                }
            }
        });

        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                tf1.setText("");
                tf2.setText("");
                r.setText("Result =");
            }

        });

        sqrt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    r.setText(String.format("Result = %.2f", Math.sqrt(
                        Double.parseDouble(tf1.getText()))));

                }
                catch (Exception a)
                {
                    r.setText("Result = Error");
                }
            }
        });

        sqr.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    r.setText(String.format("Result = %.2f", Math.pow(
                        Double.parseDouble(tf1.getText()), 2.0)));

                }
                catch (Exception a)
                {
                    r.setText("Result = Error");
                }
            }
        });

        a0.setAction(new TextAction("0")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a1.setAction(new TextAction("1")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });

        a2.setAction(new TextAction("2")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a3.setAction(new TextAction("3")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a4.setAction(new TextAction("4")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a5.setAction(new TextAction("5")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a6.setAction(new TextAction("6")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a7.setAction(new TextAction("7")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a8.setAction(new TextAction("8")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a9.setAction(new TextAction("9")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        a10.setAction(new TextAction(".")
        {
           
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        });
        
        frame.setSize(251, 250);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
}
