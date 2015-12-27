package hu.kalee.skeleton.presentation.model;

import java.util.Date;

/**
 * @author Moondancer
 * @since 2015.12.23..
 */
public class Result {
    private Date answerDate;
    private String field;

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
