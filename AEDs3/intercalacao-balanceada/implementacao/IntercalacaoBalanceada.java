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

    public IntercalacaoBalanceada(int numCaminhos, int registrosPorBloco) throws Exception {

        if (numCaminhos <= 1 || registrosPorBloco < 1) 
            throw new Exception("Numero de caminhos/registros inválidos!\nColoque pelo menos dois caminhos e pelo menos um registro por bloco");
        

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

        int numBlocos = inserirBlocosNosPrimeirosCaminhos(arr);

        while (numBlocos >= caminhosOriginais.length) {
            numBlocos = inserirOrdenadoEmNovosCaminhos();
        }
        
        inserirResultadoEmCaminhoFinal();
    }

    private int inserirBlocosNosPrimeirosCaminhos(Integer[] arr) throws IOException {
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

        return numBlocos;
    }

    private int inserirOrdenadoEmNovosCaminhos() throws IOException {

        int numBloco = 0;

        int caminhoTempAtual = 0;

        while(!caminhosForamLidos()) {

            Integer[] blocoEstatico = lerNovoBlocoDosCaminhosOriginais();

            this.caminhosTmp[caminhoTempAtual].escreverBloco(blocoEstatico);

            numBloco++;

            caminhoTempAtual = numBloco % caminhosTmp.length;
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

        Integer[] arr = {5,3,2,16,356,323,43,32,693,7,10,1,8,9,66,44,33,21,78,65,99,142,66432};

        IntercalacaoBalanceada ib;
        try {
            ib = new IntercalacaoBalanceada(2, 10);
            ib.ordenar(arr);
            Integer[] arrOrdenado = ib.lerResultadoFinal();

            System.out.println("Array original: ");
            for(int i = 0 ; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            System.out.println("\nArray ordenado: ");
            for(int i = 0 ; i < arrOrdenado.length; i++) {
                System.out.print(arrOrdenado[i] + "\t");
            }
            Arrays.sort(arr);
            System.out.println("\nForam ordenados corretamente?: " + (Arrays.equals(arr, arrOrdenado) ? "SIM" : "NÃO"));

            ib.fecharCaminhos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}