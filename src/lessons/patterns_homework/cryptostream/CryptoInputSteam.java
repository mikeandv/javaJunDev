package lessons.patterns_homework.cryptostream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputSteam extends FilterInputStream {
    private byte[] bytePass;
    private int i;

    protected CryptoInputSteam(InputStream in, byte[] pass) {
        super(in);
        this.bytePass = pass;
    }

//    @Override
//    public int read(byte[] b, int off, int len) throws IOException {
//
//        int bytesNum = super.read(b, off, b.length);
//        if (bytesNum < 0)
//            return bytesNum;
//
//        for (int i = 0; i < b.length; i++) {
//            b[i] = (byte) (b[i] ^ bytePass[i % bytePass.length]);
//        }
//        return bytesNum;
//    }

//    @Override
//    public int read(byte[] b) throws IOException {
//        int bytesNum = super.read(b);
//
//        if (bytesNum < 0)
//            return bytesNum;
//
//        for (int i = 0; i < b.length; i++) {
//            b[i] = (byte) (b[i] ^ bytePass[i % bytePass.length]);
//        }
//        return bytesNum;
//    }

    @Override
    public int read() throws IOException {

        int in = super.read();
        if(in == -1)
            return -1;
        byte p = bytePass[cryptoP() % bytePass.length];
        int r = ((byte) in ^ p);
        ++i;

        return r;
    }

    private int cryptoP() {
        if(i >= 1024) {
            i = 0;
            return i;
        }
        return i;
    }
}
