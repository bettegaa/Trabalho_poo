package relatorio;

import java.io.FileWriter;
import java.io.IOException;

public class DestinoArquivo implements Destino {
    private String nomeArquivo;

    public DestinoArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void enviar(String conteudo) {
        try {
            FileWriter fw = new FileWriter(nomeArquivo);
            fw.write(conteudo);
            fw.close();
            System.out.println("[ARQUIVO] " + nomeArquivo + " salvo.");
        } catch (IOException e) {
            System.out.println("[ERRO] Nao foi possivel salvar: " + e.getMessage());
        }
    }
}
