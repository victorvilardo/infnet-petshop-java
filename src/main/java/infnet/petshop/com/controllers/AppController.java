package infnet.petshop.com.controllers;

import infnet.petshop.com.service.AnimalService;
import infnet.petshop.com.service.CachorroService;
import infnet.petshop.com.service.GatoService;
import infnet.petshop.com.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AppController {

    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private GatoService gatoService;
    @Autowired
    private CachorroService cachorroService;

    @GetMapping(value = "/")
    public String telaHome(Model model){

        model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
        model.addAttribute("qtdeAnimal", animalService.obterQtde());
        model.addAttribute("qtdeGato", gatoService.obterQtde());
        model.addAttribute("qtdeCachorro", cachorroService.obterQtde());

        return "home";
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
