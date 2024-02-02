package br.com.cursos.desafiorocketseatcursos.modules.course.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangeCourseStatusControllerRequestDTO {
  @NotNull
  private Boolean isActive;
}
