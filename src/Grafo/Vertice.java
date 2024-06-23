package Grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Vertice<Integer>{
    private Integer data;
    private ArrayList<Aresta<Integer>> arestasEntrada; //todo vertice direcionado tem as arestas de entrada e saida
    private ArrayList<Aresta<Integer>> arestasSaida;
    private String cor;
    private int d; // tempo de descoberta
    private int f; // tempo de finalizacão
    private Vertice<Integer> pi; // predecessor
    private boolean visitado;
    private Set<Vertice<Integer>> vizinhos = new HashSet<Vertice<Integer>>();

    public Vertice(Integer valor){
        this.data = valor;
        this.arestasEntrada = new ArrayList<Aresta<Integer>>();
        this.arestasSaida = new ArrayList<Aresta<Integer>>();
        this.cor = "branca";
    }
    public void addVizinho(Vertice<Integer> vertice){
        vizinhos.add(vertice);
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public ArrayList<Aresta<Integer>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<Integer>> getArestasSaida() {
        return arestasSaida;
    }

    public void addArestaEntrada(Aresta<Integer> aresta){
        this.arestasEntrada.add(aresta);
    }
    public void addArestaSaida(Aresta<Integer> aresta){
        this.arestasSaida.add(aresta);
    }

    public void Adj(Vertice<Integer> vertice){

    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Vertice<Integer> getPi() {
        return pi;
    }

    public void setPi(Vertice<Integer> pi) {
        this.pi = pi;
    }
}
