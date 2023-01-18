package org.bookery.utilities;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

import org.springframework.beans.BeanWrapperImpl;

public class MappingUtility 
{
	public static String[] getNullPropertyNames(Object source) 
	{
        var wrapper = new BeanWrapperImpl(source);
        
		return Stream
			.of(wrapper.getPropertyDescriptors())
            .map(FeatureDescriptor::getName)
            .filter(propertyName -> wrapper.getPropertyValue(propertyName) == null)
            .toArray(String[]::new);
    }
}