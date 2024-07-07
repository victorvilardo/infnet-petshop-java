package infnet.petshop.com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Municipio {

    private Integer id;
    private String nome;

    @Override
    public String toString() {
        return String.format("%d - %s", id, nome);
    }
}
