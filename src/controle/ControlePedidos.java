package controle;

import java.util.ArrayList;
import modelo.Pedido;

public class ControlePedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void registrar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
