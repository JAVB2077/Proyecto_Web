package com.proyect.ptics.unidadMedida;
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
@Table(name = "unidad-medida")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidadMedida;
    @Column(nullable = false, length = 45)
    private String descripcion;
    @OneToMany(mappedBy = "unidadMedida")
    private List<Actividad> actividad;
}
