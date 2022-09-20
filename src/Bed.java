import java.awt.*;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class Bed {
    private int x,y;
    private Dir dir=Dir.RIGHT;
    private RoomFrame rf = null;

    private boolean living = true;


    public Bed(int x, int y, Dir dir, RoomFrame rf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.rf = rf;
    }

    public  void paint(Graphics g) {
        g.drawImage(ResourceMgr.BedEmpty, x, y, null);
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
