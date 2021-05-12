import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calcualtor extends JPanel {
    static boolean flag = false;
    static double number1 = 0, number2 = 0;
    static boolean dotOn = false;
    JButton[] numbers = new JButton[10];
    JButton dot = new JButton(".");
    static JButton equal = new JButton("=");
    static operator.op_numbers op = null;

    public calcualtor() {
        changeFont(equal);
        setLayout(new GridLayout(4, 3));
        setPreferredSize(new Dimension(140, 200));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton(Integer.toString(i));
            numbers[i].addActionListener(new NumbersListener());
            add(numbers[i]);
        }
        add(dot);
        dot.addActionListener((e) -> dotOn = true);
        add(equal);
        equal.addActionListener(new operatorListener());
    }

    private static class NumbersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!flag) {
                number1 *= 10;
                number1 += Integer.parseInt(((JButton) e.getSource()).getText());
                MainButtons.result.setText(Double.toString(number1));
            } else {
                number2 *= 10;
                number2 += Integer.parseInt(((JButton) e.getSource()).getText());
                MainButtons.result.setText(Double.toString(number2));
            }

        }

    }

    static void changeFont(JButton button) {
        button.setBackground(new Color(58, 184, 104));
        button.setFont(new Font("Arial", Font.BOLD, 18));
    }

    private static class operatorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (op) {
                case divide -> {
                    if (number2 != 0) {
                        operator.result += calcualtor.number1 / calcualtor.number2;
                        MainButtons.result.setText(Double.toString(operator.result));
                    } else {
                        MainButtons.result.setText("Nan");
                    }
                }
                case plus -> {
                    operator.result += calcualtor.number1 + calcualtor.number2;
                    MainButtons.result.setText(Double.toString(operator.result));
                }
                case minus -> {
                    operator.result += calcualtor.number1 - calcualtor.number2;
                    MainButtons.result.setText(Double.toString(operator.result));
                }
                case multi -> {
                    operator.result += calcualtor.number1 * calcualtor.number2;
                    MainButtons.result.setText(Double.toString(operator.result));
                }
                default -> MainButtons.result.setText("Nan");
            }
            number1 = 0;
            number2 = 0;
            flag = false;
            operator.result = 0;
        }
    }
}
