package homework16;

public class MailMessage extends Sendable<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
