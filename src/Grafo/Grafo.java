package Grafo;

import java.util.ArrayList;


public class Grafo<Integer> {
    private ArrayList<Vertice<Integer>> vertices;
    private ArrayList<Aresta<Integer>> arestas;

    public Grafo(){
        this.vertices = new ArrayList<Vertice<Integer>>();
        this.arestas = new ArrayList<Aresta<Integer>>();

    }

    public void adicionarVertice(Integer data){
        Vertice<Integer> novoVertice = new Vertice<Integer>(data); // criando um novo vertice com o dado
        this.vertices.add(novoVertice); // entrando no grafo
    }

    public void adicionarAresta(Double peso, Integer dadoInicio, Integer dadoFim){ // recebe os dados dos vertices q sao ligados pela nova aresta
        Vertice<Integer> inicio = this.getVertice(dadoInicio); // procurando o vertice q tenha o dado procurado
        Vertice<Integer> fim = this.getVertice(dadoFim); // procurando o vertice q tenha o dado procurado
        Aresta<Integer> aresta = new Aresta<Integer>(peso, inicio, fim); // criando a nova aresta
        inicio.addArestaSaida(aresta); // add a nova aresta como de saida para o vertice inicial
        fim.addArestaEntrada(aresta); // add a nova aresta como de entrada para o vertice final
        this.arestas.add(aresta); // add a nov aaresta para o grafo
    }

    public void adicionarAresta(Integer dadoInicio, Integer dadoFim) {
        this.adicionarAresta(1.0, dadoInicio, dadoFim); // Definindo um peso padrão de 1.0
    }

    public Vertice<Integer> getVertice(Integer dado) {
        for(Vertice<Integer> v : this.vertices){
            if(v.getData().equals(dado)){
                return v;
            }
        }
        return null;
    }

    public ArrayList<Vertice<Integer>> getVertices() {
        return vertices;
    }
    public ArrayList<Aresta<Integer>> getArestas() {
        return arestas;
    }

}
