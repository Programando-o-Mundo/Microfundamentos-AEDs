class No {
    public String elemento; // Conteudo do no.
	public No esq, dir;  // Filhos da esq e dir.

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	public No(String elemento) {
		this(elemento, null, null);
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	public No(String elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

/*
* Exemplo de implementação de um ArvoreBinaria 
* com metodo de "print" customizado para imprimir
* a arvore em formato de uma arvore, usando ASCII.
*/
class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarCentral() {
		System.out.print("[ ");
		mostrarCentral(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void mostrarCentral(No i) {
		if (i != null) {
			mostrarCentral(i.esq); // Elementos da esquerda.
			System.out.println(i.elemento + " "); // Conteudo do no.
			mostrarCentral(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(String x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(String x, No i) throws Exception {
		if (i == null) {
			i = new No(x);

		} else if (x.compareTo(i.elemento) < 0) {
			i.esq = inserir(x, i.esq);

		} else if (x.compareTo(i.elemento) > 0) {
			i.dir = inserir(x, i.dir);

		} else {
			throw new Exception("Erro ao inserir!");
		}

		return i;
	}

	/**
	 * Metodo publico iterativo para exibir elementos em formato de arvore.
	 */
	public void mostrarASCII() {
		mostrarRaizASCII(this.raiz);
	}

	/**
	 * Metodo privado recursivo para exibir elementos em formato de arvore.
	 * 
	 * @param i No em analise.
	 */
	private void mostrarRaizASCII(No i) {
		if (i.dir != null)
			mostrarFolhasASCII(i.dir, true, "");

		mostrarNoASCII(i);
		if (i.esq != null)
			mostrarFolhasASCII(i.esq, false, "");

	}

	/**
	 * Metodo privado iterativo para exibir o No atual da arvore.
	 * 
	 * @param i No em analise.
	 */
	private void mostrarNoASCII(No i) {
		if (i == null)
			System.out.print("<null>");
		else
			System.out.print(i.elemento);

		System.out.println("");
	}

	/**
	 * Metodo privado recursivo para exibir elementos em formato de arvore.
	 * 
	 * @param i No em analise.
	 */
	private void mostrarFolhasASCII(No i, boolean indentarDir, String indentacao) {
		if (i.dir != null)
			mostrarFolhasASCII(i.dir, true, indentacao + (indentarDir ? "        " : " |      "));

		System.out.print(indentacao);
		if (indentarDir)
			System.out.print(" ┌── ");
		else
			System.out.print(" └──");

		System.out.print("-- ");
		mostrarNoASCII(i);
		if (i.esq != null)
			mostrarFolhasASCII(i.esq, false, indentacao + (indentarDir ? " |      " : "        "));

	}

	/*
	* Exemplo de como usar o metodo "mostrarASCII"
	*/
	public static void main(String[] args) throws Exception {

		String[] palavras = {"cuidador","criticos","independentemente","abacate","modificar","metas","positivamente"};
	
		ArvoreBinaria arvore = new ArvoreBinaria();

		for( String s : palavras) {
			arvore.inserir(s);
		}

		arvore.mostrarASCII();
	
	}
}
