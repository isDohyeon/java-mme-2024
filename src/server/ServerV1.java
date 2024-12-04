package server;

import static server.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV1 {

    private static final int PORT = 80;

    public static void main(String[] args) throws IOException {
        log("Starting Server Program..");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("Listening Port : " + PORT);
        Socket socket = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String received = dataInputStream.readUTF();
        log("Received Message : " + received);
        String toSend = received + " World!";

        dataOutputStream.writeUTF(toSend);
        log("Sent Message : " + toSend);
        log("Closing Socket : " + socket);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}
