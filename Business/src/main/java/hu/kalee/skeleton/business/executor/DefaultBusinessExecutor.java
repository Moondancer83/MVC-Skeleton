package hu.kalee.skeleton.business.executor;

import hu.kalee.skeleton.backend.model.BackendInputDTO;
import hu.kalee.skeleton.backend.model.BackendOutputDTO;
import hu.kalee.skeleton.backend.model.BackendResult;
import hu.kalee.skeleton.backend.service.MockService;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @author Moondancer
 * @since 2015.12.27..
 */
@Component
public class DefaultBusinessExecutor extends AbstractExecutor<BusinessInputDTO, BackendInputDTO, BackendOutputDTO, BusinessOutputDTO> {
    @Inject
    private MockService service;

    @Inject
    public DefaultBusinessExecutor(final Converter<BusinessInputDTO, BackendInputDTO> toBackendConverter, final Converter<BackendOutputDTO, BusinessOutputDTO> toBusinessConverter) {
        super(toBackendConverter, toBusinessConverter);
    }

    /**
     * Method from AbstractFacade.
     *
     * @param backendInput The backend formatted input
     * @return The backend result
     */
    @Override
    BackendResult callService(final BackendInputDTO backendInput) {
        return service.call(backendInput);
    }
}
