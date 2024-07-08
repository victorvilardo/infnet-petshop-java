package infnet.petshop.com.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TGato")
public class Gato extends Animal {

    private String cor;

    private String tipoPelagem;


}
