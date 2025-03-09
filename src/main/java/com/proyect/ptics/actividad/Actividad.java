package com.proyect.ptics.actividad;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyect.ptics.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.proyect.ptics.lineas_accion.LineaAccion;
import com.proyect.ptics.unidad_responsable.UnidadResponsable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String estrategia;

    @OneToOne
    @JoinColumn(name = "idLinea_Accion")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LineaAccion linea_accion;

    @Column(nullable = false, length = 10)
    private String medioVerificacion;

    @OneToOne
    @JoinColumn(name = "idUnidad_responsable")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UnidadResponsable unidad_responsable;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    @Column(nullable = false, length = 20)
    private String fecha_inicio;

    @Column(nullable = false, length = 20)
    private String fecha_fin;
}
