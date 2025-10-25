import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private final Font mainFont = new Font("Arial", Font.PLAIN, 18);

    public MainFrame() {
        initialize();
    }

    private void initialize() {
        // Painel para o campo "Firstname"
        JPanel panelFirstname = new JPanel();
        panelFirstname.setBackground(new Color(128, 128, 244));
        panelFirstname.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelFirstname = new JLabel("Nome da Favela: ");
        labelFirstname.setFont(mainFont);
        JTextField textFirstname = new JTextField(20);
        textFirstname.setFont(mainFont);

        panelFirstname.add(labelFirstname);
        panelFirstname.add(textFirstname);

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelFirstname, BorderLayout.NORTH);

        // Configurações do JFrame
        setTitle("Slum Management");
        setSize(1920, 1080);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
