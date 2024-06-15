package infnet.petshop.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

    private Integer id;

    private String nome;

    private String cpf;

    private String matricula;


    @Override
    public String toString() {
        return String.format("%d - %s - %s - %s",
                id,
                nome,
                cpf,
                matricula
        );
    }

}
