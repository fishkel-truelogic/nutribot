package ar.com.nutribot.core.model;

import org.hibernate.validator.constraints.NotBlank;
/**
 * 
 * @author lfishkel
 *
 */
public class Role {
	
	private Long id;
	@NotBlank
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
