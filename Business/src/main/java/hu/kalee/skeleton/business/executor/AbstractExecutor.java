package hu.kalee.skeleton.business.executor;

import hu.kalee.skeleton.backend.model.BackendResult;
import hu.kalee.skeleton.backend.model.InputDTO;
import hu.kalee.skeleton.backend.model.OutputDTO;
import hu.kalee.skeleton.backend.model.ResultStatus;
import hu.kalee.skeleton.business.model.BusinessResult;
import org.springframework.core.convert.converter.Converter;

/**
 * Abstract facade.
 *
 * @author Moondancer
 * @since 2016.01.02..
 */
public abstract class AbstractExecutor<A extends InputDTO, B extends InputDTO, C extends OutputDTO, D extends OutputDTO> {
    private Converter<A, B> toBackendConverter;
    private Converter<C, D> toBusinessConverter;

    public AbstractExecutor(final Converter<A, B> toBackendConverter, final Converter<C, D> toBusinessConverter) {
        this.toBackendConverter = toBackendConverter;
        this.toBusinessConverter = toBusinessConverter;
    }

    /**
     * Facade base workflow.
     *
     * @param input The input DTO.
     * @return The result.
     */
    public BusinessResult process(final A input) {
        BusinessResult result = new BusinessResult();
        try {
            B backendInput = toBackendConverter.convert(input);
            BackendResult backendResult = callService(backendInput);
            @SuppressWarnings("unchecked")
            C backendOutput = (C) backendResult.getDto();
            D businessOutput = toBusinessConverter.convert(backendOutput);

            result.setOutputDTO(businessOutput);
            result.setStatus(backendResult.getStatus());
            result.setMessages(backendResult.getMessages());
        } catch (Exception e) {
            result.setStatus(ResultStatus.ERROR);
            result.addMessage("message", e.getMessage());
        }

        return result;
    }

    /**
     * Calls specific service.
     *
     * @param backendInput The backend formatted input
     * @return The backend result
     */
    abstract BackendResult callService(final B backendInput);
}
