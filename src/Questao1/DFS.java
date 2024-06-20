package Questao1;

import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.Aresta;

import java.util.Stack;

public class DFS {
    Grafo<Integer> grafo;
    Vertice<Integer> verticeInicial;


    public DFS(Grafo<Integer> grafo, Vertice<Integer>  verticeInicial) {
        this.grafo = grafo;
        this.verticeInicial = verticeInicial;

    }

    void BuscaEmProfundidade(Grafo<Integer> grafo, Vertice<Integer> verticeInicial) {

        for (Vertice<Integer> u : grafo.getVertices()) { // colorindo de branco  os nao visitados
            u.setCor("branco");
        }
        verticeInicial.setCor("cinza"); // pintnaod  de cinza o vertice inicial

        // criar pilha
        Stack<Vertice<Integer>> stack = new Stack<>();
        stack.push(verticeInicial);

        while (!stack.isEmpty()) {
            Vertice<Integer> u = stack.peek();
            boolean adjacenteEncontrado = false;
            for (Aresta<Integer> aresta : u.getArestasSaida()) { // pegando a aresta q sai de u
                Vertice<Integer> v = aresta.getFim(); // pegando o adjacente a u (entrada da aresta de saida de u)
                if (v != null) {
                    if (v.getCor().equals("branco")) { // se o adjacente nao foi visitado
                        v.setCor("cinza"); // pintamos ele de cinza
                        stack.push(v); // e colocamos na pilha
                        adjacenteEncontrado = true;
                        break;
                    }
                }
                if(!adjacenteEncontrado){
                    u.setCor("preto");
                    stack.pop();
                }
            }
        }
        // Exibir a cor final de cada vértice após a busca em profundidade
        for (Vertice<Integer> u : grafo.getVertices()) {
            System.out.println("Vértice " + u.getData() + ": " + u.getCor());
        }
    }

    int TamanhoCaminho(Grafo<Integer> grafo, Vertice<Integer> verticeInicial, Vertice<Integer> verticeDestino){
        int tam = 0;
        boolean destinoEncontrado = false;
        for (Vertice<Integer> u : grafo.getVertices()) { // colorindo de branco  os nao visitados
            u.setCor("branco");
        }
        verticeInicial.setCor("cinza"); // pintnaod  de cinza o vertice inicial

        // criar pilha
        Stack<Vertice<Integer>> stack = new Stack<>();
        stack.push(verticeInicial);

        while (!stack.isEmpty()) {
            Vertice<Integer> u = stack.peek();
            boolean adjacenteEncontrado = false;
            for (Aresta<Integer> aresta : u.getArestasSaida()) { // pegando a aresta q sai de u
                tam++;
                Vertice<Integer> v = aresta.getFim(); // pegando o adjacente a u (entrada da aresta de saida de u)
                if (v != verticeDestino && v != null) {
                    if (v.getCor().equals("branco")) {
                        // se o adjacente nao foi visitado
                        v.setCor("cinza"); // pintamos ele de cinza
                        stack.push(v); // e colocamos na pilha
                        adjacenteEncontrado = true;
                        break;
                    }
                }
                if(v == verticeDestino){
                    destinoEncontrado = true;
                    System.out.println(tam);
                    return tam;
                }
                if(!adjacenteEncontrado){
                    u.setCor("preto");
                    stack.pop();
                }
            }
        }
        return 0;
    }
    void classificarArestas(){

    }
}
