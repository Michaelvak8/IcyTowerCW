
import java.awt.Image;
import java.awt.event.KeyEvent;

public class BackGround extends ImageModel {

    private final Movement movement;

    public BackGround(Image img, double dy, Movement movement) {
        this.img = img;
        x = 0;
        y = img.getHeight(null) * -1 + 475;
        stored_dy = dy;
        this.movement = movement;
    }

    @Override
    public void update() {
        if (movement.keyIs(KeyEvent.VK_SPACE)) {
            dy = stored_dy;
        }
        y += dy;
    }

    public Image getImage() {
        return this.img;
    }
}
