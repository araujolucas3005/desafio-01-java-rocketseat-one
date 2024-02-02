package br.com.cursos.desafiorocketseatcursos.modules.course.services;

import org.springframework.stereotype.Service;

import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.CreateCourseServiceRequestDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.entities.CourseEntity;

@Service
public class CreateCourseService extends BaseCourseService {
  public CourseEntity handle(CreateCourseServiceRequestDTO data) {
    var course = CourseEntity.builder()
        .name(data.name())
        .category(data.category())
        .isActive(data.isActive())
        .build();

    var savedCourse = super.coursesRepository.save(course);

    return savedCourse;
  }
}
