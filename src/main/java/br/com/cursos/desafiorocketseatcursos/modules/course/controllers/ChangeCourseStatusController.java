package br.com.cursos.desafiorocketseatcursos.modules.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.ChangeCourseStatusControllerRequestDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.services.ChangeCourseStatusService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class ChangeCourseStatusController {
  @Autowired
  private ChangeCourseStatusService changeCourseStatusService;

  @PatchMapping("/{id}/active")
  public ResponseEntity<Void> list(@PathVariable String id,
      @Valid @RequestBody ChangeCourseStatusControllerRequestDTO data) {
    changeCourseStatusService.handle(id, data.getIsActive());

    return ResponseEntity.noContent().build();
  }

}
