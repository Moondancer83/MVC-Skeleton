package hu.kalee.skeleton.presentation.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Form hu.kalee.skeleton.business.facade.model.
 *
 * @author Moondancer
 * @since 2015.12.26..
 */
public class FormDTO {
    private List<String> warnings;

    private String field;

    public FormDTO() {
        warnings = new ArrayList<>();
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public void addWarning(String warning) {
        warnings.add(warning);
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
