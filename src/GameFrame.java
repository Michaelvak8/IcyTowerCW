import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    private Movement movement;
    protected Player player;
    protected Block[] blocks;
    protected int level;
    private int count;
    protected static final int size = 200;
    protected BackGround background;
    protected BackGround border;
    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 500;

    public GameFrame() {
        this.movement = new Movement(this.player); // Initialize movement before creating the player
        this.player = new Player(new ImageIcon(getClass().getResource("/Character/1.png")).getImage(), movement);
        this.count = 0;
        this.level = 1;
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        this.setTitle("Icy Tower Jump");
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Character/1.png")).getImage());
        initGame();
        setLayout(new BorderLayout());
        add(new GamePanel(this), BorderLayout.CENTER);
        addKeyListener(movement);
        setVisible(true);
    }

    public void restartGame() {
        // Reset player position and state
        this.player = new Player(new ImageIcon(getClass().getResource("/Character/1.png")).getImage(), movement);
        this.movement = new Movement(this.player);

        // Reset game parameters
        this.count = 0;
        this.level = 1;

        // Initialize the game components again
        initGame();

        // Notify the GamePanel about the restart
        this.getContentPane().removeAll();
        this.add(new GamePanel(this), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBackground(BackGround background) {
        this.background = background;
    }

    public void setBorder(BackGround border) {
        this.border = border;
    }

    public void initGame() {
        this.background = new BackGround(new ImageIcon(getClass().getResource("/Background/background.png")).getImage(), 2, movement);
        this.border = new BackGround(new ImageIcon(getClass().getResource("/Background/border2.png")).getImage(), 1, movement);
        this.blocks = new Block[size];
        int distanceBlock = 70;
        for (int i = 0; i < size; i++) {
            if ((i + 1) % 50 == 0) {
                blocks[i] = new Block(new ImageIcon(getClass().getResource("/Blocks/Block.png")).getImage(), 0, 475 - distanceBlock, player, movement);
            } else {
                blocks[i] = new Block(new ImageIcon(getClass().getResource("/Blocks/Block" + (int) ((Math.random() * 3) + 1) + ".png")).getImage(), (int) ((Math.random() * 195) + 75), 475 - distanceBlock, player, movement);
            }
            blocks[i].index = i + 1;
            distanceBlock += 70;
        }
    }

}
