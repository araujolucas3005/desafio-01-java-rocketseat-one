package br.com.cursos.desafiorocketseatcursos.modules.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.UpdateCourseControllerRequestDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.UpdateCourseServiceRequestDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.services.UpdateCourseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class UpdateCourseController {
  @Autowired
  private UpdateCourseService updateCourseService;

  @PutMapping("/{id}")
  public ResponseEntity<Void> list(@PathVariable String id,
      @Valid @RequestBody UpdateCourseControllerRequestDTO data) {
    var requestData = UpdateCourseServiceRequestDTO.builder()
        .name(data.getName())
        .category(data.getCategory())
        .build();

    updateCourseService.handle(id, requestData);

    return ResponseEntity.noContent().build();
  }

}
