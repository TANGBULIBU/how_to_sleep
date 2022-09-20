import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class RoomFrame extends Frame {


    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;//抽象为常量 更改一个位置即可
    YouSelf ys = new YouSelf(200, 500, Dir.RIGHT, this);

    List<Bed> beds = new ArrayList<>();//设置床的数组


    public RoomFrame() {//窗口设置
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("How to Sleep");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {//监听窗口 如果关闭 则结束程序
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    Image offScreenImage = null;//定义图片

    @Override
    public void update(Graphics g) {//消失闪烁现象 就是作为图片一张一张再次绘制
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);//获取当前画面大小的图片
        }
        Graphics gOffScreen = offScreenImage.getGraphics();//拿到图片
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);//背景变为黑色
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);//这张图片再次绘制到画面上

    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("床的数量" + beds.size(), 10, 60);
        g.setColor(c);


        ys.paint(g);//人物绘制

        for (int i = 0; i < beds.size(); i++) {
            beds.get(i).paint(g);
        }


//        for (int i = 0; i < bullets.size(); i++) {//人物和床的碰撞
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//
//            }
//        }
    }


    class MyKeyListener extends KeyAdapter {//按键监听

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        @Override
        public void keyPressed(KeyEvent e) {//按键
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_A:
                    bL = true;
                    break;
                case KeyEvent.VK_D:
                    bR = true;
                    break;
                case KeyEvent.VK_W:
                    bU = true;
                    break;
                case KeyEvent.VK_S:
                    bD = true;
                    break;

                default:
                    break;

            }

            setMainYouSelfDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {//抬起
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_A:
                    bL = false;
                    break;
                case KeyEvent.VK_D:
                    bR = false;
                    break;
                case KeyEvent.VK_W:
                    bU = false;
                    break;
                case KeyEvent.VK_S:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainYouSelfDir();
        }

        private void setMainYouSelfDir() {//确定朝向

            if (!bL && !bU && !bD && !bR) ys.setMoving(false);//不按下这些键 就不会移动
            else {

                ys.setMoving(true);
                if (bL) //主方向是向上或者向下
                    ys.setDir(Dir.LEFT);

                if (bR)
                    ys.setDir(Dir.RIGHT);

                if (bU)
                    ys.setDir(Dir.UP);

                if (bD)
                    ys.setDir(Dir.DOWN);


            }


        }

    }
}

