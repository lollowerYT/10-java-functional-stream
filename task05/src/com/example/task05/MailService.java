package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {

    private final Map<String, List<T>> mailBox = new HashMap<>();

    @Override
    public void accept(Sendable<T> sendable) {
        mailBox
                .computeIfAbsent(sendable.getTo(), k -> new ArrayList<>())
                .add(sendable.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return new AbstractMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return mailBox.getOrDefault(key, Collections.emptyList());
            }

            @Override
            public Set<Entry<String, List<T>>> entrySet() {
                return mailBox.entrySet();
            }
        };
    }
}
