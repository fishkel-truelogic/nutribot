package ar.com.nutribot.service.converter.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.nutribot.core.model.Role;
import ar.com.nutribot.dto.model.RoleDTO;

/**
 * @author lfishkel
 */
public class RoleConverter {

	public List<RoleDTO> toDTO(List<Role> roles) {
		List<RoleDTO> dtos = new ArrayList<RoleDTO>();
		for (Role role : roles) {
			dtos.add(toDTO(role));
		}
		return dtos;
	}

	public List<Role> toEntity(List<RoleDTO> roles) {
		List<Role> entities = new ArrayList<Role>();
		for (RoleDTO roleDTO : roles) {
			entities.add(toEntity(roleDTO));
		}
		return entities;
	}

	public RoleDTO toDTO(Role role) {
		if (role == null) {
			return null;
		}
		RoleDTO dto = new RoleDTO();
		dto.setId(role.getId());
		dto.setName(role.getName());
		return dto;
	}

	public Role toEntity(RoleDTO dto) {
		Role role = new Role();
		role.setId(dto.getId());
		role.setName(dto.getName());
		return role;
	}
	
}
