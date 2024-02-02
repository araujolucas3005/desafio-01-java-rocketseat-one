package br.com.cursos.desafiorocketseatcursos.modules.course.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCourseControllerRequestDTO {
  @NotBlank()
  @Length(min = 2, max = 100)
  String name;

  @NotBlank()
  @Length(min = 2)
  String category;

  @NotNull()
  Boolean isActive;
}
