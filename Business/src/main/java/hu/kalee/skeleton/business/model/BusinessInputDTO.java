package hu.kalee.skeleton.business.model;

import hu.kalee.skeleton.backend.model.InputDTO;

/**
 * @author Moondancer
 * @since  2015.12.27..
 */
public class BusinessInputDTO implements InputDTO {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
