package infnet.petshop.com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TAnimal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Long idade;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idVendedor")
    @JsonBackReference
    private Vendedor vendedor;
}
