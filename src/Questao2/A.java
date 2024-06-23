package Questao2;
import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.Aresta;

import java.util.*;

public class A<Integer> {
    ArrayList<Aresta<Integer>> arestas;

    public A(){
    }

    public void addAresta(Aresta<Integer> aresta){
        this.arestas.add(aresta);
    }

    public void removeAresta(Aresta<Integer> aresta){
        this.arestas.remove(aresta);
    }

    public int compareAresta(Aresta<Integer> aresta1, Aresta<Integer> aresta2){
        if(aresta1.getPeso()==aresta2.getPeso()){
            return 0;
        }
        if(aresta1.getPeso()>aresta2.getPeso()){
            return 1;
        }
        else{
            return -1;
        }
    }

    public boolean isVerticeIn(Vertice<Integer> vertice){
        for(Aresta<Integer> aresta : this.arestas){
            if(aresta.getInicio().equals(vertice) || aresta.getFim().equals(vertice)){
                return true;
            }
        }
        return false;
    }
    public boolean isConectado(ArrayList<Vertice<Integer>> vertices) {
        if (arestas.isEmpty()) return false;

        Map<Vertice<Integer>, Set<Vertice<Integer>>> componentes = new HashMap<>();
        for (Vertice<Integer> vertice : vertices) {
            componentes.put(vertice, new HashSet<>(Collections.singletonList(vertice)));
        }

        for (Aresta<Integer> aresta : arestas) {
            Vertice<Integer> u = aresta.getInicio();
            Vertice<Integer> v = aresta.getFim();
            Set<Vertice<Integer>> componenteU = componentes.get(u);
            Set<Vertice<Integer>> componenteV = componentes.get(v);

            if (componenteU != componenteV) {
                componenteU.addAll(componenteV);
                for (Vertice<Integer> vertice : componenteV) {
                    componentes.put(vertice, componenteU);
                }
            }
        }

        Set<Vertice<Integer>> primeiroComponente = componentes.values().iterator().next();
        for (Set<Vertice<Integer>> componente : componentes.values()) {
            if (componente != primeiroComponente) {
                return false;
            }
        }
        return true;
    }
}
