import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ������
 * @version 1.0
 */
public class ResourceMgr {
    public static BufferedImage BoyR, BoyL,BoyU,BoyD;//�����ƶ�����

    public static BufferedImage BedEmpty;

   // public static BufferedImage[] waggle = new BufferedImage[3];//�ζ����� �����鲥��3����Ƭ


    static {//��̬����
        try {
//

            BoyR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BoyRight.png"));
            BoyL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BoyLeft.png"));
            BoyU = ImageUtil.rotateImage(BoyR,0);
            BoyD = ImageUtil.rotateImage(BoyL,0);


//            for (int i = 0; i < 3; i++) {
//                waggle[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/Boy"+(i+1)+".png"));
//            }

            BedEmpty=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bedEmpty.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
