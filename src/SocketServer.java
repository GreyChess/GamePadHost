import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer extends ServerSocket{

    public SocketServer(int port, int backlog) throws IOException {
        super(port, backlog);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            SocketServer ss = new SocketServer(1717, 10);
            while(true){
                SocketInstance si = new SocketInstance(ss.accept());
                new Thread(si).start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
