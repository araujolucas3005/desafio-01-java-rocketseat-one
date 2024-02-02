package br.com.cursos.desafiorocketseatcursos.modules.course.exceptions;

public class CourseNotFoundException extends EntityNotFoundException {
  public CourseNotFoundException() {
    super("Course");
  }

}
