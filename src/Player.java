import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends ImageModel {
    private Movement movement;
    private int y_cpy = -1;
    private boolean jump = false;
    private boolean end_jump = true;
    private boolean dead = false;
    private int jumpLevel = 90;
    private boolean right_space = false;
    private boolean left_space = false;
    private boolean right = false;
    private boolean left = false;
    private int countRight = 0;
    private int countLeft = 0;

    public Player(Image img, Movement movement) {
        this.img = img;
        width = img.getWidth(null);
        height = img.getHeight(null);
        this.x = (500 - 5) / 2 - width / 2;
        this.y = 500 - 25 - height;
        dx = 3;
        dy = 0;
        this.movement = movement;
        stored_dy = 5;
    }

    @Override
    public void update() {
        //check for arnold move in x axis
        if (x < 60) {
            x = 60;
        }
        if (x > 500 - width - 5 - 60) {
            x = 500 - width - 5 - 60;
        }
        //check for arnold move in y axis
        if (y > 500 - height - 25) {
            dead = true;
            y = -y;
        }
        //check if arnold is jump
        if (jump) {
            dy = -stored_dy;
            img = new ImageIcon(getClass().getResource("/Character/jump.png")).getImage();
        }
        //check if arnold is reach the height of his jump or the height of the screen
        if (y <= y_cpy - jumpLevel) {
            if (right_space) {
                img = new ImageIcon(getClass().getResource("/Character/jump2right.png")).getImage();
                right_space = false;
            } else if (left_space) {
                img = new ImageIcon(getClass().getResource("/Character/jump2left.png")).getImage();
                left_space = false;
            }
            y_cpy = -1;
            dy = stored_dy;
            jump = false;
            end_jump = false;
        } else if (y < 0) {
            y_cpy = -1;
            dy = stored_dy;
            jump = false;
            end_jump = false;
        }
        //check for keys input to change the position or jump
        if (movement.keyIs(KeyEvent.VK_RIGHT)) {
            x += dx;
            right = true;
            countRight++;
            System.out.println("Moving Right");
        }
        if (movement.keyIs(KeyEvent.VK_LEFT)) {
            x -= dx;
            left = true;
            countLeft++;
            System.out.println("Moving Left");
        }
        if (movement.keyIs(KeyEvent.VK_SPACE)) {
            if (!jump && end_jump) {
                jump = true;
                y_cpy = y;
                System.out.println("Jumping");
            }
        }
        //if jump right or left
        if (movement.keyIs(KeyEvent.VK_RIGHT) && movement.keyIs(KeyEvent.VK_SPACE)) {
            right_space = true;
            img = new ImageIcon(getClass().getResource("/Character/jump1right.png")).getImage();
        } else if (movement.keyIs(KeyEvent.VK_LEFT) && movement.keyIs(KeyEvent.VK_SPACE)) {
            left_space = true;
            img = new ImageIcon(getClass().getResource("/Character/jump1left.png")).getImage();
        }
        //for walk images change right
        if (right && !jump) {
            switch (countRight) {
                case 1:
                    img = new ImageIcon(getClass().getResource("/Character/walk1right.png")).getImage();
                    right = false;
                    break;
                case 2:
                    img = new ImageIcon(getClass().getResource("/Character/walk2right.png")).getImage();
                    right = false;
                    break;
                case 3:
                    img = new ImageIcon(getClass().getResource("/Character/walk3right.png")).getImage();
                    countRight = 0;
                    right = false;
                    break;
                default:
                    countRight = 0;
                    right = false;
            }
        } else if (left && !jump) {
            switch (countLeft) {
                case 1:
                    img = new ImageIcon(getClass().getResource("/Character/walk1left.png")).getImage();
                    left = false;
                    break;
                case 2:
                    img = new ImageIcon(getClass().getResource("/Character/walk2left.png")).getImage();
                    left = false;
                    break;
                case 3:
                    img = new ImageIcon(getClass().getResource("/Character/walk3left.png")).getImage();
                    countLeft = 0;
                    left = false;
                    break;
                default:
                    countLeft = 0;
                    left = false;
            }
        }
        y += dy;
    }

    public Movement getMovement() {
        return movement;
    }

    public int getY_cpy() {
        return y_cpy;
    }

    public boolean isJump() {
        return jump;
    }

    public boolean isEnd_jump() {
        return end_jump;
    }

    public boolean isDead() {
        return dead;
    }

    public int getJumpLevel() {
        return jumpLevel;
    }

    public boolean isRight_space() {
        return right_space;
    }

    public boolean isLeft_space() {
        return left_space;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public int getCountRight() {
        return countRight;
    }

    public int getCountLeft() {
        return countLeft;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public void setY_cpy(int y_cpy) {
        this.y_cpy = y_cpy;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public void setEnd_jump(boolean end_jump) {
        this.end_jump = end_jump;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setJumpLevel(int jumpLevel) {
        this.jumpLevel = jumpLevel;
    }

    public void setRight_space(boolean right_space) {
        this.right_space = right_space;
    }

    public void setLeft_space(boolean left_space) {
        this.left_space = left_space;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setCountRight(int countRight) {
        this.countRight = countRight;
    }

    public void setCountLeft(int countLeft) {
        this.countLeft = countLeft;
    }

    public Image getImage() {
        return this.img;
    }

    public boolean isPlayerDead() {
        return isDead();
    }
}
