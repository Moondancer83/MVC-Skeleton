package hu.kalee.skeleton.backend.model;

import java.util.Date;

/**
 * Backend output object.
 *
 * @author Moondancer
 * @since 2015.12.30..
 */
public class BackendOutputDTO {
    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
