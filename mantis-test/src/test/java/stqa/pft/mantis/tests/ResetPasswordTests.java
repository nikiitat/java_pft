package stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by nikitatertytskyi on 01.03.2018.
 */
public class ResetPasswordTests extends TestBase {
    @BeforeMethod
    public void startMailServer() {
        app.mailHelper().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
//        long now = System.currentTimeMillis();
//        String email = String.format("test%s@localhost", now);
        String user = "administrator";
        String password = "root";
//        app.jamesHelper().createUser(user, password);
        app.loginHelper().login(user, password);
        app.loginHelper().openManageUsers();
        app.loginHelper().selectUser(user);
//        List<MailMessage> mailMessages = app.mailHelper().waitForMail(2, 10000);
////        List<MailMessage> mailMessages = app.jamesHelper().waitForMail(user,password, 60000);
//        String confirmationLink = findConfirmationLink(mailMessages, email);
//        app.registration().finish(confirmationLink, password);
//        assertTrue(app.newSession().login(user, password));
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
