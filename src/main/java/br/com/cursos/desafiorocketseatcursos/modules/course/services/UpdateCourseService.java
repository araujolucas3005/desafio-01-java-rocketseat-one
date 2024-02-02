package br.com.cursos.desafiorocketseatcursos.modules.course.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.UpdateCourseServiceRequestDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.exceptions.CourseNotFoundException;

@Service
public class UpdateCourseService extends BaseCourseService {
  public void handle(String courseId, UpdateCourseServiceRequestDTO data) {
    var courseUUID = UUID.fromString(courseId);

    var course = super.coursesRepository
        .findById(courseUUID)
        .orElseThrow(() -> new CourseNotFoundException());

    course.setName(data.name());
    course.setCategory(data.category());

    super.coursesRepository.save(course);
  }
}
