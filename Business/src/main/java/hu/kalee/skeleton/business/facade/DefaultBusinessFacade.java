package hu.kalee.skeleton.business.facade;

import hu.kalee.skeleton.backend.model.BackendResult;
import hu.kalee.skeleton.backend.model.ResultStatus;
import hu.kalee.skeleton.backend.service.MockService;
import hu.kalee.skeleton.business.converter.InputBusinessToBackendConverter;
import hu.kalee.skeleton.business.converter.OutputBackendToBusinessConverter;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Moondancer
 * @since  2015.12.27..
 */
@Service
public class DefaultBusinessFacade implements BusinessFacade {
    @Inject
    private MockService service;
    @Inject
    private InputBusinessToBackendConverter toBackendConverter;
    @Inject
    private OutputBackendToBusinessConverter toBusinessConverter;

    @Override
    public BusinessResult process(final BusinessInputDTO input) {
        BusinessResult result = new BusinessResult();
        try {
            BackendResult backendResult = service.call(toBackendConverter.convert(input));
            result.setOutputDTO(toBusinessConverter.convert(backendResult.getDto()));
            result.setStatus(backendResult.getStatus());
            result.setMessages(backendResult.getMessages());
        } catch (Exception e) {
            result.setStatus(ResultStatus.ERROR);
            result.addMessage("message", e.getMessage());
        }

        return result;
    }
}
