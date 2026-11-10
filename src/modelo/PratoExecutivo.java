package modelo;

import excecao.PrecoInvalidoException;

public class PratoExecutivo extends Prato {

    public PratoExecutivo(String nome, double precoBase, int tempoPreparo) throws PrecoInvalidoException {
        super(nome, precoBase, tempoPreparo);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }
}
