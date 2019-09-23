/**
 * byte数组累加器
 * 针对ByteArrayOutputStream的优化和封装
 */
public class ByteArrayWrite {

    private static final byte[] default_byte = new byte[0];

    private byte[] data;

    public ByteArrayWrite() {
        data = default_byte;
    }

    public void write(boolean b) {
        byte[] _new = new byte[data.length + 1];
        System.arraycopy(data, 0, _new, 0, data.length);
        _new[data.length] = (byte) (b ? 1 : 0);
        data = _new;
    }

    public void write(int i) {
        byte[] bytes = new byte[]
                {(byte) ((i >> 24) & 0xFF),
                 (byte) ((i >> 16) & 0xFF),
                 (byte) ((i >> 8 ) & 0xFF),
                 (byte) (i & 0xFF)};
        write(bytes);
    }

    public void write(byte[] bytes) {
        byte[] _new = new byte[data.length + bytes.length];
        System.arraycopy(data, 0, _new, 0, data.length);
        System.arraycopy(bytes, 0, _new, data.length, bytes.length);
        data = _new;
    }

    public byte[] toByteArray() {
        return data;
    }
}