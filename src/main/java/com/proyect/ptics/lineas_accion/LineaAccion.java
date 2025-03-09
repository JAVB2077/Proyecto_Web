package com.proyect.ptics.lineas_accion;
import com.proyect.ptics.actividad.Actividad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "linea_accion")
public class LineaAccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinea_Accion;

    @Column(nullable = false, length = 150)
    private String descropciom;

    @OneToOne(mappedBy = "linea_accion",cascade = CascadeType.ALL)
    private Actividad actividad;
}
