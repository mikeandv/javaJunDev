package lessons.patterns_homework.logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoggerDemo {
    private static ILogger logger;
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static boolean isExit = true;


    public static void main(String[] args) {
        String inputData;
        String operation;

        while(isExit) {

            System.out.println("Enter new string:");
            System.out.print("> ");

            try {
                inputData = READER.readLine();
            } catch (IOException e) {
                //inputData = " ";
                e.getMessage();
                continue;
            }

            System.out.println("Select operation with this data string:\n" +
                    "1 - Print data string into console\n" +
                    "2 - Write data string into specified file\n" +
                    "3 - Write data string into specified file with time stamp\n" +
                    "0 - Exit\n");

            try {
                operation = READER.readLine();
            } catch (IOException e) {
                //operation = " ";
                e.getMessage();
                continue;
            }

            if(operation.equals("0")){
                isExit = false;
                continue;
            } else if (operation.equals("1")) {
                logger = new ConsoleLogger();

            } else if (operation.equals("2")) {
                logger = new FileLogger();

            } else if (operation.equals("3")) {
                logger = new TimeFileLogger();

            } else  {
                System.out.println("Wrong operation!");
                continue;
            }

            logger.write(inputData);
        }
    }
}
