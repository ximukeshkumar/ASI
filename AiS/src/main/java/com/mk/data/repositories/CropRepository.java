package com.mk.data.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mk.data.model.Crop;

public interface CropRepository extends CrudRepository<Crop, Integer>  
{  
	Optional<Crop> findByName(String name);
}
