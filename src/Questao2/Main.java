package Questao2;

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
        grafo.adicionarVertice(6);
        grafo.adicionarVertice(7);
        grafo.adicionarVertice(8);
        grafo.adicionarVertice(9);
        grafo.adicionarAresta(3,0,3);
        grafo.adicionarAresta(3,3,0);
        grafo.adicionarAresta(8,0,5);
        grafo.adicionarAresta(8,5,0);
        grafo.adicionarAresta(5,0,8);
        grafo.adicionarAresta(5,8,0);
        grafo.adicionarAresta(15,0,9);
        grafo.adicionarAresta(15,9,0);
        grafo.adicionarAresta(18,0,6);
        grafo.adicionarAresta(18,6,0);
        grafo.adicionarAresta(9,3,5);
        grafo.adicionarAresta(9,5,3);
        grafo.adicionarAresta(6,3,6);
        grafo.adicionarAresta(6,6,3);
        grafo.adicionarAresta(2,6,9);
        grafo.adicionarAresta(2,9,6);
        grafo.adicionarAresta(2,6,9);
        grafo.adicionarAresta(7,8,9);
        grafo.adicionarAresta(7,9,8);
        grafo.adicionarAresta(7,8,5);
        grafo.adicionarAresta(7,5,8);
        grafo.adicionarAresta(2,5,2);
        grafo.adicionarAresta(2,2,5);
        grafo.adicionarAresta(7,2,3);
        grafo.adicionarAresta(7,3,2);
        Kruskal kruskal = new Kruskal();

        kruskal.AgmKruskal(grafo);
    }
}
