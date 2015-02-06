package ar.com.nutribot.core.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author lfishkel
 *
 */
public class User {
	
	private String id;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private boolean enabled;
	private List<Role> roles;

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

	public List<Role> getRoles() {
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		this.getRoles().add(role);
	}

	public void removeRole(Role role) {
		this.getRoles().remove(role);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
