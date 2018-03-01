package stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 26.02.2018.
 */
public class RegistrationTests extends TestBase {

//    @BeforeMethod
    public void startMailServer() {
        app.mailHelper().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String email = String.format("test%s@localhost", now);
        String user = String.format("test%s", now);
        String password = "password";
        app.jamesHelper().createUser(user, password);
        app.registration().start(user, email);
//        List<MailMessage> mailMessages = app.mailHelper().waitForMail(2, 10000);
        List<MailMessage> mailMessages = app.jamesHelper().waitForMail(user,password, 60000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

//    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mailHelper().stop();
    }
}
