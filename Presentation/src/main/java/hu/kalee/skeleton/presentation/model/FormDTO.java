package hu.kalee.skeleton.presentation.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Form hu.kalee.skeleton.business.facade.model.
 *
 * @author Moondancer
 * @since 2015.12.26..
 */
public class FormDTO {
    private String field;

    @NotEmpty
    @Pattern(regexp = "[0-9]{4}", message = "4 number digits are needed")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
