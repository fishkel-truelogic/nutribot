package ar.com.nutribot.dto.model.factory;

import java.lang.reflect.Type;
import java.util.Collection;

import ar.com.nutribot.dto.factory.AbstractDTOFactory;
import ar.com.nutribot.dto.model.RoleDTO;

import com.google.gson.reflect.TypeToken;

/**
 * @author lfishkel
 */
public class RoleDTOFactory extends AbstractDTOFactory<RoleDTO> {

	@Override
	protected Type getEntityType() {
		return new TypeToken<RoleDTO>() {
		}.getType();
	}

	@Override
	protected Type getCollectionType() {
		return new TypeToken<Collection<RoleDTO>>() {
		}.getType();
	}

}