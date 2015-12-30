package hu.kalee.skeleton.presentation.model;

import hu.kalee.skeleton.business.model.OutputDTO;

import java.util.Date;

/**
 * @author Moondancer
 * @since 2015.12.23..
 */
public class ResultDTO implements OutputDTO {
    private Date answerDate;
    private String field;

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(final Date answerDate) {
        this.answerDate = answerDate;
    }

    public String getField() {
        return field;
    }

    public void setField(final String field) {
        this.field = field;
    }
}
