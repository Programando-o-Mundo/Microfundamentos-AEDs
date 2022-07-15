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
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(String x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
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
    public void print() {
        printTree(this.raiz);
    }

	/**
	 * Metodo privado recursivo para exibir elementos em formato de arvore.
	 * @param i No em analise.
	 */
    private void printTree(No i) {
        if (i.dir != null)
            printTree(i.dir, true, "");
        
        printNo(i);
        if (i.esq != null) 
            printTree(i.esq, false, "");
        
    }

	/**
	 * Metodo privado iterativo para exibir o No atual da arvore.
	 * @param i No em analise.
	 */
    private void printNo(No i) {
        if (i == null) 
            System.out.print("<null>");
        else 
            System.out.print(i.elemento);
        
        System.out.println("");
    }

    
	/**
	 * Metodo privado recursivo para exibir elementos em formato de arvore.
	 * @param i No em analise.
	 */
    private void printTree(No i, boolean isRight, String indent)  {
        if (i.dir != null) 
            printTree(i.dir, true, indent + (isRight ? "        " : " |      "));
        
        System.out.print(indent);
        if (isRight) 
            System.out.print(" ┌── ");
        else 
            System.out.print(" └──");
    
        System.out.print("-- ");
        printNo(i);
        if (i.esq != null) 
            printTree(i.esq, false, indent + (isRight ? " |      " : "        "));
    
    }

}