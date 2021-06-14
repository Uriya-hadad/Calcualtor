import javax.swing.*;
import java.awt.*;

public class MainButtons extends JPanel {
    JPanel buttons, resultLabel;
    static JLabel result;
    public MainButtons() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        buttons = new JPanel();
        resultLabel = new JPanel();
        resultLabel.setBorder(BorderFactory.createBevelBorder(1, Color.GRAY,Color.BLACK));
        result = new JLabel("---");
        result.setFont(new Font("arial",Font.BOLD, 15));
        resultLabel.add(result);
        buttons.add(new calculator());
        buttons.add(new operator());
        add(resultLabel);
        add(buttons);
    }
}
