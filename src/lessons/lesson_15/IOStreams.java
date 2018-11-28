package lessons.lesson_15;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

public class IOStreams {

    protected long readByte(File file) throws Exception{
        long byteSum = 0;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            System.out.println(fileInputStream.available());
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();

                byteSum += data;
            }
            return byteSum;
        }

    }

    private void readByteArray(File file, Charset charset) throws Exception{
        try(InputStream in =
                new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream())
        {
            byte[] buf = new byte[1024];

            int len;
            while ((len = in.read(buf)) > 0) {
                System.out.println(Arrays.toString(buf));
                byteArrayOutputStream.write(buf, 0 ,len);
            }

            System.out.println(
                    new String(byteArrayOutputStream.toByteArray())
            );

        }
    }

    private void writeToFile(File file, boolean append, Charset charset) throws IOException {
        try(FileOutputStream fileOutputStream =
                new FileOutputStream(file, append)) {

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 6; i++) {
                sb.append("line ").append(i).append('\n');
            }

            byte[] bytes = sb.toString().getBytes(charset);
            fileOutputStream.write(bytes);

        }

    }

    public void writeWithBuffer(File file) throws IOException{
        try(
                FileOutputStream out =
                        new FileOutputStream(file);
                BufferedOutputStream buf =
                        new BufferedOutputStream(out);
                )
        {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 50; i++) {
                sb.append("line ").append(i).append('\n');
            }

            byte[] buffer = sb.toString().getBytes();
            buf.write(buffer,0, buffer.length);
        }
    }

    private void readFromTwoFiles(File[] files, Charset charset) throws IOException{
        try(
                InputStream input1 = new FileInputStream(files[0]);
                InputStream input2 = new FileInputStream(files[1]);
                ByteArrayOutputStream bout = new ByteArrayOutputStream()
                )
        {
            SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);
            byte[] buf = new byte[1024];

            int len;

            while ((len = sequenceInputStream.read(buf)) > 0) {
                bout.write(buf, 0, len);
            }

            System.out.println(new String(
                    bout.toByteArray(), charset
            ));
        }
    }

    public static void dataOutput(OutputStream out) throws IOException {

        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeInt(555577);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeUTF("Kyrluk");


    }

    public static void dataInput(InputStream in) throws IOException {

        DataInputStream dataInputStream = new DataInputStream(in);
        boolean b = dataInputStream.readBoolean();
        int i = dataInputStream.readInt();
        String s = dataInputStream.readUTF();

        System.out.println(i + "\n" + b + "\n" + s);

    }

    public String  readURL(String url, Charset charset) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("Accept-Charset", charset.name());

        try (InputStream in = conn.getInputStream()) {
            return readText(in, charset);
        }
    }

    private String readText(InputStream in, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(in, charset);
        StringBuilder sb = new StringBuilder();

        char[] buf = new char[20];

        int len;

        while ((len = reader.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

//        PipedInputStream; для работы в много поточной среде
//        PipedOutputStream

//        FilterInputStream filterInputStream;  для расширения функионала можно отнаследоваться и добавить методы
//        FilterOutputStream filterOutputStream;


        IOStreams ioStreams = new IOStreams();



        File file = new File("test.txt");
//        File file1 = new File("tt.txt");
//        File[] f = {file, file1};
//          ioStreams.readFromTwoFiles(f,Charset.forName("UTF-8"));


//        System.out.println(ioStreams.readByte(file));

//        ioStreams.readByteArray(file, Charset.forName("UTF-8"));

//        ioStreams.writeToFile(file, false, Charset.forName("UTF-8"));
//        ioStreams.writeWithBuffer(file);

//

//        try(OutputStream out = new FileOutputStream(file))
//        {
//            dataOutput(out);
//        }

//        try(InputStream inputStream = new FileInputStream(file))
//        {
//            dataInput(inputStream);
//        }

        String st = ioStreams.readURL("https://www.google.ru/", Charset.forName("UTF-8"));
        System.out.println(st);

    }
}
// ДЗ посмотреть RandomAccessFile