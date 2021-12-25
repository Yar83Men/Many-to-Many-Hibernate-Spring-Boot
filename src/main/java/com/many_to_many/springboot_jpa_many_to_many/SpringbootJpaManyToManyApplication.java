package com.many_to_many.springboot_jpa_many_to_many;

import com.many_to_many.springboot_jpa_many_to_many.entity.Post;
import com.many_to_many.springboot_jpa_many_to_many.entity.Tag;
import com.many_to_many.springboot_jpa_many_to_many.repository.PostRepository;
import com.many_to_many.springboot_jpa_many_to_many.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpaManyToManyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaManyToManyApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private TagRepository tagRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Post post = new Post("Many to Many","Hibernate Many to Many", "Dscription Hibernate Many to Many");
		Post post1 = new Post("Post 1 Many to Many","Hibernate Many to Many", "Dscription Post 1 Hibernate Many to Many");
		
		Tag tag = new Tag("Spring Boot");
		Tag hibernate = new Tag("Hibernate");

		post.getTags().add(tag);
		post.getTags().add(hibernate);

		tag.getPosts().add(post);
		hibernate.getPosts().add(post);

		tag.getPosts().add(post1);
		post1.getTags().add(tag);
		
		postRepository.save(post);	
		postRepository.save(post1);	
	}

}
