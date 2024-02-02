package br.com.cursos.desafiorocketseatcursos.modules.course.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCourseControllerRequestDTO {
  @NotBlank()
  @Length(min = 2)
  String name;

  @NotBlank()
  @Length(min = 2)
  String category;
}
