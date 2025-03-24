package com.proyect.ptics.calendarizacion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyect.ptics.actividad.Actividad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "calendarizacion")
public class Calendarizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalendarizacion;
    @Column(nullable = false, length = 15)
    private byte mes;
    private int cantidadMensual;
    private Float presupuesto;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)//
    @JoinColumn(name = "idActividad")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Actividad actividad;
}
