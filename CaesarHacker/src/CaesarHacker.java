import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarHacker implements ActionListener {
    private String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private JFrame frame;
    private JTextField messageField;
    private JButton hackButton;

    CaesarHacker(){
        frame = new JFrame("Caesar Şifreleme Hacker");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("Şifreli Mesaj:");
        label1.setFont(new Font("Arial", Font.PLAIN, 16));
        messageField = new JTextField(20);
        panel1.add(label1);
        panel1.add(messageField);


        JPanel panel2 = new JPanel(new FlowLayout());
        hackButton = new JButton("Hackle (Brute Force)");
        hackButton.setFont(new Font("Arial", Font.PLAIN, 16));
        hackButton.addActionListener(this);
        panel2.add(hackButton);

        frame.add(panel1);
        frame.add(panel2);

        frame.setVisible(true);
    }






    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new CaesarHacker();
    }
}
