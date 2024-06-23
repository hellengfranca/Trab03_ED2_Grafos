package Questao4;
import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

import java.util.*;

public class BFS {
    public static List<Vertice<Integer>> buscaLargura(Grafo<Integer> grafo, Vertice<Integer> verticeInicial){
        List<Vertice<Integer>> ordemDeBusca = new ArrayList<>();
        if (grafo.getVertices().contains(verticeInicial)){
            Queue<Vertice<Integer>> fila = new LinkedList<>();
            List<Vertice<Integer>> visitados = new ArrayList<>();

            fila.add(verticeInicial);

            while(!fila.isEmpty()){
                Vertice<Integer> verticeAtual = fila.poll();
                ordemDeBusca.add(verticeAtual);
                visitados.add(verticeAtual);

                for(Aresta<Integer> a: verticeAtual.getArestasSaida()){
                    Vertice<Integer> adjacente = a.getFim();
                    if(!visitados.contains(adjacente) && !fila.contains(adjacente)){
                        fila.add(adjacente);
                    }
                }
            }
        }
        return ordemDeBusca;
    }

    public static Integer contaArestasEntre(Grafo<Integer> grafo, Vertice<Integer> verticeInicial, Vertice<Integer> verticeFinal){

        if (grafo.getVertices().contains(verticeInicial) && grafo.getVertices().contains(verticeFinal)){
            Queue<Vertice<Integer>> fila = new LinkedList<>();
            List<Vertice<Integer>> visitados = new ArrayList<>();
            Map<Vertice<Integer>, Integer> distancias = new HashMap<>();
            Vertice<Integer> verticeAtual = verticeInicial;

            fila.add(verticeInicial);
            distancias.put(verticeAtual, 0);
            while(!fila.isEmpty()){
                verticeAtual = fila.poll();
                visitados.add(verticeAtual);
                Integer distanciaAtual = distancias.get(verticeAtual);

                if(verticeAtual.equals(verticeFinal)){
                    return distanciaAtual;
                }

                for(Aresta<Integer> a: verticeAtual.getArestasSaida()){
                    Vertice<Integer> adjacente = a.getFim();
                    if(!visitados.contains(adjacente) && !fila.contains(adjacente)){
                        fila.add(adjacente);
                        distancias.put(adjacente, distanciaAtual+1);
                    }
                }
            }
        }
        return null;
    }

    public static List<Vertice<Integer>> verticesDDistantes(Grafo<Integer> grafo, Vertice<Integer> verticeInicial, Integer distancia){

        List<Vertice<Integer>> verticesDistanciaD = new ArrayList<>();

        if (grafo.getVertices().contains(verticeInicial)){
            Queue<Vertice<Integer>> fila = new LinkedList<>();
            List<Vertice<Integer>> visitados = new ArrayList<>();
            Map<Vertice<Integer>, Integer> distancias = new HashMap<>();
            Vertice<Integer> verticeAtual = verticeInicial;

            fila.add(verticeInicial);
            distancias.put(verticeAtual, 0);
            while(!fila.isEmpty()){
                verticeAtual = fila.poll();
                visitados.add(verticeAtual);
                Integer distanciaAtual = distancias.get(verticeAtual);

                if(distanciaAtual.equals(distancia)){
                    verticesDistanciaD.add(verticeAtual);
                }

                for(Aresta<Integer> a: verticeAtual.getArestasSaida()){
                    Vertice<Integer> adjacente = a.getFim();
                    if(!visitados.contains(adjacente) && !fila.contains(adjacente)){
                        fila.add(adjacente);
                        distancias.put(adjacente, distanciaAtual+1);
                    }
                }
            }

        }
        return verticesDistanciaD;
    }

    public static List<Vertice<Integer>> retornaCaminho(Grafo<Integer> grafo, Vertice<Integer> verticeInicial, Vertice<Integer> verticeFinal){
        List<Vertice<Integer>> caminho = new ArrayList<>();
        if (grafo.getVertices().contains(verticeInicial) && grafo.getVertices().contains(verticeFinal)){
            Queue<Vertice<Integer>> fila = new LinkedList<>();
            List<Vertice<Integer>> visitados = new ArrayList<>();
            Map<Vertice<Integer>, Vertice<Integer>> predecessor = new HashMap<>();

            fila.add(verticeInicial);
            predecessor.put(verticeInicial, null);

            while(!fila.isEmpty()){
                Vertice<Integer> verticeAtual = fila.poll();
                visitados.add(verticeAtual);

                if(verticeAtual.equals(verticeFinal)){
                    caminho.addFirst(verticeAtual);
                    while(predecessor.get(verticeAtual) != null){
                        caminho.addFirst(predecessor.get(verticeAtual));
                        verticeAtual = predecessor.get(verticeAtual);
                    }
                    return caminho;
                }

                for(Aresta<Integer> a: verticeAtual.getArestasSaida()){
                    Vertice<Integer> adjacente = a.getFim();
                    if(!visitados.contains(adjacente) && !fila.contains(adjacente)){
                        predecessor.put(adjacente, verticeAtual);
                        fila.add(adjacente);
                    }
                }
            }
        }
        return caminho;
    }

}