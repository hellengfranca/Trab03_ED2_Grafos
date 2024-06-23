package questao3;

import Grafo.Grafo;
import Grafo.Vertice;

import java.util.ArrayList;
import java.util.List;

import static Questao4.BFS.*;
import static questao3.ModifiedDijkstra.modDijkstra;

public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<Integer>();
        grafo.adicionarVertice(0);
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarAresta(10.0,0 ,1);
        grafo.adicionarAresta(5.0,0 ,2);
        grafo.adicionarAresta(1.0, 1, 3);
        grafo.adicionarAresta(2.0, 1, 2);
        grafo.adicionarAresta(3.0, 2, 1);
        grafo.adicionarAresta(2.0, 2, 4);
        grafo.adicionarAresta(9.0, 2, 3);
        grafo.adicionarAresta(4.0, 3, 4);
        grafo.adicionarAresta(7.0, 4, 0);
        grafo.adicionarAresta(6.0, 4, 3);

        Vertice<Integer> verticeInicial = grafo.getVertice(0);
        Vertice<Integer> verticeDestino = grafo.getVertice(3);

        List<List<Vertice<Integer>>> doisMenoresCaminhos = modDijkstra(grafo, verticeInicial, verticeDestino);
        List<Vertice<Integer>> caminho1 = doisMenoresCaminhos.get(0);
        List<Vertice<Integer>> caminho2 = doisMenoresCaminhos.get(1);

        System.out.println("Caminho 1:");
        for(Vertice<Integer> v : caminho1){
            System.out.println(v);
        }

        System.out.println();

        System.out.println("Caminho 2:");
        for(Vertice<Integer> v : caminho2){
            System.out.println(v);
        }


    }
}