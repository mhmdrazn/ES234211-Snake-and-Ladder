import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameStatisticsFrame extends JFrame {
    public GameStatisticsFrame(ArrayList<Player> players) {
        setTitle("Game Statistics");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Label judul
        JLabel titleLabel = new JLabel("Game Statistics", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Tabel untuk menampilkan statistik pemain
        String[] columnNames = {"Player Name", "Final Position"};
        Object[][] data = new Object[players.size()][2];
        for (int i = 0; i < players.size(); i++) {
            data[i][0] = players.get(i).getUserName();
            data[i][1] = players.get(i).getPosition();
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Tombol OK
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> dispose());
        panel.add(okButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void showStatistics(ArrayList<Player> players) {
        SwingUtilities.invokeLater(() -> new GameStatisticsFrame(players));
    }
}
