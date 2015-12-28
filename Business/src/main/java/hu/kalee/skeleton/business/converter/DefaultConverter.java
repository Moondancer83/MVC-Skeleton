package hu.kalee.skeleton.business.converter;

import org.dozer.Mapper;

import javax.inject.Inject;

/**
 * Default Converter.
 *
 * @author Moondancer
 * @since 2015.12.28..
 */
public class DefaultConverter {
    @Inject
    Mapper mapper;

    /**
     * Converting Source object to Destination object.
     * Objects are mapped by field names.
     *
     * @param source Object to convert
     * @param type Type of destination object
     * @param <S> Type of source object
     * @param <D> type of destination object
     * @return destination object
     * @throws IllegalArgumentException when any given parameter is null
     */
    public <S, D> D convert(S source, Class<D> type) {
        if (source == null || type == null) {
            throw new IllegalArgumentException("Parameter 'source' and 'type' must not be null.");
        }
        return mapper.map(source, type);
    }
}
