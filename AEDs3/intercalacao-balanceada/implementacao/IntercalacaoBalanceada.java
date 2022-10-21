import java.io.IOException;
import java.util.ArrayList;

import java.util.Arrays;

/**
 * Implementacao do Algoritmo da Intercalacao Balanceada em Java
 * @author Gustavo Lopes Rodrigues
 * @version 1.0
 */
public class IntercalacaoBalanceada {

    private static final String NOME_CAMINHO_TEMP  = "temp";
    private static final String NOME_CAMINHO_FINAL = "resultado";

    private Caminho[] caminhosOriginais;
    private Caminho[] caminhosTmp;
    private Caminho caminhoFinal;

    private int registrosPorBloco;

    public IntercalacaoBalanceada(int numCaminhos, int registrosPorBloco) throws IOException {
        this.caminhosOriginais = new Caminho[numCaminhos];
        this.caminhosTmp = new Caminho[numCaminhos];

        this.caminhoFinal = new Caminho(NOME_CAMINHO_FINAL + "@" + hashCode() + ".dat");

        for(int i = 0; i < numCaminhos; i++) 
            this.caminhosOriginais[i] = new Caminho(NOME_CAMINHO_TEMP + i + "@" + hashCode()  + ".dat");

        for(int i = 0; i < numCaminhos; i++) 
            this.caminhosTmp[i] = new Caminho(NOME_CAMINHO_TEMP + (i + numCaminhos) + "@" + hashCode()  + ".dat");
        
        this.registrosPorBloco = registrosPorBloco;
    }

    /**
     * Principal funcao, ordernar o array especificado
     * @throws IOException
     */
    public void ordenar(Integer[] arr) throws IOException {

        inserirBlocosNosPrimeirosCaminhos(arr);

        int numBlocos = 0;
        while (numBlocos != caminhosOriginais.length) {
            numBlocos = inserirOrdenadoEmNovosCaminhos();
        }
        
        inserirResultadoEmCaminhoFinal();
    }

    private void inserirBlocosNosPrimeirosCaminhos(Integer[] arr) throws IOException {
        int tamArr = arr.length;
        int numCaminhos = caminhosOriginais.length;

        ArrayList<Integer> bloco = new ArrayList<>();
        int numBlocos = 0;
        for(int i = 0; i < tamArr; i++) {

            bloco.add(arr[i]);

            if(bloco.size() == registrosPorBloco || i==tamArr-1) {

                Integer[] blocoEstatico = transformarArrayListEmArrayEstatico(bloco);
                
                Arrays.sort(blocoEstatico);

                int caminhoAtual = numBlocos++ % numCaminhos;
                this.caminhosOriginais[caminhoAtual].escreverBloco(blocoEstatico);

                bloco.clear();
            }
        }

        for(int i = 0; i < caminhosOriginais.length; i++) {
            this.caminhosOriginais[i].resetarPonteiro();
        }
    }

    private int inserirOrdenadoEmNovosCaminhos() throws IOException {

        int numBloco = 0;

        int caminhoTempAtual = 0;

        while(!caminhosForamLidos()) {

            Integer[] blocoEstatico = lerNovoBlocoDosCaminhosOriginais();

            this.caminhosTmp[caminhoTempAtual].escreverBloco(blocoEstatico);
            caminhoTempAtual = (caminhoTempAtual == 0) ? 1 : 0;

            numBloco++;
        }

        resetarPonteiroDosCaminhos(caminhosTmp);
        trocarConteudoDosCaminhos();
        resetarPonteiroDosCaminhos(caminhosOriginais);

        return numBloco;
    }

