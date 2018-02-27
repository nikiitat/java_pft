package stqa.pft.mantis.model;

/**
 * Created by nikitatertytskyi on 27.02.2018.
 */
public class MailMessage {
    public String to;
    public String text;

    public MailMessage(String to, String text) {
        this.to = to;
        this.text = text;
    }
}
