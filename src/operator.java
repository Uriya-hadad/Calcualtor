import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class operator extends JPanel {
    private final JButton plus, minus, multi, divide;
    static double result = 0;

    enum op_numbers {
        plus, minus, multi, divide
    }

    public operator() {
        plus = new JButton("+");
        minus = new JButton("-");
        multi = new JButton("*");
        divide = new JButton("/");
        calculator.changeFont(plus);
        calculator.changeFont(minus);
        calculator.changeFont(divide);
        calculator.changeFont(multi);
        setPreferredSize(new Dimension(45, 200));
        setLayout(new GridLayout(4, 1));
        add(plus);
        add(minus);
        add(multi);
        add(divide);
        plus.addActionListener(new listner());
        minus.addActionListener(new listner());
        multi.addActionListener(new listner());
        divide.addActionListener(new listner());
    }

    private class listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.secondNumber = true;
            if (e.getSource() == plus)
                calculator.op = op_numbers.plus;
            else if (e.getSource() == minus)
                calculator.op = op_numbers.minus;
            else if (e.getSource() == multi)
                calculator.op = op_numbers.multi;
            else
                calculator.op = op_numbers.divide;
        }
    }
}
