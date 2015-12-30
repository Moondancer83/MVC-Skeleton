package hu.kalee.skeleton.presentation.model;

import java.util.Map;

/**
 * Message holder.
 *
 * @author Moondancer
 * @since 2015.12.30..
 */
public interface MessageHolder {
    Map<String, String> getMessages();

    void addMessage(String key, String message);
}
