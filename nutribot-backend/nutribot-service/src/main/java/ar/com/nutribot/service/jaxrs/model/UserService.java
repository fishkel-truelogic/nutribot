package ar.com.nutribot.service.jaxrs.model;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import ar.com.nutribot.core.model.User;
import ar.com.nutribot.core.model.dao.UserDao;
import ar.com.nutribot.dto.model.UserDTO;
import ar.com.nutribot.service.converter.model.UserConverter;


@Configurable
@Path("/user")
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserConverter userConverter;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		List<User> users = userDao.findAll();
		List<UserDTO> usersDTO = userConverter.toDTO(users);
		return Response.ok().entity(usersDTO).build();
	}
}
