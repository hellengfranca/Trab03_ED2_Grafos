package Questao4;

import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

import java.util.List;

import static Questao4.BFS.*;

public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<Integer>();
        grafo.adicionarVertice(0);
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);
        grafo.adicionarAresta(0 ,1);
        grafo.adicionarAresta(1 ,0);
        grafo.adicionarAresta(0 ,4);
        grafo.adicionarAresta(4 ,0);
        grafo.adicionarAresta(1 ,2);
        grafo.adicionarAresta(2 ,1);
        grafo.adicionarAresta(1 ,4);
        grafo.adicionarAresta(4 ,1);
        grafo.adicionarAresta(2 ,3);
        grafo.adicionarAresta(3 ,2);
        grafo.adicionarAresta(3 ,1);
        grafo.adicionarAresta(1 ,3);
        grafo.adicionarAresta(4 ,3);
        grafo.adicionarAresta(3 ,4);
        grafo.adicionarAresta(5 ,4);
        grafo.adicionarAresta(4 ,5);
        grafo.adicionarAresta(5 ,0);
        grafo.adicionarAresta(0 ,5);

        Vertice<Integer> verticeInicial = grafo.getVertice(0);
        Vertice<Integer> verticeDestino = grafo.getVertice(3);

        List<Vertice<Integer>> caminho =  buscaLargura(grafo, verticeInicial);

//        for(Vertice<Integer> v : caminho){
//            System.out.println(v);
//        }

        Integer qtdArestas = contaArestasEntre(grafo, verticeInicial, verticeDestino);
//        System.out.println(qtdArestas);

        List<Vertice<Integer>> verticesDistanciaD =  verticesDDistantes(grafo, verticeInicial, 2);

//        for (Vertice<Integer> v : verticesDistanciaD) {
//            System.out.println(v.toString());
//        }

        List<Vertice<Integer>> caminhoAB = retornaCaminho(grafo, verticeInicial, verticeDestino);
        for (Vertice<Integer> v : caminhoAB) {
            System.out.println(v.toString());
        }


    }
}