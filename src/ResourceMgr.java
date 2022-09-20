import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class ResourceMgr {
    public static BufferedImage BoyR, BoyL,BoyU,BoyD;//人物移动动画

    public static BufferedImage BedEmpty;

   // public static BufferedImage[] waggle = new BufferedImage[3];//晃动动画 用数组播放3张照片


    static {//静态语句块
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
