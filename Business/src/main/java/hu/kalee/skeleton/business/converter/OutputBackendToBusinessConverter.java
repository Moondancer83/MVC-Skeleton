package hu.kalee.skeleton.business.converter;

import hu.kalee.skeleton.backend.model.BackendOutputDTO;
import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Backend to business converter of output.
 *
 * @author Moondancer
 * @since 2016.01.01..
 */
@Component
public class OutputBackendToBusinessConverter implements Converter<BackendOutputDTO, BusinessOutputDTO> {

    /**
     * Converts output data from backend to business format.
     *
     * @param toConvert Backend Output DTO
     * @return Business Output DTO
     */
    @Override
    public BusinessOutputDTO convert(BackendOutputDTO toConvert) {
        BusinessOutputDTO result = new BusinessOutputDTO();
        result.setAnswerDate(toConvert.getCreated());

        return result;
    }
}
