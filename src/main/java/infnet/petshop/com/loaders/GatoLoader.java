package infnet.petshop.com.loaders;

import infnet.petshop.com.model.Gato;
import infnet.petshop.com.model.Vendedor;
import infnet.petshop.com.service.GatoService;
import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class GatoLoader  implements ApplicationRunner {

    @Autowired
    private GatoService gatoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/gatos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#gatos");
        while(linha != null) {

            campos = linha.split(";");

            Gato gato = new Gato();
            gato.setNome(campos[0]);
            gato.setCor(campos[1]);
            gato.setTipoPelagem(campos[2]);
            gato.setTipo(campos[3]);
            gato.setIdade(Long.valueOf(campos[4]));
            gato.setVendedor(new Vendedor(Integer.valueOf(campos[5])));


            gatoService.incluir(gato);

            linha = leitura.readLine();
        }

        System.out.println("Iniciando o processamento!");
        for(Gato gato : gatoService.obterLista()) {
            System.out.println(gato);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
}
