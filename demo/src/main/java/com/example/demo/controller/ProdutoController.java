package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Produto.Produto;
import com.example.demo.model.Produto.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Página principal mostrando a lista de produtos
    @GetMapping("/")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "index"; // Renderiza o template index.html
    }

    // Página de cadastro de novos produtos
    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastro"; // Renderiza o template cadastro.html
    }

    // Tratamento do formulário de cadastro
    @PostMapping("/cadastro")
    public String cadastrarProduto(Produto produto) {
        produtoRepository.save(produto); // Salva o produto no banco de dados
        return "redirect:/"; // Redireciona para a página inicial após o cadastro
    }
}
