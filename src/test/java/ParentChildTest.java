import org.junit.Test;

public class ParentChildTest {

    @Test
    public void testParentChild() {
        final Parent p = new Child();
        p.doAnotherThing1();
    }

}
