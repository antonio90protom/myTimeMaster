package com.protom.mytime.dao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {
	
	@Autowired
	private ModelMapper mm;
	
	public <D, T> D map(final T entity, Class<D> outClass) {
        return mm.map(entity, outClass);
    }
	
	public <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }
	
	public <S, D> D map(final S source, D destination) {
        mm.map(source, destination);
        return destination;
    }

}
