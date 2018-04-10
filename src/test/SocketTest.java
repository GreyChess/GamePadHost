package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 1717);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("socket is connected");
            bufferedWriter.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
