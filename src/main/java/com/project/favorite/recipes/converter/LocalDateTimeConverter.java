package com.project.favorite.recipes.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.AttributeConverter;

/**
 * {@link LocalDateTimeConverter}
 * Local date time converter class has been created for local date handling
 * @author Sumit.Vaidya
 *
 */
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	@Override
	  public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
	    return Optional.ofNullable(localDateTime)
	        .map(Timestamp::valueOf)
	        .orElse(null);
	  }

	  @Override
	  public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
	    return Optional.ofNullable(timestamp)
	        .map(Timestamp::toLocalDateTime)
	        .orElse(null);
	  }
}
