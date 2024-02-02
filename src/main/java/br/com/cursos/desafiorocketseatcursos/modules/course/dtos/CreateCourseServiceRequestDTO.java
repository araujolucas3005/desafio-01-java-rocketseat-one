package br.com.cursos.desafiorocketseatcursos.modules.course.dtos;

import lombok.Builder;

@Builder
public record CreateCourseServiceRequestDTO(
        String name,
        String category,
        Boolean isActive) {
}
