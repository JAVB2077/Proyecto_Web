package com.proyect.ptics.calendarizacion;
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
    private int mes;
    private int cantidadAnual;//pasarlo a la clase actividad
    private int cantidadMensual;
    private Float presupuesto;

    @OneToMany(mappedBy = "calendarizacion")//hacerlo many to one
    private List<Actividad> actividad;
}
