import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Bed {
    private int x,y;
    private Dir dir=Dir.RIGHT;
    private RoomFrame rf = null;
    public static int WIDTH = ResourceMgr.BedEmpty.getWidth();
    public static int HEIGHT = ResourceMgr.BedEmpty.getHeight();

    private boolean living = true;

    Rectangle rect = new Rectangle();//记录床数据


    public Bed(int x, int y, Dir dir, RoomFrame rf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.rf = rf;

        //记录子弹数据
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    private void move() {


        //update rect
        rect.x = this.x;
        rect.y = this.y;
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
