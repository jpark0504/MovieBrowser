package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Director;
import com.example.demo.repo.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	private DirectorRepository dirRepo;
	
	@Override
	@Transactional
	public Director addDirector(Director value) {
		Director result = null;
		try {
			result = dirRepo.save(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Director getDirector(Integer id) {
		Optional<Director> result = dirRepo.findById(id);
		return result.isEmpty() ? null: result.get();
	}

	@Override
	public List<Director> getDirector(String lastName) {
		return dirRepo.findByLastName(lastName);
	}
	
	@Override
	public void deleteDirector(Integer id) {
		dirRepo.deleteById(id);
	}

	@Override
	public Director updateDirector(Director value) {
		Optional<Director> result = dirRepo.findById(value.getId());
		if (!result.isEmpty()) {
			return dirRepo.save(value);
		} else {
			return null;
		}
	}

	@Override
	public List<Director> getAllDirectors() {
		return dirRepo.findAll();
	}

}
