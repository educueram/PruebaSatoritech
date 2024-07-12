package com.example.empleados.service;

import com.example.empleados.dto.*;
import com.example.empleados.model.*;
import com.example.empleados.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private PuestoRepository puestoRepository;
    
    @Autowired
    private GeneroRepository generoRepository;

    public EmpleadoResponse agregarEmpleado(EmpleadoRequest request) {
        EmpleadoResponse response = new EmpleadoResponse();
        
        // Validaciones
        if (empleadoRepository.findByNameAndLastName(request.getName(), request.getLast_name()).isPresent()) {
            response.setSuccess(false);
            return response;
        }
        
        if (Period.between(request.getBirthdate(), LocalDate.now()).getYears() < 18) {
            response.setSuccess(false);
            return response;
        }

        Optional<Puesto> puestoOpt = puestoRepository.findById(request.getJob_id());
        if (puestoOpt.isEmpty()) {
            response.setSuccess(false);
            return response;
        }

        Optional<Genero> generoOpt = generoRepository.findById(request.getGender_id());
        if (generoOpt.isEmpty()) {
            response.setSuccess(false);
            return response;
        }
        
        // Creación del empleado
        Empleado empleado = new Empleado();
        empleado.setName(request.getName());
        empleado.setLast_name(request.getLast_name());
        empleado.setBirthdate(request.getBirthdate());
        empleado.setJob(puestoOpt.get());
        empleado.setGender(generoOpt.get());
        
        empleadoRepository.save(empleado);
        response.setId(empleado.getId());
        response.setSuccess(true);
        
        return response;
    }

    public ConsultaEmpleadosResponse consultarEmpleadosPorPuesto(Long jobId) {
        ConsultaEmpleadosResponse response = new ConsultaEmpleadosResponse();
        
        Optional<Puesto> puestoOpt = puestoRepository.findById(jobId);
        if (puestoOpt.isEmpty()) {
            response.setSuccess(false);
            return response;
        }

        List<EmpleadoDTO> empleados = empleadoRepository.findAll().stream()
            .filter(e -> e.getJob().getId().equals(jobId))
            .map(e -> {
                EmpleadoDTO dto = new EmpleadoDTO();
                dto.setId(e.getId());
                dto.setName(e.getName());
                dto.setLast_name(e.getLast_name());
                dto.setBirthdate(e.getBirthdate());
                
                PuestoDTO puestoDTO = new PuestoDTO();
                puestoDTO.setId(e.getJob().getId());
                puestoDTO.setName(e.getJob().getName());
                puestoDTO.setSalary(e.getJob().getSalary());
                dto.setJob(puestoDTO);
                
                GeneroDTO generoDTO = new GeneroDTO();
                generoDTO.setId(e.getGender().getId());
                generoDTO.setName(e.getGender().getName());
                dto.setGender(generoDTO);
                
                return dto;
            }).collect(Collectors.toList());

        response.setEmployees(empleados);
        response.setSuccess(true);
        
        return response;
    }
}