package hu.kalee.skeleton.presentation.converter;

import hu.kalee.skeleton.business.model.BusinessInputDTO;
import hu.kalee.skeleton.presentation.model.FormDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Moondancer
 * @since 2015.12.23..
 */
@Component
public class PresentationToBusinessInputConverter implements Converter<FormDTO, BusinessInputDTO> {
    @Override
    public BusinessInputDTO convert(FormDTO toConvert) {
        BusinessInputDTO result = new BusinessInputDTO();
        result.setData(toConvert.getField());

        return result;
    }
}
