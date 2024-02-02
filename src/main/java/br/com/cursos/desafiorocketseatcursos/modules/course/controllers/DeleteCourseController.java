package br.com.cursos.desafiorocketseatcursos.modules.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursos.desafiorocketseatcursos.modules.course.services.DeleteCourseService;

@RestController
@RequestMapping("/courses")
public class DeleteCourseController {
  @Autowired
  private DeleteCourseService deleteCourseService;

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> list(@PathVariable String id) {
    deleteCourseService.handle(id);

    return ResponseEntity.noContent().build();
  }

}
