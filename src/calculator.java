import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JPanel {
    static boolean secondNumber = false;
    static String number1 = "0", number2 = "0";
    JButton[] numbers = new JButton[10];
    JButton dot = new JButton(".");
    static JButton equal = new JButton("=");
    static operator.op_numbers op = null;

    public calculator() {
        changeFont(equal);
        setLayout(new GridLayout(4, 3));
        setPreferredSize(new Dimension(140, 200));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton(Integer.toString(i));
            numbers[i].addActionListener(new NumbersListener());
            add(numbers[i]);
        }
        add(dot);
        dot.addActionListener(new dotListener());
        add(equal);
        equal.addActionListener(new equalListener());
    }


    private static class dotListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!secondNumber) {
                number1 += ".";
                MainButtons.result.setText(number1);
            }
            else {
                number2 += ".";
                MainButtons.result.setText(number2);
            }
        }
    }
    private static class NumbersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numberChosen = Integer.parseInt(((JButton) e.getSource()).getText());
            if (!secondNumber) {
                //deleting the zero number for writing new one
                if (number1.equals("0"))
                    number1 = "";
                number1 += numberChosen;
                MainButtons.result.setText(number1);
            } else {
                //deleting the zero number for writing new one
                if (number2.equals("0"))
                    number2 = "";
                number2 += numberChosen;
                MainButtons.result.setText(number2);
            }

        }

    }

    static void changeFont(JButton button) {
        button.setBackground(new Color(58, 184, 104));
        button.setFont(new Font("Arial", Font.BOLD, 18));
    }

    private static class equalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double number1Value = Double.parseDouble(number1),
                    number2Value = Double.parseDouble(number2);
            switch (op) {
                case divide -> {
                    if (number2Value != 0) {
                        operator.result += number1Value / number2Value;
                        MainButtons.result.setText(Double.toString(operator.result));
                    } else {
                        MainButtons.result.setText("Nan");
                    }
                }
                case plus -> {
                    operator.result += number1Value + number2Value;
                    MainButtons.result.setText(Double.toString(operator.result));
                }
                case minus -> {
                    operator.result += number1Value - number2Value;
                    MainButtons.result.setText(Double.toString(operator.result));
                }
                case multi -> {
                    operator.result += number1Value * number2Value;
                    MainButtons.result.setText(Double.toString(operator.result));
                }
                default -> MainButtons.result.setText("Nan");
            }
            number1 = "0";
            number2 = "0";
            secondNumber = false;
            operator.result = 0;
        }
    }
}
