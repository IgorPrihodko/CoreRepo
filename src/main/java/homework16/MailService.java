package homework16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    @Override
    public void accept(Sendable<T> sendable) {
        List<T> list = mailBox.get(sendable.getTo());
        list.add(sendable.getContent());
        mailBox.put(sendable.getTo(), list);
    }

    private Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, new ArrayList<>());
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
