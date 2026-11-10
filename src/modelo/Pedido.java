package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private LocalDate data;
    private ArrayList<Prato> pratos;

    public Pedido(Cliente cliente, LocalDate data) {
        if (cliente == null) {
            throw new IllegalArgumentException("Pedido sem cliente nao pode existir");
        }
        this.cliente = cliente;
        this.data = data;
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public double getTotal() {
        double total = 0;
        for (Prato p : pratos) {
            total += p.calcularPreco();
        }
        return total;
    }

    public Cliente getCliente() { return cliente; }
    public LocalDate getData() { return data; }
    public ArrayList<Prato> getPratos() { return pratos; }
}
