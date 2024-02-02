package br.com.cursos.desafiorocketseatcursos.modules.course.exceptions;

public abstract class EntityNotFoundException extends RuntimeException {
  EntityNotFoundException(String resource) {
    super(String.format("%s not found", resource));
  }
}
