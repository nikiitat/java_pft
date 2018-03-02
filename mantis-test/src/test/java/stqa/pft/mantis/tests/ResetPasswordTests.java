package stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import stqa.pft.mantis.model.MailMessage;
import stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 01.03.2018.
 */
public class ResetPasswordTests extends TestBase {
    @BeforeMethod
    public void startMailServer() {
        app.mailHelper().start();
    }

    @Test
    public void testResetPasswordForUser() throws IOException, MessagingException {
        UserData user = app.dbMantisHelper().users().stream().filter((u) -> 1 != u.getId()).findAny()
                .orElseThrow(() -> new AssertionError("User not found, please create one!"));
        String admin = "administrator";
        String adminPassword = "root";
        String password = "Test123";
        app.loginHelper().loginAsAdmin(admin, adminPassword);
        app.loginHelper().resetUserPassword(user);
        List<MailMessage> mailMessages = app.mailHelper().waitForMail(1, 10000);
        String resetLink = findConfirmationLink(mailMessages, user.getEmail());
        app.registration().finish(resetLink, password);
        assertTrue(app.newSession().login(user.getUserName(), password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mailHelper().stop();
    }
}
