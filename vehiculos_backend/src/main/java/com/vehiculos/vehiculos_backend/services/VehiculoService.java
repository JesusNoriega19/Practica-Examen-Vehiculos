package com.vehiculos.vehiculos_backend.services;

import com.vehiculos.vehiculos_backend.models.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insertar un vehículo
    public void insertarVehiculo(String vin, String placa, String modelo, String estatus) {
        String sql = "{CALL insertar_vehiculo(?, ?, ?, ?)}";
        jdbcTemplate.update(sql, vin, placa, modelo, estatus);
    }

    // Editar un vehículo
    public void editarVehiculo(int id, String vin, String placa, String modelo, String estatus) {
        String sql = "{CALL editar_vehiculo(?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, id, vin, placa, modelo, estatus);
    }

    // Consultar un vehículo
    public Vehiculo consultarVehiculo(int id) {
        String sql = "{CALL consultar_vehiculo(?)}";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (rs, rowNum) -> {
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setId(rs.getInt("ID"));
                    vehiculo.setVin(rs.getString("VIN"));
                    vehiculo.setPlaca(rs.getString("placa"));
                    vehiculo.setModelo(rs.getString("modelo"));
                    vehiculo.setEstatus(rs.getString("estatus"));
                    return vehiculo;
                });
    }


    // Consultar todos los vehículos
    public List<Vehiculo> consultarVehiculos() {
        String sql = "{CALL consultar_vehiculos()}";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setId(rs.getInt("ID"));
                    vehiculo.setVin(rs.getString("VIN"));
                    vehiculo.setPlaca(rs.getString("placa"));
                    vehiculo.setModelo(rs.getString("modelo"));
                    vehiculo.setEstatus(rs.getString("estatus"));
                    return vehiculo;
                }
        );
    }


    // Eliminar un vehículo
    public void eliminarVehiculo(int id) {
        String sql = "{CALL eliminar_vehiculo(?)}";
        jdbcTemplate.update(sql, id);
    }

}
