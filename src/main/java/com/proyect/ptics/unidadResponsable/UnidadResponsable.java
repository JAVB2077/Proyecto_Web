package com.proyect.ptics.unidadResponsable;
import com.proyect.ptics.actividad.Actividad;
import com.proyect.ptics.unidadResponsable.UnidadResponsable;
import com.proyect.ptics.unidadResponsable.jefesUnidad.JefesUnidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "unidad-responsable")

public class UnidadResponsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidadResponsable;
    @Column(nullable = false, length = 45)
    private String nombre;
    @OneToOne(mappedBy = "unidadResponsable",cascade = CascadeType.ALL)
    private JefesUnidad jefesUnidad;

    @OneToMany(mappedBy = "unidadResponsable")
    private List<Actividad> actividad;
}
