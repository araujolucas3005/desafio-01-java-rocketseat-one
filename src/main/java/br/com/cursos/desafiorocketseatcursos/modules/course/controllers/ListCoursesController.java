package br.com.cursos.desafiorocketseatcursos.modules.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursos.desafiorocketseatcursos.modules.course.dtos.ListCoursesReponseDTO;
import br.com.cursos.desafiorocketseatcursos.modules.course.services.ListCoursesService;

@RestController
@RequestMapping("/courses")
public class ListCoursesController {
  @Autowired
  private ListCoursesService listCoursesService;

  @GetMapping("/")
  public ResponseEntity<List<ListCoursesReponseDTO>> list() {
    var courses = listCoursesService.handle()
        .stream()
        .map(course -> ListCoursesReponseDTO.builder()
            .id(course.getId().toString())
            .name(course.getName())
            .category(course.getCategory())
            .isActive(course.getIsActive())
            .createdAt(course.getCreatedAt())
            .updatedAt(course.getUpdatedAt())
            .build())
        .toList();

    return ResponseEntity.ok(courses);
  }

}
