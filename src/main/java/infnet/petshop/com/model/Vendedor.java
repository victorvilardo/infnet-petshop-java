package infnet.petshop.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Vendedor {

    private Integer id;

    private String nome;

    private String cpf;

    private String matricula;

    private List<Animal> vendas;

    public Vendedor() {
        this.vendas = new ArrayList<Animal>();
    }
    @Override
    public String toString() {
        return String.format("%d - %s - %s - %s - %d",
                id,
                nome,
                cpf,
                matricula,
                vendas.size()

        );
    }

}
