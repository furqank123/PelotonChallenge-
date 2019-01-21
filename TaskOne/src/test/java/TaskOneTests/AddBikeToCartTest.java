package TaskOneTests;


import Base.BaseComponent;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)


public class AddBikeToCartTest extends BaseComponent {
    private static BaseComponent component;

    @BeforeClass
    public static void before() {
        component = BaseComponent.getInstance();
    }

    @Test
    public void addBikeAutomatedFlow() {
        component.addBikeToCart();
    }
}
