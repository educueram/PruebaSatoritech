package com.example.empleados.controller;

import com.example.empleados.dto.*;
import com.example.empleados.service.HorasTrabajadasService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horas")
public class HorasTrabajadasController {
    @Autowired
    private HorasTrabajadasService horasTrabajadasService;

    @PostMapping("/agregar")
    public HorasTrabajadasResponse agregarHorasTrabajadas(@RequestBody HorasTrabajadasRequest request) {
        return horasTrabajadasService.agregarHorasTrabajadas(request);
    }

    @GetMapping("/consultarHoras")
    public ConsultaHorasTrabajadasResponse consultarHorasTrabajadas(@RequestParam Long employeeId,
                                                                     @RequestParam String startDate,
                                                                     @RequestParam String endDate) {
        ConsultaHorasTrabajadasRequest request = new ConsultaHorasTrabajadasRequest();
        request.setEmployee_id(employeeId);
        request.setStart_date(LocalDate.parse(startDate));
        request.setEnd_date(LocalDate.parse(endDate));
        return horasTrabajadasService.consultarHorasTrabajadas(request);
    }

    @GetMapping("/consultarPago")
    public ConsultaPagoResponse consultarPago(@RequestParam Long employeeId,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate) {
        ConsultaPagoRequest request = new ConsultaPagoRequest();
        request.setEmployee_id(employeeId);
        request.setStart_date(LocalDate.parse(startDate));
        request.setEnd_date(LocalDate.parse(endDate));
        return horasTrabajadasService.consultarPago(request);
    }
}