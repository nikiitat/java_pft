package stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by nikitatertytskyi on 26.02.2018.
 */
public class RegistrationHelper {


    private final ApplicationManager app;
    private WebDriver driver;

    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        driver = app.getDriver();
    }

    public void start(String userName, String email) {
        driver.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    }
}
