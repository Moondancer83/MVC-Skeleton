package hu.kalee.skeleton.business.model;

import java.util.Date;

/**
 * @author Moondancer
 * @since  2015.12.27..
 */
public class BusinessOutputDTO implements OutputDTO {
    private Date answerDate;

    public BusinessOutputDTO() {
        answerDate = new Date();
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }
}
