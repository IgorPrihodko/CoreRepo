package homework16;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    @Override
    public void accept(Sendable<T> tSendable) {
        List<T> list;
        list = mailBox.get(tSendable.getTo());
        list.add(tSendable.getContent());
        mailBox.put(tSendable.getTo(), list);
    }

    private Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            if (!this.containsKey(key)) {
                return new ArrayList<>();
            }
            return super.get(key);
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
