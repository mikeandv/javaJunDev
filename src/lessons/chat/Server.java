package lessons.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private IOConnection connection;
    private Socket clientSocket;

    //private ServerSocket serverSocket;

    public Server(){}

    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(7777))
        {
            ConsoleHelper.writeString("Server started on:" + serverSocket);
            Message mess = null;

            while (true) {

                clientSocket = serverSocket.accept();
                connection = new IOConnection(clientSocket);
                mess = connection.receive(clientSocket);
                if (mess != null) {
                    connection.send(new Message("Server",
                            mess.getSender() + " your message \""+ mess.getMessText() +"\" receive"));
                }
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void printMessage(Message message) {
        ConsoleHelper.writeString("message >>" + message.getSender()+ ": " +
                message.getMessText());
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }


}
