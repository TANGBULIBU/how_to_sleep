import java.io.IOException;
import java.util.Properties;

/**
 * @author ������
 * @version 1.0
 */
public class PropertyMgr {

    static Properties props = new Properties();//Properties����key��value

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));//��ȡ ����Դ���������� ����
            //�����ݷ���props��
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {//ȡ��props������
        if (props == null) return null;
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initBedCount"));//���������ļ���̹������
    }
}

