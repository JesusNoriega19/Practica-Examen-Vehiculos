import { Component, OnInit } from '@angular/core';
import { Vehiculo, VehiculoService } from 'src/app/services/vehiculo.service';

@Component({
  selector: 'app-vehiculos',
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css']
})
export class VehiculosComponent implements OnInit {
  vehiculos: Vehiculo[] = [];
  selectedVehiculo: Vehiculo | null = null;

  constructor(private vehiculoService: VehiculoService) {}

  ngOnInit(): void {
    this.cargarVehiculos();
  }

  // Cargar todos los vehículos
  cargarVehiculos(): void {
    this.vehiculoService.getVehiculos().subscribe((data) => {
      this.vehiculos = data;
    });
  }

  // Seleccionar un vehículo para editar
  seleccionarVehiculo(vehiculo: Vehiculo): void {
    this.selectedVehiculo = { ...vehiculo };
  }

  // Guardar un vehículo (nuevo o editado)
  guardarVehiculo(): void {
    if (this.selectedVehiculo) {
      if (this.selectedVehiculo.id) {
        this.vehiculoService
          .editarVehiculo(this.selectedVehiculo.id, this.selectedVehiculo)
          .subscribe(() => this.cargarVehiculos());
      } else {
        this.vehiculoService
          .insertarVehiculo(this.selectedVehiculo)
          .subscribe(() => this.cargarVehiculos());
      }
      this.selectedVehiculo = null;
    }
  }

  // Eliminar un vehículo
  eliminarVehiculo(id: number): void {
    this.vehiculoService.eliminarVehiculo(id).subscribe(() => this.cargarVehiculos());
  }

  // Crear un nuevo vehículo
  nuevoVehiculo(): void {
    this.selectedVehiculo = { id: 0, vin: '', placa: '', modelo: '', estatus: '' };
  }
}
