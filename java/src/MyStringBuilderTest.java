import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStringBuilderTest {
    @Test
    public void canBuildString() {
        MyStringBuilder builder = new MyStringBuilder();
        builder.append("This ");
        builder.append("is ");
        builder.append("a ");
        builder.append("test.");

        assertEquals("This is a test.", builder.toString());
    }
}
