package hu.kalee.skeleton.presentation.model;

import hu.kalee.skeleton.business.model.InputDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

/**
 * Form hu.kalee.skeleton.business.facade.model.
 *
 * @author Moondancer
 * @since 2015.12.26..
 */
public class FormDTO implements InputDTO, MessageHolder {
    private Map<String, String> messages;

    private String field;

    public FormDTO() {
        messages = new HashMap<String, String>();
    }

    @Override
    public Map<String, String> getMessages() {
        return messages;
    }

    @Override
    public void addMessage(String key, String message) {
        messages.put(key, message);
    }

    @NotEmpty
    @Pattern(regexp = "[0-9]{4}", message = "4 number digits are needed")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
