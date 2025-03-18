package com.proyect.ptics.estrategias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyect.ptics.actividad.Actividad;
import com.proyect.ptics.estrategias.objetivos.Objetivos;
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
@Table(name = "estrategias")
public class Estrategias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstrategias;

    @Column(nullable = false, length = 50)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idObjetivos")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Objetivos objetivos;

    @OneToMany(mappedBy = "estrategias", cascade = CascadeType.ALL)
    private List<Actividad> actividad = new ArrayList<>();
}
