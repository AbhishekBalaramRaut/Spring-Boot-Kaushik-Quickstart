package io.raut.springboot.services;

import org.springframework.data.repository.CrudRepository;

import io.raut.springboot.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

	
}
