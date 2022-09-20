import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ������
 * @version 1.0
 */
public class RoomFrame extends Frame {


    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;//����Ϊ���� ����һ��λ�ü���
    YouSelf ys = new YouSelf(200, 500, Dir.RIGHT, this);

    List<Bed> beds = new ArrayList<>();//���ô�������


    public RoomFrame() {//��������
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("How to Sleep");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {//�������� ����ر� ���������
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    Image offScreenImage = null;//����ͼƬ

    @Override
    public void update(Graphics g) {//��ʧ��˸���� ������ΪͼƬһ��һ���ٴλ���
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);//��ȡ��ǰ�����С��ͼƬ
        }
        Graphics gOffScreen = offScreenImage.getGraphics();//�õ�ͼƬ
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);//������Ϊ��ɫ
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);//����ͼƬ�ٴλ��Ƶ�������

    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("��������" + beds.size(), 10, 60);
        g.setColor(c);


        ys.paint(g);//�������

        for (int i = 0; i < beds.size(); i++) {
            beds.get(i).paint(g);
        }


//        for (int i = 0; i < bullets.size(); i++) {//����ʹ�����ײ
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//
//            }
//        }
    }


    class MyKeyListener extends KeyAdapter {//��������

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        @Override
        public void keyPressed(KeyEvent e) {//����
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
        public void keyReleased(KeyEvent e) {//̧��
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

        private void setMainYouSelfDir() {//ȷ������

            if (!bL && !bU && !bD && !bR) ys.setMoving(false);//��������Щ�� �Ͳ����ƶ�
            else {

                ys.setMoving(true);
                if (bL) //�����������ϻ�������
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

