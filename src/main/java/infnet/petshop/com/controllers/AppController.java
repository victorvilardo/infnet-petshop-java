package infnet.petshop.com.controllers;

import infnet.petshop.com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AppController {

    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private GatoService gatoService;
    @Autowired
    private CachorroService cachorroService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/")
    public String telaHome(Model model){

        model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
        model.addAttribute("qtdeAnimal", animalService.obterQtde());
        model.addAttribute("qtdeGato", gatoService.obterQtde());
        model.addAttribute("qtdeCachorro", cachorroService.obterQtde());
        model.addAttribute("qtdeEndereco", enderecoService.obterQtde());
        model.addAttribute("estados", apiService.obterEstados());

        return "home";
    }

    @GetMapping(value = "/estado/listagem")
    public String listaEstados(Model model){

        model.addAttribute("titulo", "Listagem de Estados");
        model.addAttribute("listagem", apiService.obterEstados());

        return telaHome(model);
    }

    @GetMapping(value = "/api/listagem")
    public String listagem(Model model){

        model.addAttribute("titulo", "Listagem da API");
        model.addAttribute("listagem", apiService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/endereco/listagem")
    public String listaEnderecos(Model model){

        model.addAttribute("titulo", "Listagem de Endereços");
        model.addAttribute("listagem", enderecoService.obterLista());

        return telaHome(model);
    }


    @GetMapping(value = "/municipio/listagem")
    public String listaMunicipios(Model model, @RequestParam Integer uf){

        model.addAttribute("titulo", "Listagem de Municipios");
        model.addAttribute("listagem", apiService.obterMunicipios(uf));

        return telaHome(model);
    }

    @GetMapping(value = "/vendedor/listagem")
    public String listaVendedores(Model model){

        model.addAttribute("titulo", "Listagem de Vendedores");
        model.addAttribute("listagem", vendedorService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/animal/listagem")
    public String listaAnimal(Model model){

        model.addAttribute("titulo", "Listagem de Animais");
        model.addAttribute("listagem", animalService.obterLista());

        return telaHome(model);
    }
    @GetMapping(value = "/gato/listagem")
    public String listaGatos(Model model){

        model.addAttribute("titulo", "Listagem de Gatos vendidos");
        model.addAttribute("listagem", gatoService.obterLista());

        return telaHome(model);
    }
    @GetMapping(value = "/cachorro/listagem")
    public String listaCachorros(Model model){

        model.addAttribute("titulo", "Listagem de Cachorros Vendidos");
        model.addAttribute("listagem", cachorroService.obterLista());

        return telaHome(model);
    }
}
