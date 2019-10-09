package Socket.TCP;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 创建客户端socket对象
 */
@Slf4j
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 10001);
        OutputStream os = s.getOutputStream();
        String id = "123456";
        int length = id.length();
        byte[] idBytesbytes = id.getBytes();
        log.info("内容为->{}",Tools.byteToString(idBytesbytes));
        byte[] lengthBytes = Tools.intToByteArray(length);
        log.info("内容长度为->{}",Tools.byteToString(lengthBytes));
        byte[] bytes = Tools.byteMerger(idBytesbytes, lengthBytes);
        log.info("合并结果为->{}",Tools.byteToString(bytes));

        os.write("tcp发送数据".getBytes());
        //接收服务器反馈
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("客户端：" + data);
        is.close();
        os.close();
    }
}
