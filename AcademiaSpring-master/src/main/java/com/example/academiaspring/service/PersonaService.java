package com.example.academiaspring.service;

import com.example.academiaspring.interfaceService.IpersonaService;
import com.example.academiaspring.interfaces.IPersona;
import com.example.academiaspring.modelo.Persona;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Optional;
@Service
public class PersonaService implements IpersonaService{
    
    @Autowired
    private IPersona data;

    @Override
    public List<Persona> listar() {
        return(List<Persona>) data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return data.findAllById(id);
    }

    @Override
    public int save(Persona p) {
        int res=0;
        Persona persona = data.save(p);
        if(!persona.equals(null)){
            res=1;
        }
      return res;
    }

    @Override
    public void delete(int id) {

            data.deleteById(id);
     }

    public void editar(int id){

    }
}
