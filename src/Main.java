import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            JFrame frame = new JFrame("cal");
            frame.add(new MainButtons());
//            frame.add(new result());
            frame.pack();
            frame.setVisible(true);
    }
}

