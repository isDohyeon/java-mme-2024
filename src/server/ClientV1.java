package server;

import static server.MyLogger.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientV1 {

    private static final int PORT = 80;
    private static final String IP_ADDRESS = "172.18.138.25";

    public static void main(String[] args) throws IOException {
        log("Starting Client Program");
        Socket socket = new Socket(IP_ADDRESS, PORT);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        log("Connecting Socket");

        String toSend = "Hello";
        dataOutputStream.writeUTF(toSend);
        log("Send Message : " + toSend);

        log("Closing Socket : " + socket);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
