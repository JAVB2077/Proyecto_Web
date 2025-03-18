package com.proyect.ptics.estrategias.objetivos;

import com.proyect.ptics.estrategias.Estrategias;
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
@Table(name = "objetivos")
public class Objetivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjetivos;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "objetivos", cascade = CascadeType.ALL)
    private List<Estrategias> estrategias = new ArrayList<>();

}
