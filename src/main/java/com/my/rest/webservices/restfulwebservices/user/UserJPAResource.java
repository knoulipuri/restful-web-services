package com.my.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("jpa")
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;


	@GetMapping("/users")
	public List<User> retrieveAllUesrs() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> userOptional=userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}		
		return userOptional.get();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userRepository.save(user);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		//return service.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);			
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrievePosts(@PathVariable int id) {
		
		Optional<User> userOptional=userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		List<Post> posts=userOptional.get().getPosts();
		return posts;
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> userOptional=userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		
		User user=userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}

}
