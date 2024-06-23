package Questao1;

import Grafo.Grafo;
import Grafo.Aresta;
import Grafo.Vertice;

public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<Integer>();
        grafo.adicionarVertice(0);
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);
        grafo.adicionarAresta(1, 0 ,1);
        grafo.adicionarAresta(1, 0 ,4);
        grafo.adicionarAresta(1, 1 ,2);
        grafo.adicionarAresta(1, 1 ,4);
        grafo.adicionarAresta(1, 2 ,3);
        grafo.adicionarAresta(1, 3 ,1);
        grafo.adicionarAresta(1, 4 ,3);
        grafo.adicionarAresta(1, 5 ,4);
        grafo.adicionarAresta(1, 5 ,0);

        Vertice<Integer> verticeInicial = grafo.getVertice(1);
        Vertice<Integer> verticeDestino = grafo.getVertice(3);
        DFS dfs = new DFS(grafo, verticeInicial);

        int tam = dfs.TamanhoCaminho(grafo, verticeInicial, verticeDestino, 0);

        if(tam==0){
            System.out.println("Caminho inexistente");
        } else {
            System.out.println("Tamanho do Caminho de "+ verticeInicial.getData() + " até " + verticeDestino.getData()+ ": " + tam);
        }

        dfs.retornarCaminho(grafo, verticeInicial, verticeDestino);
        System.out.println("Caminho de "+ verticeInicial.getData() + " até " + verticeDestino.getData());
        for(Aresta<Integer> aresta : dfs.retornarCaminho(grafo, verticeInicial, verticeDestino)){
            System.out.println("(" + aresta.getInicio().getData()+", "+ aresta.getFim().getData()+")");
        }

        dfs.arestasRetorno(grafo);
        System.out.println("Arestas do tipo retorno do grafo:");
        for(Aresta<Integer> aresta : dfs.arestasRetorno(grafo)){
            System.out.println("(" + aresta.getInicio().getData()+", "+ aresta.getFim().getData()+")");
        }

        dfs.BuscaEmProfundidade(grafo, verticeInicial);
        // Exibir a cor final de cada vértice após a busca em profundidade
        for (Vertice<Integer> u : grafo.getVertices()) {
            System.out.println("Vértice " + u.getData() + ": " + u.getCor());
        }
        dfs.depthFirstSearch(grafo);
        for (Vertice<Integer> u : grafo.getVertices()) {
            System.out.println("Vértice " + u.getData() + ": " + u.getCor());
        }
    }
}