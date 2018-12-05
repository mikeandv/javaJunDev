package lessons.chat;


import java.io.IOException;
import java.net.Socket;

public class Client {
    private IOConnection connection;
    public Client(){}

    public void start() {
        ConsoleHelper.writeString("Your Name");
        String name = ConsoleHelper.readString();

        while(true) {
            ConsoleHelper.writeString("> ");
            Message message = new Message(name, ConsoleHelper.readString());

            try(Socket socket = new Socket("localhost", 7777 ))
            {
                connection = new IOConnection(socket);
                connection.send(message);
                printMessage(connection.receive(socket));


            }catch (IOException e) {
                e.getMessage();
            }
        }
    }
    private void printMessage(Message message) {
        System.out.println("message >>" + message.getSender()+ ": " +
                message.getMessText());
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

}
