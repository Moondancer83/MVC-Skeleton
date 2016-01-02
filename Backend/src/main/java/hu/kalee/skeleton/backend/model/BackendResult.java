package hu.kalee.skeleton.backend.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Backend result object.
 *
 * @author Moondancer
 * @since 2015.12.31..
 */
public class BackendResult implements MessageHolder {
    private ResultStatus status;
    private OutputDTO dto;
    private Map<String, String> messages;

    public BackendResult() {
        messages = new HashMap<String, String>();
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public OutputDTO getDto() {
        return dto;
    }

    public void setDto(OutputDTO dto) {
        this.dto = dto;
    }

    @Override
    public Map<String, String> getMessages() {
        return messages;
    }

    @Override
    public void addMessage(String key, String message) {
        messages.put(key, message);
    }
}
