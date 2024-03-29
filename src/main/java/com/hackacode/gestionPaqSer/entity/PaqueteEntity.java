package com.hackacode.gestionPaqSer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paquete")
public class PaqueteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paquete")
    private Integer idPaquete;

    @ManyToMany
    @JoinTable(
            name = "detallepaqueteservicio",
            joinColumns = @JoinColumn(name = "id_paquete"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private Set<ServicioEntity> listaServicios = new HashSet<>();

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

}
