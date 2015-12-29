package hu.kalee.skeleton.presentation.converter;

import hu.kalee.skeleton.business.model.BusinessOutputDTO;
import hu.kalee.skeleton.presentation.model.Result;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Moondancer
 * @since 2015.12.23..
 */
@Component
public class BusinessToPresentationConverter implements Converter<BusinessOutputDTO, Result> {
    @Override
    public Result convert(BusinessOutputDTO toConvert) {
        Result result = new Result();
        result.setAnswerDate(toConvert.getAnswerDate());

        return result;
    }
}
