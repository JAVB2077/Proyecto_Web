package com.proyect.ptics.actividad;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyect.ptics.calendarizacion.Calendarizacion;
import com.proyect.ptics.estrategias.Estrategias;
import com.proyect.ptics.indicadorResultado.IndicadorResultado;
import com.proyect.ptics.medioVerificacion.MedioVerificacion;
import com.proyect.ptics.programaPresupuestario.ProgramaPresupuestario;
import com.proyect.ptics.unidadMedida.UnidadMedida;
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
@Table(name = "actividad")
public class Actividad { //descripcion, medios de verificacion, indicador de resultados, cantidad anual
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;
    @Column(nullable = false, length = 100)
    private String descripcion;
    private int cantidadAnual;//pasarlo a la clase actividad

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEstrategias")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Estrategias estrategias;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idUnidadResponsable")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UnidadResponsable unidadResponsable;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idIndicadorResultado")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private IndicadorResultado indicadorResultado;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idUnidadMedida")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UnidadMedida unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idMedioVerificacion")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MedioVerificacion medioVerificacion;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idProgramaPresupuestario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ProgramaPresupuestario programaPresupuestario;

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private List<Calendarizacion> calendarizacion = new ArrayList<Calendarizacion>();
}
