package infnet.petshop.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cachorro extends Animal{

    private String porte;

    private boolean adestrado;

    private String raca;
}
