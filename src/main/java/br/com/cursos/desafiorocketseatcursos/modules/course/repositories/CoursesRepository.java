package br.com.cursos.desafiorocketseatcursos.modules.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursos.desafiorocketseatcursos.modules.course.entities.CourseEntity;

public interface CoursesRepository extends JpaRepository<CourseEntity, UUID> {

}
