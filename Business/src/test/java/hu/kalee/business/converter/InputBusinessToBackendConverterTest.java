package hu.kalee.business.converter;

import hu.kalee.skeleton.backend.model.BackendInputDTO;
import hu.kalee.skeleton.business.converter.InputBusinessToBackendConverter;
import hu.kalee.skeleton.business.model.BusinessInputDTO;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Moondancer
 * @since 2016.01.01..
 */
@RunWith(MockitoJUnitRunner.class)
public class InputBusinessToBackendConverterTest {
    @InjectMocks
    private InputBusinessToBackendConverter underTest;
    private BusinessInputDTO input;

    @Before
    public void setup() {
        input = new BusinessInputDTO();
    }

    @Test(expected = NullPointerException.class)
    public void testConverShouldThrowExceptionWhenNullIsGiven() {
        // GIVEN
        // WHEN
        underTest.convert(null);
        // THEN
    }

    @Test(expected = NumberFormatException.class)
    public void testConverShouldThrowExceptionWhenDataCannotBeParsedToInteger() {
        // GIVEN
        // WHEN
        underTest.convert(input);
        // THEN
    }

    @Test
    public void testConvertShouldConvertWellFormattedIntegerRepresentation() {
        // GIVEN
        input.setData("0002");
        // WHEN
        BackendInputDTO actual = underTest.convert(input);
        // THEN
        Assertions.assertThat(actual.getData()).isEqualTo(2);
    }
}
