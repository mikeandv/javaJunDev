package lessons.chat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class IOConnection {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public IOConnection(Socket socket) {
        this.socket = socket;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.getMessage();
        }
    }
    void send(Message message) {
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public Message receive(/*Socket socket*/) {

        Message message = null;
        try {
            message = (Message) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
        return message;
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }
}
