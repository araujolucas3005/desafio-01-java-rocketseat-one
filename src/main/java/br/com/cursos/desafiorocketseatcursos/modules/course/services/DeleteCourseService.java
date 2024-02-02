package br.com.cursos.desafiorocketseatcursos.modules.course.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cursos.desafiorocketseatcursos.modules.course.exceptions.CourseNotFoundException;

@Service
public class DeleteCourseService extends BaseCourseService {
  public void handle(String courseId) {
    var courseUUID = UUID.fromString(courseId);

    super.coursesRepository
        .findById(courseUUID)
        .orElseThrow(() -> new CourseNotFoundException());

    super.coursesRepository.deleteById(courseUUID);
  }
}
