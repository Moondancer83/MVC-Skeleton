package hu.kalee.skeleton.presentation.converter;

import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import hu.kalee.skeleton.presentation.model.ResultDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Moondancer
 * @since 2015.12.23..
 */
@Component
public class BusinessToPresentationConverter implements Converter<BusinessOutputDTO, ResultDTO> {
    @Override
    public ResultDTO convert(final BusinessOutputDTO toConvert) {
        ResultDTO result = new ResultDTO();
        result.setAnswerDate(toConvert.getAnswerDate());

        return result;
    }
}
