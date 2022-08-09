package com.devdojo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.devdojo.client.Post;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
public class ClientPostController {
	
	private final RestTemplate restTemplate;

	
	@GetMapping
    public Post[] getProductList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, entity, Post[].class).getBody();
    }
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Post> getProductById(@PathVariable Integer id) {
		ResponseEntity<Post> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/"+id,HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		return ResponseEntity.ok(responseEntity.getBody());
	 }
		
	
	@RequestMapping(value = "/posts2")
    public ResponseEntity<List<Post>> getProductList2() {
		ResponseEntity<List<Post>> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		return ResponseEntity.ok(responseEntity.getBody());
    }
	
	
	
	// Application json
	@GetMapping(path= "/create")
    public String createPost(@RequestBody Post post) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<Post>(post, httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, entity, String.class).getBody();
    }
	// Application Objecto
	@GetMapping(path= "/create2")
    public ResponseEntity<Post> createPost2(@RequestBody Post post) {
		ResponseEntity<Post> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",HttpMethod.POST, new HttpEntity<>(post), Post.class);
		return ResponseEntity.ok(responseEntity.getBody());
    }

	
	
	// Application json
    @RequestMapping(value = "/posts/update/{id}")
    public String updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<>(post, httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }
    
    // Application Objecto
 	@RequestMapping(value = "/posts/update2/{id}")
     public ResponseEntity<Post> updatePost2(@PathVariable("id") int id, @RequestBody Post post) {
 		ResponseEntity<Post> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts"  + id,HttpMethod.PUT, new HttpEntity<>(post), Post.class);
 		return ResponseEntity.ok(responseEntity.getBody());
     }

 	
 	
 // Application json
    @RequestMapping(value = "/posts/delete/{id}")
    public String deletePost(@PathVariable("id") int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }
    
 // Application Objecto
  	@RequestMapping(value = "/posts/delete2/{id}")
      public ResponseEntity<Post> deletePost2(@PathVariable("id") int id) {
  		ResponseEntity<Post> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts"  + id,HttpMethod.DELETE, null, Post.class);
  		return ResponseEntity.ok(responseEntity.getBody());
      }

	
}
