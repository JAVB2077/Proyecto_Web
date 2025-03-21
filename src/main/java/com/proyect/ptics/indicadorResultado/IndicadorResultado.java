package com.proyect.ptics.indicadorResultado;
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
@Table(name = "indicador-resultado")
public class IndicadorResultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIndicadorResultado;
    @Column(nullable = false, length = 45)
    private String descripcion;
    @OneToMany(mappedBy = "indicadorResultado")
    private List<Actividad> actividad;
}
