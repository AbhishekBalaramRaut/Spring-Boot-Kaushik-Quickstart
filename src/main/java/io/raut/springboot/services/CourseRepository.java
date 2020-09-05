package io.raut.springboot.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.raut.springboot.models.Course;
import io.raut.springboot.models.Topic;

public interface CourseRepository extends CrudRepository<Course, String>{

	public List<Course> findByTopicId(String id);
}
