import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class YouSelf {
    private int x, y;
    private Dir dir = Dir.RIGHT;
    private static final int SPEED = 3;
    private RoomFrame rf = null;

    public static int WIDTH = ResourceMgr.BoyU.getWidth();
    public static int HEIGHT = ResourceMgr.BoyU.getHeight();

    private boolean moving = true;
    private boolean living = true;

    /**
     * rectangle 每次移动需要碰撞检测 也就是有n*m此检测 2mn的新对象 消除这个数据
     */
    Rectangle rect = new Rectangle();//记录人物数据


    public YouSelf(int x, int y, Dir dir, RoomFrame rf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.rf = rf;

        //记录人物数据
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.BoyL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BoyR, x, y, null);
                break;
            case UP:
                if (this.dir == Dir.RIGHT) {
                    g.drawImage(ResourceMgr.BoyR, x, y, null);
                } else {
                    g.drawImage(ResourceMgr.BoyL, x, y, null);
                }
//                g.drawImage(ResourceMgr.BoyU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BoyD, x, y, null);
                break;


    }

    move();

}

    private void move() {
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

        //边界检测
        boundCheck();

        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundCheck() {
        if (this.x < 5) x = 5;
        if (this.y < 20) y = 20;
        if (this.x > RoomFrame.GAME_WIDTH - YouSelf.WIDTH - 5) x = RoomFrame.GAME_WIDTH - YouSelf.WIDTH - 5;
        if (this.y > RoomFrame.GAME_HEIGHT - YouSelf.HEIGHT - 5) y = RoomFrame.GAME_HEIGHT - YouSelf.HEIGHT - 5;
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
