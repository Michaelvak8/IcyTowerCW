import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private Image backgroundImage;
  //  private Music theme;
//"/Character/1.png"
    public MainPanel() {
        try {
            this.backgroundImage = new ImageIcon(getClass().getResource("/Background/background1.gif")).getImage();
            if (this.backgroundImage == null) {
                System.out.println("Background image not found.");
            } else {
                System.out.println("Background image loaded successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setBounds(0, 0, MainFrame.GAME_WIDTH, MainFrame.GAME_HEIGHT);
        this.setLayout(null);  // Using null layout for absolute positioning

        // Set a preferred size to ensure proper layout management
        this.setPreferredSize(new Dimension(MainFrame.GAME_WIDTH, MainFrame.GAME_HEIGHT));
     //   this.theme = new Music();
        //  theme.play("icytheme.wav");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
