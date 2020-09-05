package io.raut.springboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.raut.springboot.models.Course;
import io.raut.springboot.models.Topic;
import io.raut.springboot.services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllcourses(@PathVariable String id) {
		return courseService.getAllCoursesByTopic(id);
	}
	
	@RequestMapping("/topics/{id}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{id}/courses")
	public void createCourse(@PathVariable String id,@RequestBody Course course) {
		course.setTopic(new Topic(id,"",""));
		courseService.createCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}/courses/{courseId}")
	public void updateCourse(@PathVariable String id , @PathVariable String courseId , @RequestBody Course course) {
	 course.setTopic(new Topic(id,"",""));
	 courseService.updateCourse(courseId,course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
	 courseService.deleteCourse(courseId);
	}
}
