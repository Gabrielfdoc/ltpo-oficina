package com.ltpo;

import com.ltpo.DAO.AutomovelDAO;
import com.ltpo.DAO.ModeloDAO;
import com.ltpo.DAO.UsuariosDAO;
import com.ltpo.enums.TipoUsuario;
import com.ltpo.model.Automovel;
import com.ltpo.model.Modelo;
import com.ltpo.model.Usuarios;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Modelo modelo = new Modelo("Honda Civic");

        Automovel carro1 = new Automovel(modelo, "ABC-1234", 2018, "Prata");
        Automovel carro2 = new Automovel(modelo, "DEF-5678", 2020, "Preto");

        Usuarios usuario = new Usuarios(
                TipoUsuario.CLIENTE,
                "João da Silva",
                "11999999999",
                Arrays.asList(carro1, carro2)
        );

        ModeloDAO modeloDAO = new ModeloDAO();
        modeloDAO.salvar(modelo);

        AutomovelDAO automovelDAO = new AutomovelDAO();
        automovelDAO.salvar(carro1);
        automovelDAO.salvar(carro2);

        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.salvar(usuario);

        modeloDAO.fechar();
        automovelDAO.fechar();
        usuariosDAO.fechar();

        System.out.println("Usuário e automóveis salvos com sucesso.");

        UsuariosDAO usuariosDAO2 = new UsuariosDAO();
        List<Usuarios> usuarios = usuariosDAO2.buscarTodos();
        System.out.println("Usuários cadastrados:");
        for (Usuarios u : usuarios) {
            System.out.println(u.getNome());
            for (Automovel a : u.getAutomoveis()) {
                System.out.println("  - " + a.getPlaca() + " (" + a.getModelo().getNome() + ")");
            }
        }

        ModeloDAO modeloDAO2 = new ModeloDAO();
        List<Modelo> modelos = modeloDAO2.buscarTodos();
        System.out.println("\nModelos cadastrados:");
        for (Modelo m : modelos) {
            System.out.println(m.getNome());
        }

        AutomovelDAO automovelDAO2 = new AutomovelDAO();
        List<Automovel> automoveis = automovelDAO2.buscarTodos();
        System.out.println("\nAutomóveis cadastrados:");
        for (Automovel a : automoveis) {
            System.out.println(a.getPlaca() + " - " + a.getAno() + " - " + a.getCor() + " - " + a.getModelo().getNome());
        }

        modeloDAO2.fechar();
        automovelDAO2.fechar();
        usuariosDAO2.fechar();
    }
}