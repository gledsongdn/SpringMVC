package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtodao;

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String gravar(Produto produto) {
        System.out.println(produto);
        produtodao.gravar(produto);
        return "produtos/ok";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Produto> produtos = produtodao.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
}
