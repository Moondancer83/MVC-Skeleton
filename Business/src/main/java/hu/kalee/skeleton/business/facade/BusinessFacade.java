package hu.kalee.skeleton.business.facade;

import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;

/**
 * @author Moondancer
 * @since  2015.12.27..
 */
public interface BusinessFacade {
    BusinessResult process(BusinessInputDTO input);
}
