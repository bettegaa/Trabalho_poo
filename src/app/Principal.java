package app;

import controle.ControlePedidos;
import excecao.PrecoInvalidoException;
import java.time.LocalDate;
import modelo.Cliente;
import modelo.Combo;
import modelo.Pedido;
import modelo.PratoEspecial;
import modelo.PratoExecutivo;
import relatorio.DestinoArquivo;
import relatorio.DestinoConsole;
import relatorio.GeradorRelatorio;

public class Principal {
    public static void main(String[] args) {
        ControlePedidos controle = new ControlePedidos();

        Cliente c1 = new Cliente("maria", "rua da marmelada, 10", "42343266");
        Cliente c2 = new Cliente("joao", "flores da cunha, 20", "4324235676745");

        try {
            Pedido p1 = new Pedido(c1, LocalDate.now());
            p1.adicionarPrato(new PratoExecutivo("Executivo Frango", 25.00, 20));
            p1.adicionarPrato(new Combo("Combo Burger", 40.00, 15));
            p1.adicionarPrato(new PratoEspecial("Salmao Grelhado", 50.00, 30, 20.00));
            controle.registrar(p1);

            Pedido p2 = new Pedido(c2, LocalDate.now());
            p2.adicionarPrato(new Combo("Combo Pizza", 45.00, 25));
            controle.registrar(p2);

            
            new PratoExecutivo("Prato Errado", -5.00, 10);
        } catch (PrecoInvalidoException e) {
            System.out.println("[ERRO TRATADO] " + e.getMessage());
        }

        try {
            new Pedido(null, LocalDate.now());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERRO TRATADO] " + e.getMessage());
        }

        new GeradorRelatorio(controle, new DestinoConsole()).gerar();
        new GeradorRelatorio(controle, new DestinoArquivo("fechamento.txt")).gerar();
    }
}