    private Integer[] lerNovoBlocoDosCaminhosOriginais() throws IOException {
        int numCaminhos = caminhosOriginais.length;

        int[] numRegistroDoBlocoDoCaminhoAtual = new int[numCaminhos];
        int[] posEmBlocoDoCaminho = new int[numCaminhos];
        ArrayList<Integer> bloco = new ArrayList<>();

        for(int i = 0; i < numCaminhos; i++) {
            if (this.caminhosOriginais[i].ehFinalDoArquivo()) {
                numRegistroDoBlocoDoCaminhoAtual [i] = 0;  
            } else {
                int tamBlocoAtual = this.caminhosOriginais[i].lerProximoInteiro();
                numRegistroDoBlocoDoCaminhoAtual [i] = tamBlocoAtual;
            }

            posEmBlocoDoCaminho[i] = 0;  
        } 

        while(!blocoAtualFoiLido(numRegistroDoBlocoDoCaminhoAtual ,posEmBlocoDoCaminho)) {
            int menor = Integer.MAX_VALUE;
            int caminho_menor_numero = -1;

            for(int i = 0; i < numCaminhos; i++) {

                if (posEmBlocoDoCaminho[i] < numRegistroDoBlocoDoCaminhoAtual[i]) {
                    posEmBlocoDoCaminho[i]++;
                    int num = this.caminhosOriginais[i].lerProximoInteiro();

                    if (num < menor) {
                        menor = num;
                        if (caminho_menor_numero != -1) {
                            this.caminhosOriginais[caminho_menor_numero].voltarParaUltimaPosicao();
                            posEmBlocoDoCaminho[caminho_menor_numero]--;
                        }
                        caminho_menor_numero = i;

                    } else {
                        this.caminhosOriginais[i].voltarParaUltimaPosicao();
                        posEmBlocoDoCaminho[i]--;
                    }
                }
            }

            bloco.add(menor);
        }

        return transformarArrayListEmArrayEstatico(bloco);
    }

    private Integer[] transformarArrayListEmArrayEstatico(ArrayList<Integer> arr) {
        Integer[] blocoEstatico = new Integer[arr.size()];
        return arr.toArray(blocoEstatico);
    }

    private void inserirResultadoEmCaminhoFinal() throws IOException {

        Integer[] blocoEstatico = lerNovoBlocoDosCaminhosOriginais();

        this.caminhoFinal.escreverBloco(blocoEstatico);
    }

    private boolean caminhosForamLidos() throws IOException {
        boolean foramLidos = true;

        for(Caminho c : caminhosOriginais) {
            if(c.ehFinalDoArquivo() == false) {
                foramLidos = false;
                break;
            }
        }

        return foramLidos;
    }

    private boolean blocoAtualFoiLido(int[] quantRegistrosBloco, int[] posicaoNoBloco) {
        boolean foramLidos = true;
        for (int i = 0; i < quantRegistrosBloco.length; i++) {
            if(quantRegistrosBloco[i] != posicaoNoBloco[i]) {
                foramLidos = false; 
                break;
            }
        }
        
        return foramLidos;
    }

    public void fecharCaminhos() throws IOException {
        for(int i = 0 ; i < caminhosOriginais.length; i++) {
            this.caminhosOriginais[i].fecharArquivo();
            this.caminhosTmp[i].fecharArquivo();
        }

        this.caminhoFinal.fecharArquivo();
    }

    public void trocarConteudoDosCaminhos() throws IOException {
        for(int i = 0 ; i < caminhosOriginais.length; i++) {
            this.caminhosOriginais[i].trocarConteudoPorOutroCaminho(this.caminhosTmp[i]);
            this.caminhosTmp[i].limparCaminho();
        }        
    }
    
    public Integer[] lerResultadoFinal() throws IOException {

        Integer[] arr;
        this.caminhoFinal.resetarPonteiro();
        int quant_numeros = this.caminhoFinal.lerProximoInteiro();
        arr = new Integer[quant_numeros];

        for(int i = 0; i < quant_numeros; i++) 
            arr[i] = this.caminhoFinal.lerProximoInteiro();
        
        return arr;
    }

    private void resetarPonteiroDosCaminhos(Caminho[] c) throws IOException {
        for(int i = 0; i < caminhosOriginais.length; i++) 
            c[i].resetarPonteiro();
    }

    public static void main(String[] args) {

        Integer[] arr = {5,3,2,16,356,323,43,32,693,7,10,1};

        IntercalacaoBalanceada ib;
        try {
            ib = new IntercalacaoBalanceada(2, 4);
            ib.ordenar(arr);
            Integer[] arrOrdenado = ib.lerResultadoFinal();

            System.out.println("Array original: ");
            for(int i = 0 ; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            System.out.println("\nArray ordenado: ");
            for(int i = 0 ; i < arr.length; i++) {
                System.out.print(arrOrdenado[i] + "\t");
            }
            Arrays.sort(arr);
            System.out.println("\nForam ordenados corretamente?: " + (Arrays.equals(arr, arrOrdenado) ? "SIM" : "NÃO"));

            ib.fecharCaminhos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
