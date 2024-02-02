package br.com.cursos.desafiorocketseatcursos.modules.course.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cursos.desafiorocketseatcursos.modules.course.entities.CourseEntity;

@Service
public class ListCoursesService extends BaseCourseService {
  public List<CourseEntity> handle() {
    var courses = super.coursesRepository.findAll();

    return courses;
  }
}
