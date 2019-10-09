package Socket;

import java.io.IOException;
import java.net.*;

public class ClientDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes = "hello".getBytes();
        int lenth = bytes.length;
        DatagramPacket datagramPacket = new DatagramPacket(bytes,lenth,InetAddress.getLocalHost(),10000);
        System.out.println("开始发送数据");
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
