import java.io.IOException;
import java.io.RandomAccessFile;

public class Caminho {
    
    private RandomAccessFile arquivo;
    private long ultimaPos;

    public Caminho(String nomeArq) throws IOException {

        this.arquivo = new RandomAccessFile(nomeArq, "rw");
        this.arquivo.seek(0);
    }

    public void escreverBloco(Integer[] arr) throws IOException {

        long tamanhoArq = this.arquivo.length();

        this.arquivo.seek(tamanhoArq);

        this.arquivo.writeInt(arr.length);
        
        for(int i : arr) 
            this.arquivo.writeInt(i);

        tamanhoArq = this.arquivo.length();

        
    }

    public void resetarPonteiro() throws IOException {
        this.arquivo.seek(0);
    }

    public int lerProximoInteiro() throws IOException {
        this.ultimaPos = this.arquivo.getFilePointer();
        long tamanhoArq = this.arquivo.length();
        return this.arquivo.readInt();
    }

    public void voltarParaUltimaPosicao() throws IOException {
        this.arquivo.seek(ultimaPos);
    }

    public void fecharArquivo() throws IOException {
        this.arquivo.close();
    }

    public boolean ehFinalDoArquivo() throws IOException {
        return this.arquivo.getFilePointer() >= this.arquivo.length();
    }

    public void limparCaminho() throws IOException {
        this.arquivo.setLength(0);
    }

    public long getTamanhoCaminho() throws IOException {
        return this.arquivo.length();
    }

    public void trocarConteudoPorOutroCaminho(Caminho c) throws IOException {
        this.limparCaminho();

        while(!c.ehFinalDoArquivo()) {
            int tam_bloco = c.lerProximoInteiro();
            this.arquivo.writeInt(tam_bloco);
            for (int i = 0; i < tam_bloco; i++) {
                this.arquivo.writeInt(c.lerProximoInteiro());
            }
        }
    }
}
