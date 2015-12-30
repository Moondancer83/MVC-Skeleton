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
        BusinessResult result;
        if ("0000".equals(input.getData())) {
            result = getErrorResult();
        } else if ("0001".equals(input.getData())) {
            result = getWarningResult();
        } else if ("0666".equals(input.getData())) {
            throw new IllegalStateException("Something went wrong.");
        } else {
            result = getOkResult();
        }
        return result;
    }

    private BusinessResult getWarningResult() {
        BusinessResult result = new BusinessResult();
        result.setStatus(ResultStatus.WARNING);
        result.setOutputDTO(new BusinessOutputDTO());
        result.addMessage("message", "Warning");
        result.addMessage("warning", "No match found.");

        return result;
    }

    private BusinessResult getErrorResult() {
        BusinessResult result = new BusinessResult();
        result.setStatus(ResultStatus.ERROR);
        result.setOutputDTO(new BusinessOutputDTO());
        result.addMessage("message", "System crash...");

        return result;
    }

    private BusinessResult getOkResult() {
        BusinessResult result = new BusinessResult();
        result.setStatus(ResultStatus.OK);
        result.setOutputDTO(new BusinessOutputDTO());
        result.addMessage("message", "Success!");

        return result;
    }
}
