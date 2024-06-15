package infnet.petshop.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal {


    private Integer id;

    private String nome;

    private Long idade;

    private String tipo;
}
