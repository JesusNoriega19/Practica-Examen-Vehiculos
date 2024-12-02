package com.vehiculos.vehiculos_backend.controllers;

import com.vehiculos.vehiculos_backend.models.Vehiculo;
import com.vehiculos.vehiculos_backend.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    // Endpoint para insertar un vehículo
    @PostMapping("/insertar")
    public void insertarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.insertarVehiculo(vehiculo.getVin(), vehiculo.getPlaca(), vehiculo.getModelo(), vehiculo.getEstatus());
    }

    // Endpoint para editar un vehículo
    @PutMapping("/editar/{id}")
    public void editarVehiculo(@PathVariable int id, @RequestBody Vehiculo vehiculo) {
        vehiculoService.editarVehiculo(id, vehiculo.getVin(), vehiculo.getPlaca(), vehiculo.getModelo(), vehiculo.getEstatus());
    }

    // Endpoint para consultar un vehículo
    @GetMapping("/consultar/{id}")
    public Vehiculo consultarVehiculo(@PathVariable int id) {
        return vehiculoService.consultarVehiculo(id);
    }

    // Endpoint para consultar todos los vehículos
    @GetMapping("/consultar")
    public List<Vehiculo> consultarVehiculos() {
        return vehiculoService.consultarVehiculos();
    }

    // CEndpoint para eliminar un vehículo
    @DeleteMapping("/eliminar/{id}")
    public void eliminarVehiculo(@PathVariable int id) {
        vehiculoService.eliminarVehiculo(id);
    }

}
