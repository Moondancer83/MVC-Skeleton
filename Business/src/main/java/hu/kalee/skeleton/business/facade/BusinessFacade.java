package hu.kalee.skeleton.business.facade;

import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;

/**
 * @author Moondancer
 * @since  2015.12.27..
 */
public interface BusinessFacade {
    /**
     * Entry point.
     *
     * @param input The input
     * @return The result
     */
    BusinessResult form(BusinessInputDTO input);
}
