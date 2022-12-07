package com.alandev.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alandev.webservices.entities.User;
import com.alandev.webservices.rerpositories.UserRepository;
import com.alandev.webservices.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		BeanUtils.copyProperties(user, entity,"id");
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
