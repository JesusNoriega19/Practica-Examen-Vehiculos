import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Vehiculo {
  id: number;
  vin: string;
  placa: string;
  modelo: string;
  estatus: string;
}

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {
  private apiUrl = 'http://localhost:8080/api/vehiculos'; // Ajustar al puerto del backend

  constructor(private http: HttpClient) {}

  // Obtener todos los vehículos
  getVehiculos(): Observable<Vehiculo[]> {
    return this.http.get<Vehiculo[]>(`${this.apiUrl}/consultar`);
  }

  // Obtener un vehículo por ID
  getVehiculo(id: number): Observable<Vehiculo> {
    return this.http.get<Vehiculo>(`${this.apiUrl}/consultar/${id}`);
  }

  // Insertar un nuevo vehículo
  insertarVehiculo(vehiculo: Vehiculo): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/insertar`, vehiculo);
  }

  // Editar un vehículo
  editarVehiculo(id: number, vehiculo: Vehiculo): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/editar/${id}`, vehiculo);
  }

  // Eliminar un vehículo
  eliminarVehiculo(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/eliminar/${id}`);
  }
}
