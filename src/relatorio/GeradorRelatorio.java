package relatorio;

import controle.ControlePedidos;
import modelo.Pedido;
import modelo.Prato;

public class GeradorRelatorio {
    private ControlePedidos controle;
    private Destino destino;

    public GeradorRelatorio(ControlePedidos controle, Destino destino) {
        this.controle = controle;
        this.destino = destino;
    }

    public void gerar() {
        StringBuilder sb = new StringBuilder();
        double faturamento = 0;
        Pedido maisCaro = null;

        sb.append("===== FECHAMENTO DO DIA =====\n");
        for (Pedido p : controle.getPedidos()) {
            sb.append("Cliente: " + p.getCliente().getNome() + " - " + p.getData() + "\n");
            for (Prato prato : p.getPratos()) {
                sb.append(String.format("  %s (%d min) - R$ %.2f\n",
                    prato.getNome(), prato.getTempoPreparo(), prato.calcularPreco()));
            }
            sb.append(String.format("  Total: R$ %.2f\n", p.getTotal()));

            faturamento += p.getTotal();
            if (maisCaro == null || p.getTotal() > maisCaro.getTotal()) {
                maisCaro = p;
            }
        }
        sb.append(String.format("FATURAMENTO TOTAL: R$ %.2f\n", faturamento));
        if (maisCaro != null) {
            sb.append(String.format("PEDIDO MAIS CARO: %s - R$ %.2f\n",
                maisCaro.getCliente().getNome(), maisCaro.getTotal()));
        }

        destino.enviar(sb.toString());
    }
}
