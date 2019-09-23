import java.io.IOException;

public class MsgpackTest {
    public static void main(String[] args) throws IOException {
        People people = new People("TK", 24, true);
        System.out.println(people);

        byte[] to = people.to();
        People from = People.from(to);
        System.out.println(from);
    }
}
