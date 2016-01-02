package hu.kalee.skeleton.business.model;

import hu.kalee.skeleton.backend.model.ResultStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moondancer
 * @since 2015.12.27..
 */
public class BusinessResult {
    private ResultStatus status;
    private OutputDTO outputDTO;
    private Map<String, String> messages;

    public BusinessResult() {
        status = ResultStatus.NOT_INITIALIZED;
        outputDTO = new BusinessOutputDTO();
        messages = new HashMap<String, String>();
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(final ResultStatus status) {
        this.status = status;
    }

    public OutputDTO getOutputDTO() {
        return outputDTO;
    }

    public void setOutputDTO(final OutputDTO outputDTO) {
        this.outputDTO = outputDTO;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(final Map<String, String> messages) {
        this.messages = messages;
    }

    public void addMessage(final String key, final String value) {
        messages.put(key, value);
    }
}
