package modelo;

import excecao.PrecoInvalidoException;

public class PratoEspecial extends Prato {
    private double ingredientePremium;

    public PratoEspecial(String nome, double precoBase, int tempoPreparo, double ingredientePremium)
            throws PrecoInvalidoException {
        super(nome, precoBase, tempoPreparo);
        this.ingredientePremium = ingredientePremium;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() + ingredientePremium;
    }
}
