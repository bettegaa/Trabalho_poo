package relatorio;

public class DestinoConsole implements Destino {

    @Override
    public void enviar(String conteudo) {
        System.out.println(conteudo);
    }
}
