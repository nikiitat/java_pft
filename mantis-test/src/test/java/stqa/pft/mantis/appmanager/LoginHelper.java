package stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import stqa.pft.mantis.model.UserData;

/**
 * Created by nikitatertytskyi on 01.03.2018.
 */
public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager app) {
        super(app);
    }

    public void resetUserPassword(UserData user) {
        selectUser(user.getId());
        resetPassword();
    }

    public void loginAsAdmin(String admin, String adminPassword) {
        login(admin, adminPassword);
        openManageUsers();
    }

    public void login(String userName, String password) {
        type(By.name("username"), userName);
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public void openManageUsers() {
        click(By.cssSelector("a[href='/mantisbt-1.2.19/manage_user_page.php']"));
    }

    public void selectUser(int id) {
        click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + id + "']"));
    }

    public void resetPassword() {
        click(By.cssSelector("input[value='Reset Password']"));
    }
}
