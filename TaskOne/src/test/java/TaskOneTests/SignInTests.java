package TaskOneTests;


import Base.BaseComponent;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignInTests extends BaseComponent {
    private static BaseComponent component;

    @BeforeClass
    public static void before() {
        component = BaseComponent.getInstance();
    }

    @Test
    public void a_logInWithValidEmailAndUserName() {
        component.logInValidEmailAndUserName();
    }

    @Test
    public void b_logInWithInvalidPasswordValidEmail() {
        component.logInInvalidPasswordValidEmail();
    }

    @Test
    public void c_logInWithInvalidPasswordValidUserName() {
        component.logInInvalidPasswordValidUserName();
    }

    @Test
    public void d_logInWithInvalidEmailInvalidPassword() {
        component.logInInvalidEmailInvalidPassword();
    }

    @Test
    public void d_logInWithInvalidUserNameInvalidPassword() {
        component.logInInvalidUserNameInvalidPassword();
    }


}
