import java.io.*;
import java.net.Socket;

public class SocketInstance extends Socket implements Runnable{
    public Socket socket;
    private BufferedReader bufferedReader;

    SocketInstance(Socket sk){
        this.socket = sk;
    }

    @Override
    public void run() {
        Boolean connectFlag = true;
        while(connectFlag) {
            try {
                if (bufferedReader == null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                }
                String msg = bufferedReader.readLine();
                if(msg != null) {
                    System.out.println(msg);
                }
                if(msg.indexOf("close") != -1){
                    connectFlag = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            socket.close();
            System.out.println("socket is shutdown");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}