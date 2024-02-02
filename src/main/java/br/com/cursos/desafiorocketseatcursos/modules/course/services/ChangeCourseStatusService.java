package br.com.cursos.desafiorocketseatcursos.modules.course.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cursos.desafiorocketseatcursos.modules.course.exceptions.CourseNotFoundException;

@Service
public class ChangeCourseStatusService extends BaseCourseService {
  public void handle(String courseId, Boolean isActive) {
    var courseUUID = UUID.fromString(courseId);

    var course = super.coursesRepository
        .findById(courseUUID)
        .orElseThrow(() -> new CourseNotFoundException());

    course.setIsActive(isActive);

    super.coursesRepository.save(course);
  }
}
