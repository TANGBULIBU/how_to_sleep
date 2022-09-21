/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RoomFrame rf = new RoomFrame();//绘制面板

        int initBedCount=Integer.parseInt((String)PropertyMgr.get("initBedCount"));
        for (int i = 0; i <initBedCount ; i++) {//初始化床的数量
            rf.beds.add(new Bed(50+i*200,200,Dir.RIGHT,rf));
        }

        while (true) {
            Thread.sleep(45);
            rf.repaint();
        }
    }
}
