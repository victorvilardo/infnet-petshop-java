package infnet.petshop.com.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import infnet.petshop.com.model.Cachorro;
import infnet.petshop.com.model.Gato;
import infnet.petshop.com.model.Vendedor;
import infnet.petshop.com.service.CachorroService;
import infnet.petshop.com.service.GatoService;
import infnet.petshop.com.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private CachorroService cachorroService;
    @Autowired
    private GatoService gatoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/vendedores.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        Vendedor vendedor = null;

        System.err.println("#vendedor");
        while(linha != null) {

            campos = linha.split(";");

            switch (campos[0].toUpperCase()) {

                case "V":
                    vendedor = new Vendedor();
                    vendedor.setNome(campos[1]);
                    vendedor.setCpf(campos[2]);
                    vendedor.setMatricula(campos[3]);

                    vendedorService.incluir(vendedor);
                    break;

                case "G":
                    Gato gato = new Gato();
                    gato.setNome(campos[1]);
                    gato.setCor(campos[2]);
                    gato.setTipoPelagem(campos[3]);
                    gato.setTipo(campos[4]);
                    gato.setIdade(Long.valueOf(campos[5]));

                    gato.setVendedor(vendedor);

                    gatoService.incluir(gato);

                    vendedor.getVendas().add(gato);

                    break;

                case "C":
                    Cachorro cachorro = new Cachorro();
                    cachorro.setNome(campos[1]);
                    cachorro.setRaca(campos[2]);
                    cachorro.setAdestrado(Boolean.parseBoolean(campos[3]));
                    cachorro.setIdade(Long.valueOf(campos[4]));
                    cachorro.setPorte(campos[5]);

                    cachorro.setVendedor(vendedor);

                    cachorroService.incluir(cachorro);

                    vendedor.getVendas().add(cachorro);

                    break;

                default:
                    System.err.println("Linha: " + Arrays.asList(campos));
                    break;
            }

            linha = leitura.readLine();
        }

        System.out.println("Iniciando o processamento..............");
        for(Vendedor oVendedor : vendedorService.obterLista()) {
            System.out.println(oVendedor);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
}