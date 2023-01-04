package io.github.dannyprojrct;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.dannyprojrct.model.ToDo;
import io.github.dannyprojrct.repository.ToDoRepository;

@SpringBootApplication

public class ToDoApplication implements CommandLineRunner  {

	@Autowired  ToDoRepository toDoRepository;
	

	
	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
		
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		ToDo todo = new ToDo();
	
		todo.setDescription("Stud spring boot");
		todo.setCreatedDate(LocalDateTime.now());
		toDoRepository.save(todo);
	}

}
