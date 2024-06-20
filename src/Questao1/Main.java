package Questao1;

import Grafo.Grafo;
import Grafo.Aresta;
import Grafo.Vertice;
import Questao1.DFS;

public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<Integer>();
        grafo.adicionarVertice(0);
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);
        grafo.adicionarAresta(1.0, 0 ,1);
        grafo.adicionarAresta(1.0, 0 ,4);
        grafo.adicionarAresta(1.0, 1 ,2);
        grafo.adicionarAresta(1.0, 1 ,4);
        grafo.adicionarAresta(1.0, 2 ,3);
        grafo.adicionarAresta(1.0, 3 ,1);
        grafo.adicionarAresta(1.0, 4 ,3);
        grafo.adicionarAresta(1.0, 5 ,4);
        grafo.adicionarAresta(1.0, 5 ,0);

        Vertice<Integer> verticeInicial = grafo.getVertice(1);
        Vertice<Integer> verticeDestino = grafo.getVertice(3);
        DFS dfs = new DFS(grafo, verticeInicial);
        dfs.BuscaEmProfundidade(grafo,verticeInicial);
        dfs.TamanhoCaminho(grafo, verticeInicial, verticeDestino);
    }
}