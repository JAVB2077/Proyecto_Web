package com.proyect.ptics.medioVerificacion;
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
@Table(name = "medio-verificacion")
public class MedioVerificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedioVerificacion;
    @Column(nullable = false, length = 50)
    private String descripcion;
    @OneToMany(mappedBy = "medioVerificacion")
    private List<Actividad> actividad;
}
