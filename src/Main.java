/**
 * @author ������
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RoomFrame rf = new RoomFrame();//�������

        int initBedCount=Integer.parseInt((String)PropertyMgr.get("initBedCount"));
        for (int i = 0; i <initBedCount ; i++) {//��ʼ����������
            rf.beds.add(new Bed(50+i*200,200,Dir.RIGHT,rf));
        }

        while (true) {
            Thread.sleep(45);
            rf.repaint();
        }
    }
}
