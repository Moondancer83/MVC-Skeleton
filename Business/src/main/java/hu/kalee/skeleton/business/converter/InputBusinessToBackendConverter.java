package hu.kalee.skeleton.business.converter;

import hu.kalee.skeleton.backend.model.BackendInputDTO;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Business to backend converter of input.
 *
 * @author Moondancer
 * @since 2016.01.01..
 */
@Component
public class InputBusinessToBackendConverter implements Converter<BusinessInputDTO, BackendInputDTO> {
    /**
     * Converts input data from business to backend format.
     *
     * @param toConvert data to convert
     * @return converted data
     * @throws NumberFormatException when data cannot be parsed to integer
     */
    @Override
    public BackendInputDTO convert(BusinessInputDTO toConvert) {
        BackendInputDTO result = new BackendInputDTO();
        result.setData(Integer.valueOf(toConvert.getData()));

        return result;
    }
}
