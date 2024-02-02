package br.com.cursos.desafiorocketseatcursos.modules.course.dtos;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ListCoursesReponseDTO(
        String id,
        String name,
        String category,
        Boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
