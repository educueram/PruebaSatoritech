package com.example.empleados.service;

import com.example.empleados.dto.*;
import com.example.empleados.model.*;
import com.example.empleados.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class HorasTrabajadasService {
    @Autowired
    private HorasTrabajadasRepository horasTrabajadasRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public HorasTrabajadasResponse agregarHorasTrabajadas(HorasTrabajadasRequest request) {
        HorasTrabajadasResponse response = new HorasTrabajadasResponse();
        
        // Validaciones
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(request.getEmployee_id());
        if (empleadoOpt.isEmpty()) {
            response.setSuccess(false);
            return response;
        }

        if (request.getWorked_hours() > 20) {
            response.setSuccess(false);
            return response;
        }

        if (request.getWorked_date().isAfter(LocalDate.now())) {
            response.setSuccess(false);
            return response;
        }

        if (horasTrabajadasRepository.findByEmployeeIdAndWorkedDate(request.getEmployee_id(), request.getWorked_date()).isPresent()) {
            response.setSuccess(false);
            return response;
        }
        
        // Creación del registro de horas trabajadas
        HorasTrabajadas horasTrabajadas = new HorasTrabajadas();
        horasTrabajadas.setEmployee(empleadoOpt.get());
        horasTrabajadas.setWorked_hours(request.getWorked_hours());
        horasTrabajadas.setWorked_date(request.getWorked_date());
        
        horasTrabajadasRepository.save(horasTrabajadas);
        response.setId(horasTrabajadas.getId());
        response.setSuccess(true);
        
        return response;
    }

    public ConsultaHorasTrabajadasResponse consultarHorasTrabajadas(ConsultaHorasTrabajadasRequest request) {
        ConsultaHorasTrabajadasResponse response = new ConsultaHorasTrabajadasResponse();
        
        // Validaciones
        if (!empleadoRepository.existsById(request.getEmployee_id())) {
            response.setSuccess(false);
            return response;
        }

        if (request.getStart_date().isAfter(request.getEnd_date())) {
            response.setSuccess(false);
            return response;
        }

        // Consulta de horas trabajadas
        int totalHoras = horasTrabajadasRepository.findByEmployeeIdAndWorkedDateBetween(request.getEmployee_id(), request.getStart_date(), request.getEnd_date())
                .stream().mapToInt(HorasTrabajadas::getWorked_hours).sum();
        
        response.setTotal_worked_hours(totalHoras);
        response.setSuccess(true);
        
        return response;
    }

    public ConsultaPagoResponse consultarPago(ConsultaPagoRequest request) {
        ConsultaPagoResponse response = new ConsultaPagoResponse();
        
        // Validaciones
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(request.getEmployee_id());
        if (empleadoOpt.isEmpty()) {
            response.setSuccess(false);
            return response;
        }

        if (request.getStart_date().isAfter(request.getEnd_date())) {
            response.setSuccess(false);
            return response;
        }

        // Cálculo del pago
        int totalHoras = horasTrabajadasRepository.findByEmployeeIdAndWorkedDateBetween(request.getEmployee_id(), request.getStart_date(), request.getEnd_date())
                .stream().mapToInt(HorasTrabajadas::getWorked_hours).sum();
        
        int salario = empleadoOpt.get().getJob().getSalary();
        int pago = totalHoras * salario;

        response.setPayment(pago);
        response.setSuccess(true);
        
        return response;
    }
}