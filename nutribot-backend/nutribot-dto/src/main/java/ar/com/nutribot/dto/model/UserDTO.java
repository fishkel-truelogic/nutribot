package ar.com.nutribot.dto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfishkel
 */
public class UserDTO {

	private String id;

	private String username;

	private String password;

	private boolean enabled;

	private List<RoleDTO> roles;

	private String urlRoles;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleDTO> getRoles() {
		if (roles == null) roles = new ArrayList<RoleDTO>();
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public String getUrlRoles() {
		return urlRoles;
	}

	public void setUrlRoles(String urlRoles) {
		this.urlRoles = urlRoles;
	}

	public void addRole(RoleDTO role) {
		if (this.roles == null) {
			this.roles = new ArrayList<RoleDTO>();
		}
		this.roles.add(role);
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}