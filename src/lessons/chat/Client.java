package lessons.chat;


import java.io.IOException;
import java.net.Socket;

public class Client {
    private IOConnection connection;

    public Client(IOConnection connection){
        this.connection = connection;
    }

//    public void start() {
//        ConsoleHelper.writeString("Your Name");
//        String name = ConsoleHelper.readString();
//
//        while(true) {
//            ConsoleHelper.writeString("> ");
//            Message message = new Message(name, ConsoleHelper.readString());
//
//            try(Socket socket = new Socket("localhost", 7777 ))
//            {
//                connection = new IOConnection(socket);
//                connection.send(message);
//                printMessage(connection.receive(socket));
//
//
//            }catch (IOException e) {
//                e.getMessage();
//            }
//        }
//    }

    public void start() {

        ConsoleHelper.writeString("Enter your name");
        String name = ConsoleHelper.readString();

        Thread reader = new Thread(new Reader(connection));
        reader.start();

        ConsoleHelper.writeString("Enter message");

        while(true) {
            String msg = ConsoleHelper.readString();

            //реализовать возможность выхода из чата по команде /exit
            //Реализовать возможность сменить имя пользователя /nick

            if(msg != null && !msg.isEmpty()) {
                Message message = new Message(name, msg);
                connection.send(message);
            }
        }
    }

    private class Reader implements Runnable {
        private final IOConnection connection;

        public Reader(IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {

            while(!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                System.out.println(message);
            }
        }
    }

    private void printMessage(Message message) {
        System.out.println("message >>" + message.getSender()+ ": " +
                message.getMessText());
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(new IOConnection(new Socket("127.0.0.1",7777)));
        client.start();
    }
}
