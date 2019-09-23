/**
 * byte数组解码器
 */
public class ByteArrayRead {

    private byte[] buf;
    private int mark;

    public ByteArrayRead(byte[] buf) {
        this.buf = buf;
        this.mark = 0;
    }

    public boolean readBoolean() {
        return buf[mark++] == 1;
    }

    public int read() {
        byte[] b = new byte[4];
        read(b, 0, b.length);
        return b[3] & 0xFF        |
              (b[2] & 0xFF) << 8  |
              (b[1] & 0xFF) << 16 |
              (b[0] & 0xFF) << 24;
    }

    public void read(byte[] bytes, int off, int len) {
        System.arraycopy(buf, mark, bytes, off, len);
        mark += len;
    }

    public byte[] readAllBytes() {
        byte[] bytes = new byte[buf.length - mark];
        read(bytes, 0, bytes.length);
        return bytes;
    }
}