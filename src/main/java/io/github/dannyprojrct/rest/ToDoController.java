package io.github.dannyprojrct.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.dannyprojrct.model.ToDo;
import io.github.dannyprojrct.repository.ToDoRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todos")
@CrossOrigin("*")
public class ToDoController {

	@Autowired
	private ToDoRepository toDoRepository;

	@PostMapping
	public ToDo save(@RequestBody ToDo todo) {
		return toDoRepository.save(todo);
	}

	@GetMapping("{id}")
	public ToDo getById(@PathVariable Long id) {

		return toDoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	@GetMapping
	public @ResponseBody List<ToDo> getList() {
		return toDoRepository.findAll();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		toDoRepository.deleteById(id);

	}

	@PatchMapping("{id}/done")
	public ToDo markAsDone(@PathVariable Long id) {
		return toDoRepository.findById(id).map(todo -> {
			todo.setDone(true);
			todo.setDoneDate(LocalDateTime.now());
			toDoRepository.save(todo);
			return todo;
		}).orElse(null);
	}

}
