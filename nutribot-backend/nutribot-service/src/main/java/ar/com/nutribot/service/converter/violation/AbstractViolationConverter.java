package ar.com.nutribot.service.converter.violation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;

import ar.com.nutribot.dto.violation.ViolationDTO;


/**
 * @author lfishkel
 */
public abstract class AbstractViolationConverter<T> {

	public List<ViolationDTO> toDTO(List<ConstraintViolation<T>> violations) {
		List<ViolationDTO> dtos = new ArrayList<ViolationDTO>();
		for (ConstraintViolation<T> constraintViolation : violations) {
			dtos.add(toDTO(constraintViolation));
		}
		return dtos;
	}

	public ViolationDTO toDTO(ConstraintViolation<T> constraintViolation) {
		ViolationDTO dto = new ViolationDTO();
		dto.setInvalidValue(constraintViolation.getInvalidValue() == null ? "" : constraintViolation.getInvalidValue().toString());
		dto.setMessage(constraintViolation.getMessage());
		dto.setMessageTemplate(constraintViolation.getMessageTemplate());
		dto.setProperty(constraintViolation.getPropertyPath().toString());
		return dto;
	}
}