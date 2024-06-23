package Questao2;

import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.Aresta;

import java.util.ArrayList;


public class Kruskal {

    void AgmKruskal(Grafo<Integer> grafo){
        ArrayList<Aresta<Integer>> arestas1 = grafo.getArestas();
        arestas1.sort((a1, a2) -> Integer.compare(a2.getPeso(), a1.getPeso()));

        A<Integer> a = new A<>();
        for (Aresta<Integer> aresta : arestas1) {
                a.addAresta(aresta); // Se desconectou, adiciona de volta
        }

        for (Aresta<Integer> aresta : arestas1) {
            a.removeAresta(aresta); // Tenta remover a aresta
            if (!a.isConectado(grafo.getVertices())) {
                a.addAresta(aresta); // Se desconectou, adiciona de volta
            }
        }
        System.out.println("Arestas na MST são:");
        for (Aresta<Integer> aresta : a.arestas) {
            System.out.println(aresta.getInicio().getData() + " - " + aresta.getFim().getData() + ": " + aresta.getPeso());
        }

//        for(Aresta<Integer> aresta : grafo.getArestas()){
//            Vertice<Integer> u = aresta.getInicio();
//            Vertice<Integer> v = aresta.getFim();
//            if (a.isVerticeIn(u) && a.isVerticeIn(v))  {
//                //se u e v estao em componentes distintos de V, A
//                a.addAresta(aresta);
//            }
//        }
    }
}
