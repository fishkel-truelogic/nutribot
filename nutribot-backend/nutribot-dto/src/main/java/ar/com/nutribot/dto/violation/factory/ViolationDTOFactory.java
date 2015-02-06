package ar.com.nutribot.dto.violation.factory;

import java.lang.reflect.Type;
import java.util.Collection;

import ar.com.nutribot.dto.factory.AbstractDTOFactory;
import ar.com.nutribot.dto.violation.ViolationDTO;

import com.google.gson.reflect.TypeToken;

/**
 * @author lfishkel
 */
public class ViolationDTOFactory extends AbstractDTOFactory<ViolationDTO> {

	@Override
	protected Type getEntityType() {
		return new TypeToken<ViolationDTO>() {
		}.getType();
	}

	@Override
	protected Type getCollectionType() {
		return new TypeToken<Collection<ViolationDTO>>() {
		}.getType();
	}
}