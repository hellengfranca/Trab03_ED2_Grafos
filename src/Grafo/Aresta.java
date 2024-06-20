package Grafo;

public class Aresta<Integer> {
    private Double peso;
    private Vertice<Integer> inicio; // u
    private Vertice<Integer> fim; // v
    private String tipo;

    public Aresta(Double peso, Vertice<Integer> inicio, Vertice<Integer> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
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
