package br.com.cursos.desafiorocketseatcursos.lib;

import lombok.Builder;

@Builder
public record ExceptionResponseDTO(String message, String field) {
}