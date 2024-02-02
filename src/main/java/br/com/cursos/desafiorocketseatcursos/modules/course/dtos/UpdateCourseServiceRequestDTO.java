package br.com.cursos.desafiorocketseatcursos.modules.course.dtos;

import lombok.Builder;

@Builder
public record UpdateCourseServiceRequestDTO(String name, String category) {
}
