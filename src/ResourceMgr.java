import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ������
 * @version 1.0
 */
public class ResourceMgr {
    public static BufferedImage BoyR, BoyL,BoyU,BoyD;//�����ƶ�����



    static {//��̬����
        try {
//

            BoyR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BoyRight.png"));
            BoyL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BoyLeft.png"));
            BoyU = ImageUtil.rotateImage(BoyR,0);
            BoyD = ImageUtil.rotateImage(BoyL,0);




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
