package ar.com.nutribot.service.converter.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.nutribot.core.model.User;
import ar.com.nutribot.dto.model.UserDTO;


/**
 * @author lfishkel
 */
public class UserConverter {

	@Autowired
	private RoleConverter roleConverter;

	public List<UserDTO> toDTO(List<User> users) {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (User user : users) {
			dtos.add(this.toDTO(user));
		}
		return dtos;
	}

	public UserDTO toDTO(User user) {
		if (user == null) {
			return null;
		}
		UserDTO dto = new UserDTO();
		dto.setRoles(roleConverter.toDTO(user.getRoles()));
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setEnabled(user.isEnabled());
		dto.setPassword(user.getPassword());
		return dto;
	}

	public User toEntity(UserDTO userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setEnabled(userDto.isEnabled());
		user.setPassword(userDto.getPassword());
		user.setRoles(roleConverter.toEntity(userDto.getRoles()));
		return user;
	}
}