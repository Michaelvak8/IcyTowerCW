import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    private static boolean[] keyPressed;
    private Player player;

    public Movement(Player player) {
        this.player = player;
        keyPressed = new boolean[3];
        for (int i = 0; i < 3; i++) {
            keyPressed[i] = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key(e, true);
        System.out.println("Key Pressed: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key(e, false);
        System.out.println("Key Released: " + e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean keyIs(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                return keyPressed[0];
            case KeyEvent.VK_LEFT:
                return keyPressed[1];
            case KeyEvent.VK_SPACE:
                return keyPressed[2];
            default:
                return false;
        }
    }

    public void key(KeyEvent e, boolean type) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                keyPressed[0] = type;
                break;
            case KeyEvent.VK_LEFT:
                keyPressed[1] = type;
                break;
            case KeyEvent.VK_SPACE:
                keyPressed[2] = type;
                break;
        }
    }
}
