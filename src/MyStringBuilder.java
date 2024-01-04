import java.util.ArrayList;
import java.util.Arrays;

public class MyStringBuilder {
    ArrayList<String> strings = new ArrayList<>();

    public void append(String string) {
        strings.add(string);
    }

    public String toString() {
        char[] characters = new char[100];
        int size = 0;

        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                if (size == characters.length)
                    characters = Arrays.copyOf(characters, 2 * characters.length);

                characters[size] = string.charAt(i);
                size++;
            }
        }

        characters = Arrays.copyOfRange(characters, 0, size);
        return new String(characters);
    }
}