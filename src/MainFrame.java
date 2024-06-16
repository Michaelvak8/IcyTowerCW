import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 700;
    public static final int MARGIN = 5;
    public static final int SECOND = 1000;
    public static Music theme;
    public static boolean toPlay;
    public static String themeName = "icytheme.wav";

    public MainFrame() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setTitle("Icy Tower Jump");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Background/icytower.gif")).getImage());
        this.setLayout(null); // Using absolute positioning
        this.initialize();
        this.setVisible(true);
        // this.validate();
        this.repaint();
        this.theme = new Music();
        this.toPlay = true;
        theme.play(themeName);
    }





    public void initialize(){
        MainPanel mainPanel = new MainPanel();
        //mainPanel.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
        this.add(mainPanel);

        Image musicOff = new ImageIcon(getClass().getResource("/Sound/musicoff.png")).getImage();
        Image musicOn = new ImageIcon(getClass().getResource("/Sound/musicon.png")).getImage();
        ImageIcon onIcon = new ImageIcon(musicOn);
        ImageIcon offIcon = new ImageIcon(musicOff);

        JButton musicButton = new JButton(onIcon);
        musicButton.setBounds(MARGIN,MARGIN,onIcon.getIconWidth(),onIcon.getIconHeight());
        musicButton.setOpaque(false);
        musicButton.setContentAreaFilled(false);
        musicButton.setBorderPainted(false);
        mainPanel.add(musicButton);


        Image newGameImage = new ImageIcon(getClass().getResource("/Background/startbutton.png")).getImage();
        ImageIcon ngImage = new ImageIcon(newGameImage);
        JButton newGame = new JButton(ngImage);
        newGame.setBounds(GAME_WIDTH / 10, 550, ngImage.getIconWidth(), ngImage.getIconHeight());

        newGame.setOpaque(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        mainPanel.add(newGame);  // Add button to mainPanel

        Image information = new ImageIcon(getClass().getResource("/Background/howto.png")).getImage();
        ImageIcon infoImage = new ImageIcon(information);
        JButton info = new JButton(infoImage);
        info.setBounds(newGame.getX() + newGame.getWidth() + MARGIN, newGame.getY(), newGame.getWidth(), newGame.getHeight());
        info.setOpaque(false);
        info.setContentAreaFilled(false);
        info.setBorderPainted(false);
        mainPanel.add(info);  // Add button to mainPanel


        Image exitImage = new ImageIcon(getClass().getResource("/Background/exit.png")).getImage();
        ImageIcon exitIcon = new ImageIcon(exitImage);
        JButton exit = new JButton(exitIcon);
        exit.setBounds(info.getX() + info.getWidth() + MARGIN, newGame.getY(), newGame.getWidth(), newGame.getHeight());
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        mainPanel.add(exit);  // Add button to mainPanel

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameFrame game = new GameFrame();
                game.setVisible(true);
            }
        });

        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toPlay){
                    musicButton.setIcon(offIcon);
                    theme.stop();
                    toPlay = false;
                }

                else{
                    musicButton.setIcon(onIcon);
                    theme.play(themeName);
                    toPlay = true;
                }
            }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HowToPlayFrame howToPlay = new HowToPlayFrame();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis * SECOND);
        } catch (InterruptedException e) {

        }
    }
}
