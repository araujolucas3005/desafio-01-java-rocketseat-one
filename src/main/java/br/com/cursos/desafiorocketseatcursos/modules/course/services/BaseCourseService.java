package br.com.cursos.desafiorocketseatcursos.modules.course.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cursos.desafiorocketseatcursos.modules.course.repositories.CoursesRepository;

public class BaseCourseService {

  @Autowired
  protected CoursesRepository coursesRepository;

}
