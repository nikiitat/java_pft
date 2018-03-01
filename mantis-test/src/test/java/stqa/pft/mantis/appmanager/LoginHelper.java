package stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by nikitatertytskyi on 01.03.2018.
 */
public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String userName, String password) {
        type(By.name("username"), userName);
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public void openManageUsers(){
        click(By.cssSelector("a[href='/mantisbt-1.2.19/manage_user_page.php']"));
    }

    public void selectUser(String user) {

    }
}
