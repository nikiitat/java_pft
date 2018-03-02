package stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import stqa.pft.mantis.model.UserData;

/**
 * Created by nikitatertytskyi on 26.02.2018.
 */
public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(UserData userData) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), userData.getUserName());
        type(By.name("email"), userData.getEmail());
        click(By.cssSelector("input[value='Signup']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
