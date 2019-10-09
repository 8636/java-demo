package Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Sir
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器端的Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(10001);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = inputStream.read(bys);
        String data = new java.lang.String(bys,0,len);
        System.out.println("数据是:" + data);

        //给出反馈
        OutputStream os = socket.getOutputStream();
        os.write("数据已经收到".getBytes());
        socket.close();
        serverSocket.close();
    }
}
