package com.proyect.ptics.usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyect.ptics.usuario.rol.Rol;
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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String correo;
    @Column(nullable = false, length = 50)
    private String clave;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Rol rol;
}
