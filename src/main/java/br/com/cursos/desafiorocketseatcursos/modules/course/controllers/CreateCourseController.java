package br.com.cursos.desafiorocketseatcursos.modules.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.CreateCourseControllerRequestDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.CreateCourseControllerResponseDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.CreateCourseServiceRequestDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.services.CreateCourseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CreateCourseController {
  @Autowired
  private CreateCourseService createCourseService;

  @PostMapping("/")
  public ResponseEntity<CreateCourseControllerResponseDTO> create(
      @Valid @RequestBody CreateCourseControllerRequestDTO requestData) {
    var data = CreateCourseServiceRequestDTO.builder()
        .name(requestData.getName())
        .category(requestData.getCategory())
        .isActive(requestData.getIsActive())
        .build();

    var course = createCourseService.handle(data);

    var responseData = CreateCourseControllerResponseDTO.builder()
        .id(course.getId().toString())
        .name(course.getName())
        .category(course.getCategory())
        .isActive(course.getIsActive())
        .createdAt(course.getCreatedAt())
        .build();

    return ResponseEntity.ok(responseData);
  }

}
