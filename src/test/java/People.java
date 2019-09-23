import java.io.IOException;

public class People {

    private String name;
    private int age;
    private boolean sex; // true:man

    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public byte[] to() throws IOException {
        MsgpackEncoder me = new MsgpackEncoder();
        me.write(name).write(age).write(sex);
        return me.toByteArray();
    }

    public static People from(byte[] code) throws IOException {
        MsgpackDecoder md = new MsgpackDecoder(code);
        return new People(md.readString(), md.readInt(), md.readBoolean());
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + (sex ? "man" : "woman") +
                '}';
    }
}