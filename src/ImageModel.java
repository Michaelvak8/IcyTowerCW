import java.awt.Image;

public abstract class ImageModel {

    Image img = null;
    int x = 0;
    int y = 0;
    double dx = 0;
    double dy = 0;
    double stored_dy = 0;
    int width = 0;
    int height = 0;

    public abstract void update();

    public Image getImg() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getStored_dy() {
        return stored_dy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
