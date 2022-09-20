/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RoomFrame rf = new RoomFrame();//»æÖÆÃæ°å

        while (true) {
            Thread.sleep(45);
            rf.repaint();
        }
    }
}
