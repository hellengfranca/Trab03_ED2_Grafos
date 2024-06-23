package Grafo;

public class Aresta<Integer> {
    private int peso;
    private Vertice<Integer> inicio; // u
    private Vertice<Integer> fim; // v
    private String tipo = " ";

    public Aresta(int peso, Vertice<Integer> inicio, Vertice<Integer> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertice<Integer> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<Integer> inicio) {
        this.inicio = inicio;
    }

    public Vertice<Integer> getFim() {
        return fim;
    }

    public void setFim(Vertice<Integer> fim) {
        this.fim = fim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
