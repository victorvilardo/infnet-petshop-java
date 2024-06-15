package infnet.petshop.com.loaders;

import infnet.petshop.com.model.Animal;
import infnet.petshop.com.model.Cachorro;
import infnet.petshop.com.model.Gato;
import infnet.petshop.com.service.AnimalService;
import infnet.petshop.com.service.CachorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class AnimalLoader  implements ApplicationRunner{

    @Autowired
    private AnimalService animalService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/animais.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#animais");
        while(linha != null) {


            campos = linha.split(";");

            switch (campos[0].toUpperCase()) {
                case "C":
                    Cachorro cachorro = new Cachorro();
                    cachorro.setNome(campos[0]);
                    cachorro.setRaca(campos[1]);
                    cachorro.setAdestrado(Boolean.parseBoolean(campos[2]));
                    cachorro.setIdade(Long.valueOf(campos[3]));
                    cachorro.setPorte(campos[4]);


                    animalService.incluir(cachorro);
                    break;

                case "G":
                    Gato gato = new Gato();
                    gato.setNome(campos[0]);
                    gato.setCor(campos[1]);
                    gato.setTipoPelagem(campos[2]);
                    gato.setTipo(campos[3]);
                    gato.setIdade(Long.valueOf(campos[4]));


                    animalService.incluir(gato);
                    break;

                default:
                    System.err.println("Tipo inválido!!!");
            }
        }

        System.out.println("Iniciando o processamento!");
        for(Animal animal : animalService.obterLista()) {
            System.out.println(animal);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
}