import java.awt.*;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class YouSelf {
    private int x,y;
    private Dir dir=Dir.RIGHT;
    private static final int SPEED=2;
    private RoomFrame rf = null;

    private boolean moving = true;
    private boolean living = true;


    public YouSelf(int x, int y, Dir dir, RoomFrame rf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.rf = rf;
    }

    public  void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.BoyL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BoyR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.BoyU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BoyD, x, y, null);
                break;

        }
        move();
    }

    private void move(){
        if (!moving) return;


        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public RoomFrame getRf() {
        return rf;
    }

    public void setRf(RoomFrame rf) {
        this.rf = rf;
    }
}
