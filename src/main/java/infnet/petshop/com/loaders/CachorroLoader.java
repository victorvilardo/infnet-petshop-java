package infnet.petshop.com.loaders;

import infnet.petshop.com.model.Cachorro;

import java.io.BufferedReader;
import java.io.FileReader;

import infnet.petshop.com.model.Vendedor;
import infnet.petshop.com.service.CachorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class CachorroLoader implements ApplicationRunner{

    @Autowired
    private CachorroService cachorroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/cachorros.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#cachorros");
        while(linha != null) {

            campos = linha.split(";");

            Cachorro cachorro = new Cachorro();
            cachorro.setNome(campos[0]);
            cachorro.setRaca(campos[1]);
            cachorro.setAdestrado(Boolean.parseBoolean(campos[2]));
            cachorro.setIdade(Long.valueOf(campos[3]));
            cachorro.setTipo(campos[4]);
            cachorro.setPorte(campos[5]);
            cachorro.setVendedor(new Vendedor(Integer.valueOf(campos[6])));

            cachorroService.incluir(cachorro);

            linha = leitura.readLine();
        }

        System.out.println("Iniciando o processamento!");
        for(Cachorro cachorro : cachorroService.obterLista()) {
            System.out.println(cachorro);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
}

