package hu.kalee.skeleton.business.facade;

import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import hu.kalee.skeleton.business.model.ResultStatus;
import org.springframework.stereotype.Service;

/**
 * @author Moondancer
 * @since  2015.12.27..
 */
@Service
public class DefaultBusinessFacade implements BusinessFacade {
    @Override
    public BusinessResult process(BusinessInputDTO input) {
        BusinessResult result = new BusinessResult();
        result.setStatus(ResultStatus.OK);
        result.setOutputDTO(new BusinessOutputDTO());
        result.addMessage("message", "Success!");

        return result;
    }
}
