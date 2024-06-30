package infnet.petshot.com.ApiVilardo.model;

public class Municipio {

    private Integer id;
    private String nome;

    @Override
    public String toString() {
        return String.format("%d - %s", id, nome);
    }
}
