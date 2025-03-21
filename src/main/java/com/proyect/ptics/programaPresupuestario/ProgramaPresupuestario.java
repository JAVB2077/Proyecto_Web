package com.proyect.ptics.programaPresupuestario;
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
@Table(name = "programa-presupuestario")
public class ProgramaPresupuestario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgramaPresupuestario;
    private int noActividades;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 45)
    private String firmas;
    @OneToMany(mappedBy = "programaPresupuestario")
    private List<Actividad> actividad;
}
