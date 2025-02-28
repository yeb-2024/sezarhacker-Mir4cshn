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
        if (e.getSource() == hackButton) {
            String message = messageField.getText().trim();

            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Lütfen bir şifreli mesaj girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }
            StringBuilder results = new StringBuilder("Brute-Force Sonuçları:\n");

            for (int key = 0; key < SYMBOLS.length(); key++) {
                String decryptedMessage = caesarCipher(message, key);
                results.append("Key #").append(key).append(": ").append(decryptedMessage).append("\n");
            }

            JTextArea textArea = new JTextArea(results.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(frame, scrollPane, "Sonuçlar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public String caesarCipher(String message, int key) {
        StringBuilder result = new StringBuilder();
        message = message.toUpperCase();

        for (char c : message.toCharArray()) {
            int index = SYMBOLS.indexOf(c);
            if (index != -1) {
                int newIndex = (index - key + SYMBOLS.length()) % SYMBOLS.length();
                result.append(SYMBOLS.charAt(newIndex));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        new CaesarHacker();
    }
}
