package Questao1;

import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.Aresta;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    Grafo<Integer> grafo;
    Vertice<Integer> verticeInicial;


    public DFS(Grafo<Integer> grafo, Vertice<Integer>  verticeInicial) {
        this.grafo = grafo;
        this.verticeInicial = verticeInicial;

    }

    void depthFirstSearch(Grafo<Integer> G){

        for(Vertice<Integer> vertice : G.getVertices()){
            vertice.setCor("branco");
            vertice.setPi(null);
        }
        int tempo = 0;
        for(Vertice<Integer> vertice : G.getVertices()){
            if(vertice.getCor().equals("branco")){
                DFS_Visit(G, vertice, tempo);
            }
        }

    }
    void DFS_Visit(Grafo<Integer> G, Vertice<Integer> verticeInicial, int tempo){
        tempo++; // vertice branco acabou de ser descoberto
        verticeInicial.setD(tempo); // definimos o tempo de descoberta
        verticeInicial.setCor("cinza");
        for (Aresta<Integer> aresta : verticeInicial.getArestasSaida()) { // pegando a aresta q sai de u
            Vertice<Integer> verticeDestino = aresta.getFim();  // pegando o adjacente a u (entrada da aresta de saida de u)
            if(verticeDestino.getCor().equals("cinza")){
                aresta.setTipo("retorno"); // classificando as arestas como retorno
            }
            if(verticeDestino.getCor().equals("branco")){ // verifica se o vertice a ser visitado ja n foi visitado
                verticeDestino.setPi(verticeInicial); // definios o vertiice q saimos para ser o predecessor do de entrada

                DFS_Visit(G, verticeDestino, tempo);
            }
        }
        verticeInicial.setCor("preto"); // apos sair do for, fizemos todas as iteraçoes dos adjacentes ao vertice inicial
        tempo++;
        verticeInicial.setF(tempo);
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
    }

    int TamanhoCaminho(Grafo<Integer> grafo, Vertice<Integer> verticeInicial, Vertice<Integer> verticeDestino, int tempo){
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

                        v.setCor("cinza"); // pintamos ele de cinza
                        stack.push(v); // e colocamos na pilha
                        adjacenteEncontrado = true;
                        break;
                    }
                }
                if(v == verticeDestino){
                    destinoEncontrado = true;
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
    ArrayList<Aresta<Integer>> retornarCaminho(Grafo<Integer> grafo, Vertice<Integer> verticeInicial, Vertice<Integer> verticeDestino){
        ArrayList<Aresta<Integer>> caminho = new ArrayList<Aresta<Integer>>();
        boolean destinoEncontrado = false;
        for (Vertice<Integer> u : grafo.getVertices()) { // colorindo de branco  os nao visitados
            u.setCor("branco");
        }
        verticeInicial.setCor("cinza"); // pintanndo  de cinza o vertice inicial

        // criar pilha
        Stack<Vertice<Integer>> stack = new Stack<>();
        stack.push(verticeInicial);

        while (!stack.isEmpty()) {
            Vertice<Integer> u = stack.peek();
            boolean adjacenteEncontrado = false;
            for (Aresta<Integer> aresta : u.getArestasSaida()) { // pegando a aresta q sai de u
                Vertice<Integer> v = aresta.getFim(); // pegando o adjacente a u (entrada da aresta de saida de u)
                if (v != null) {
                    if (v.getCor().equals("branco")) {
                        caminho.add(aresta);
                        v.setCor("cinza"); // pintamos ele de cinza
                        stack.push(v); // e colocamos na pilha
                        adjacenteEncontrado = true;
                        break;
                    }
                }
                if(v == verticeDestino){
                    destinoEncontrado = true;
                    return caminho;
                }
                if(!adjacenteEncontrado){
                    u.setCor("preto");
                    stack.pop();
                }
            }
        }
        for(Aresta<Integer> aresta : caminho){
            System.out.println("inicio: " + aresta.getInicio().getData());
            System.out.println("fim: " + aresta.getFim().getData());
        }
        return caminho;
    }

    //metodo para retornar o tipo retorno nas arestas
    ArrayList<Aresta<Integer>> arestasRetorno(Grafo<Integer> G){
        ArrayList<Aresta<Integer>> arestasRetorno = new ArrayList<Aresta<Integer>>();
        depthFirstSearch(G); // descobrindo o grafo e classificnado as arestas
        for (Vertice<Integer> u : G.getVertices()){
            for (Aresta<Integer> aresta : u.getArestasSaida()){
                if(aresta.getTipo().equals("retorno")){
                    arestasRetorno.add(aresta);
                }
            }
        }
        return arestasRetorno;
    }
}
