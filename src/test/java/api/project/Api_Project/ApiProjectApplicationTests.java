//package api.project.Api_Project;
//
//import org.apache.tomcat.jni.User;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.*;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.HttpClientErrorException;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ApiProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ApiProjectApplicationTests {
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@LocalServerPort
//	private int port;
//
//	private String getRootUrl() {
//		return "http://localhost:" + port;
//	}
//
//
//	@Test
//	public void contextLoads() {
//	}
//
//	@Test
//	public void testGetAllUsers() {
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/Utilisateur", HttpMethod.GET, entity, String.class);
//		Assert.assertNotNull(response.getBody());
//
//	}
//
//	@Test
//	public void testCreateUser() {
//		Utilisateur user = new Utilisateur();
//		user.setId(1);
//		user.setName("JB");
//		user.setEmail("test@gmail.com");
//		user.setLogin("jb.marlon");
//
//		ResponseEntity<Utilisateur> postResponse = restTemplate.postForEntity(getRootUrl() + "/Utilisateur", user, Utilisateur.class);
//		Assert.assertNotNull(postResponse);
//		Assert.assertNotNull(postResponse.getBody());
//	}
//
//	@Test
//	public void testGetUserById() {
//		Utilisateur user = restTemplate.getForObject(getRootUrl() + "/Utilisateur/1", Utilisateur.class);
//		System.out.println(user.getName());
//		Assert.assertNotNull(user);
//	}
//
//
//	@Test
//	public void testUpdatePost() {
//		int id = 1;
//		Utilisateur user = restTemplate.getForObject(getRootUrl() + "/Utilisateur/" + id, Utilisateur.class);
//		user.setName("JB1");
//		restTemplate.put(getRootUrl() + "/Utilisateur/" + id, user);
//
//		Utilisateur updatedUser = restTemplate.getForObject(getRootUrl() + "/Utilisateur/" + id, Utilisateur.class);
//		Assert.assertNotNull(updatedUser);
//	}
//
//	@Test
//	public void testDeletePost() {
//		int id = 2;
//		Utilisateur user = restTemplate.getForObject(getRootUrl() + "/Utilisateur/" + id, Utilisateur.class);
//		Assert.assertNotNull(user);
//
//		restTemplate.delete(getRootUrl() + "/Utilissateur/" + id);
//
//		try {
//			user = restTemplate.getForObject(getRootUrl() + "/Utilisateur/" + id, Utilisateur.class);
//		} catch (final HttpClientErrorException e) {
//			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//		}
//	}
//
//}
