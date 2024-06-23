package questao3;

import Grafo.Aresta;
import Grafo.Vertice;
import Grafo.Grafo;

import java.util.*;

public class ModifiedDijkstra {
    public static List<List<Vertice<Integer>>> modDijkstra(Grafo<Integer> grafo, Vertice<Integer> origem, Vertice<Integer> destino) {
        Map<Vertice<Integer>, Double> dist = new HashMap<>();
        Map<Vertice<Integer>, Double> distSecond = new HashMap<>();
        Map<Vertice<Integer>, Vertice<Integer>> predecessor = new HashMap<>();
        Map<Vertice<Integer>, Vertice<Integer>> predecessorSecond = new HashMap<>();
        PriorityQueue<Vertice<Integer>> filaPrioridade = new PriorityQueue<>(Comparator.comparing(dist::get));

        for (Vertice<Integer> v : grafo.getVertices()) {
            dist.put(v, Double.MAX_VALUE);
            distSecond.put(v, Double.MAX_VALUE);
            filaPrioridade.add(v);
        }

        dist.put(origem, 0.0);
        filaPrioridade.add(origem);

        while (!filaPrioridade.isEmpty()) {
            Vertice<Integer> u = filaPrioridade.poll();

            for (Aresta<Integer> aresta : u.getArestasSaida()) {
                Vertice<Integer> v = aresta.getFim();
                double peso = aresta.getPeso();
                double distU = dist.get(u);
                double distV = dist.get(v);
                double distVSecond = distSecond.get(v);

                if (distU + peso < distV) {
                    filaPrioridade.remove(v);
                    distSecond.putAll(dist);
                    predecessorSecond.putAll(predecessor);
                    dist.put(v, distU + peso);
                    predecessor.put(v, u);
                    filaPrioridade.add(v);
                } else if (distU + peso < distVSecond && distU + peso > distV) {
                    distSecond.put(v, distU + peso);
                    predecessorSecond.put(v, u);
                }
            }
        }

        // Reconstroi os dois menores caminhos
        List<Vertice<Integer>> caminho1 = new ArrayList<>();
        List<Vertice<Integer>> caminho2 = new ArrayList<>();
        Vertice<Integer> atual = destino;

        while (atual != null) {
            caminho1.addFirst(atual);
            atual = predecessor.get(atual);
        }

        atual = destino;

        while (atual != null) {
            caminho2.addFirst(atual);
            atual = predecessorSecond.get(atual);
        }

        List<List<Vertice<Integer>>> doisMenoresCaminhos = new ArrayList<>();
        doisMenoresCaminhos.add(caminho1);
        doisMenoresCaminhos.add(caminho2);

        return doisMenoresCaminhos;
    }
}
