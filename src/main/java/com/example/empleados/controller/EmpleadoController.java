package com.example.empleados.controller;

import com.example.empleados.dto.*;
import com.example.empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/agregar")
    public EmpleadoResponse agregarEmpleado(@RequestBody EmpleadoRequest request) {
        return empleadoService.agregarEmpleado(request);
    }

    @GetMapping("/consultarPorPuesto")
    public ConsultaEmpleadosResponse consultarEmpleadosPorPuesto(@RequestParam Long jobId) {
        return empleadoService.consultarEmpleadosPorPuesto(jobId);
    }
    
    @GetMapping("/saludo")
    public String saludo() {
        return "Hola mundo";
    }
    
    
}