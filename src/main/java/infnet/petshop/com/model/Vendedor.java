package infnet.petshop.com.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "TVendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "É necessário preencher o campo NOME!")
    @Size(min = 3, max = 100, message = "O nome do vendedor deve ter entre {min} e {max} caracteres.")
    private String nome;

    @NotBlank(message = "É necessário preencher o campo CPF!")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "É necessário preencher a matricula!")
    @Column(unique = true)
    private String matricula;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idVendedor")
    @JsonManagedReference
    private List<Animal> vendas;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    public Vendedor() {
        this.vendas = new ArrayList<Animal>();
    }

    public Vendedor(Integer id) {
        this();
        this.setId(id);
    }
    @Override
    public String toString() {
        return String.format("%d - %s - %s - %s - %d  - Endereço: %s",
                id,
                nome,
                cpf,
                matricula,
                vendas.size(),
                endereco

        );
    }



}
