package lessons.patterns_homework.cryptostream;

import lessons.chat.ConsoleHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static StringBuilder cryptoFileRead(File file, String pass) {

        byte[] passByte = pass.getBytes();
        StringBuilder sb = new StringBuilder();
        List<Byte> byteList = new ArrayList<>();

        try (
                CryptoInputSteam crIn = new CryptoInputSteam(new FileInputStream(file), passByte)//;

        ) {
            int buff;

            while ((buff = crIn.read()) != -1) { // читаем по одному расшифрованному байту

                    byteList.add((byte) buff); // записываем в коллекцию
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //конструктор строки для вывода
        byte[] tmp = new byte[byteList.size()];
        int i = 0;

        for(Byte b : byteList)
        {
            tmp[i++] = b.byteValue();
        }
        return sb.append(new String(tmp));
    }

    private static void cryptoFileWrite(File file, String pass, String data) {

        byte[] passByte = pass.getBytes();
        byte[] byteData = data.getBytes();
        List<Byte> byteList = new ArrayList<>();

        try (
                CryptoInputSteam crIn = new CryptoInputSteam(new FileInputStream(file), passByte)//;

        ) {
            int buff;

            while ((buff = crIn.read()) != -1) {

                byteList.add(Byte.valueOf((byte) buff));

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        for (byte b : byteData){
            byteList.add(b);
        }


        try(
                CryptoOutputStream crOut = new CryptoOutputStream(new FileOutputStream(file), passByte)
        )
        {
            for (Byte b : byteList) {

                crOut.write(b.byteValue());
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        //Файл нужно предварительно зашифровать с тем же ключем и
        //размером буфера с помощью данной программы(/src/lessons/lesson_15/homework/Task3.java)
        File f = new File("files/" + ConsoleHelper.readString());
        String s = ConsoleHelper.readString();

        //System.out.println(cryptoFileRead(f, "Шифр"));

        cryptoFileWrite(f,"Шифр", s);
        System.out.println(cryptoFileRead(f, "Шифр"));
    }
}
