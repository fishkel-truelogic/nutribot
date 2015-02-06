package ar.com.nutribot.core;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.nutribot.core.model.Role;
import ar.com.nutribot.core.model.User;
import ar.com.nutribot.core.model.dao.RoleDao;
import ar.com.nutribot.core.model.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/core-config.xml"})
public class DatabaseConnectionTest {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	private String userId;
	private Long roleId;
	
	@Test
	public void save() {
		boolean exists = false;
		List<User> users = userDao.findAll();
		for (User u : users) {
			if (u.getUsername().equalsIgnoreCase("username")) {
				exists = true;
				break;
			}
		}
		
		if (!exists) {
			Role role = new Role();
			role.setName("user");
			
			roleDao.save(role);
			roleId = role.getId();
			
			User user = new User();
			user.setPassword("123");
			user.setUsername("username");
			user.addRole(role);
			
			userDao.save(user);
			userId = user.getId();
			assert userId != null && !userId.isEmpty();
		} else {
			Role role = roleDao.findAll().get(0);
			User user = new User();
			user.setPassword("123");
			user.setUsername("username");
			user.addRole(role);
			try {
				userDao.save(user);
				
			} catch (Exception e) {
				assert true;
			}
		}
	}
	
	@Test
	public void findAndDelete() {
		if (userId != null) {
			User user = userDao.findById(userId);
			userDao.remove(user);
		}
		
		if (roleId != null && roleId != 0L) {
			Role role = roleDao.findById(roleId);
			roleDao.remove(role);
		}
	}
	
}
