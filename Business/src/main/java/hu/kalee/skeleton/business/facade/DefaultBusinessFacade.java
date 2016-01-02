package hu.kalee.skeleton.business.facade;

import hu.kalee.skeleton.backend.model.BackendInputDTO;
import hu.kalee.skeleton.backend.model.BackendOutputDTO;
import hu.kalee.skeleton.backend.model.BackendResult;
import hu.kalee.skeleton.backend.service.MockService;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Moondancer
 * @since  2015.12.27..
 */
@Service
public class DefaultBusinessFacade extends AbstractBusinessFacade<BusinessInputDTO, BackendInputDTO, BackendOutputDTO, BusinessOutputDTO> implements BusinessFacade {
    @Inject
    private MockService service;

    @Inject
    public DefaultBusinessFacade(Converter<BusinessInputDTO, BackendInputDTO> toBackendConverter, Converter<BackendOutputDTO, BusinessOutputDTO> toBusinessConverter) {
        super(toBackendConverter, toBusinessConverter);
    }

    /**
     * Entry point.
     *
     * @param input The input
     * @return The result
     */
    @Override
    public BusinessResult form(BusinessInputDTO input) {
        return super.process(input);
    }

    /**
     * Method from AbstractFacade.
     *
     * @param backendInput The backend formatted input
     * @return The backend result
     */
    @Override
    BackendResult callService(BackendInputDTO backendInput) {
        return service.call(backendInput);
    }
}
