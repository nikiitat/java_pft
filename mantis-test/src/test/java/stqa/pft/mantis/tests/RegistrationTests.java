package stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by nikitatertytskyi on 26.02.2018.
 */
public class RegistrationTests extends TestBase {

    @Test
    public void testRegistration() {
        app.registration().start("test1", "test1@test.com");
    }
}
