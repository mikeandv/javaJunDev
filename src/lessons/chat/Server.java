package lessons.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {
    private int port;
    private final Set<IOConnection> connections = new CopyOnWriteArraySet<>();
    private final BlockingDeque<Message> messageBlockingDeque = new LinkedBlockingDeque<>();

    //private ServerSocket serverSocket;

    public Server(int port){
        this.port = port;

    }

//    public void start() {
//        try(ServerSocket serverSocket = new ServerSocket(7777))
//        {
//            ConsoleHelper.writeString("Server started on:" + serverSocket);
//            Message mess = null;
//
//            while (true) {
//
//                clientSocket = serverSocket.accept();
//                connection = new IOConnection(clientSocket);
//                mess = connection.receive(clientSocket);
//                if (mess != null) {
//                    connection.send(new Message("Server",
//                            mess.getSender() + " your message \""+ mess.getMessText() +"\" receive"));
//                }
//            }
//        } catch (IOException e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }

    public void start() throws IOException{
        new Thread(new Writer()).start();
        try(ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeString("Server started on: " + serverSocket);
            IOConnection ioConnection;

            while (true) {

                Socket clientSocket = serverSocket.accept();

                //после успешного подключения выдать команду слиенту что соединение установлено,
                //при обрыве сообщить что произошла ошибка

                ioConnection = new IOConnection(clientSocket);
                connections.add(ioConnection);

                new Thread(new Reader(ioConnection)).start();
            }
        }
    }

    private class Writer implements Runnable {
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                try {

                    Message message = messageBlockingDeque.take();
                    for(IOConnection connection : connections) {

                        connection.send(message);
                    }

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }
            }
        }
    }

    private class Reader implements  Runnable {
        private IOConnection connection;

        public Reader(IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                messageBlockingDeque.add(message);
                System.out.println(message);
            }
        }
    }

    private void printMessage(Message message) {
        ConsoleHelper.writeString("message >>" + message.getSender()+ ": " +
                message.getMessText());
    }

    public static void main(String[] args) {
//        Server server = new Server();
//        server.start();
        Server server = new Server(7777);

        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
