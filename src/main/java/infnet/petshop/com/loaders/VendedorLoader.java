package infnet.petshop.com.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import infnet.petshop.com.model.Vendedor;
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


    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/vendedores.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#vendedor");
        while(linha != null) {

            campos = linha.split(";");
            Vendedor vendedor = new Vendedor();
            vendedor.setCpf(campos[0]);
            vendedor.setNome(campos[1]);
            vendedor.setMatricula(campos[2]);

            vendedorService.incluir(vendedor);

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