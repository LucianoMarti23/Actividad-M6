package com.example.academiaspring.interfaces;

import com.example.academiaspring.modelo.Persona;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer> {

    public Optional<Persona> findAllById(int id);

    public Optional <Persona> findById(int id);
}
