package io.raut.springboot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.raut.springboot.models.Course;
import io.raut.springboot.models.Topic;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCoursesByTopic(String topicId) {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		Optional<Course> opt = courseRepository.findById(id);
		return opt.orElse(new Course());
		
	}

	
	public void createCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
		
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
