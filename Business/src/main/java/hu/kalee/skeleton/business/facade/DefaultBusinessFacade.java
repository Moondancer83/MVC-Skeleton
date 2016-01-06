package hu.kalee.skeleton.business.facade;

import hu.kalee.skeleton.business.executor.DefaultBusinessExecutor;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.business.model.BusinessResult;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * DefaultBusinessFacade.
 *
 * @author Moondancer
 * @since 2016.01.06..
 */
@Service
public class DefaultBusinessFacade implements BusinessFacade {
    @Inject
    private DefaultBusinessExecutor businessEcecutor;

    @Override
    public BusinessResult form(BusinessInputDTO input) {
        return businessEcecutor.process(input);
    }
}
