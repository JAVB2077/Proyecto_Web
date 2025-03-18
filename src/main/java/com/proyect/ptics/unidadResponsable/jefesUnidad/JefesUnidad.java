package com.proyect.ptics.unidadResponsable.jefesUnidad;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyect.ptics.unidadResponsable.UnidadResponsable;
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
@Table(name = "jefes-unidad")
public class JefesUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJefesUnidad;
    @Column(nullable = false, length = 45)
    private String nombre;
    @OneToOne
    @JoinColumn(name = "idUnidadResponsable")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UnidadResponsable unidadResponsable;
}
