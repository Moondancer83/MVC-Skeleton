package hu.kalee.skeleton.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Form model.
 *
 * @author Moondancer
 * @since 2015.12.26..
 */
public class Form {
    private String field;

    @NotEmpty
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
