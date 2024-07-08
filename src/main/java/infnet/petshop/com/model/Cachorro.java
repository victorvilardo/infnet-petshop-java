package infnet.petshop.com.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TCachorro")
public class Cachorro extends Animal{

    @Size(min = 3, max = 20, message = "O porte do cachorro deve ter entre {min} e {max} caracteres.")
    @Column(name = "dsporte")
    private String porte;

    @Column(name = "adestrado")
    private boolean adestrado;

    @Column(name = "raca")
    private String raca;
}
