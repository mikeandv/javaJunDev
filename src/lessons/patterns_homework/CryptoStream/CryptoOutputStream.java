package lessons.patterns_homework.CryptoStream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class CryptoOutputStream extends FilterOutputStream {
    private byte[] bytePass;
    private int i;

    public CryptoOutputStream(OutputStream out, byte[] pass) {
        super(out);
        this.bytePass = pass;
    }

    @Override
    public void write(int b) throws IOException {

        int p = (bytePass[cryptoP() % bytePass.length]);
        int r = (b ^ p);
        ++i;
        super.write(r);
    }

    private int cryptoP() {

        if(i >= 1024) {
            i = 0;
            return i;
        }
        return i;
    }
}
