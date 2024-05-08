import java.util.*;

public class DijkstraAlgorithm {

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int djkstraForVertex(List<List<Edge>> graph, int source, int dest) {
		int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int u = current.vertex;
            int dist = current.distance;

            if (distances[u] < dist) {
                continue;
            }

            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (dist + weight < distances[v]) {
                    distances[v] = dist + weight;
                    minHeap.offer(new Node(v, distances[v]));
                }
            }
        }

        return distances[dest];
    }

    public static int[] dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int u = current.vertex;
            int dist = current.distance;

            if (distances[u] < dist) {
                continue;
            }

            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (dist + weight < distances[v]) {
                    distances[v] = dist + weight;
                    minHeap.offer(new Node(v, distances[v]));
                }
            }
        }

        return distances;
    }

    public static void floydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] distances = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                distances[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }

        printSolution(distances);
	}

    public static void printSolution(int[][] distances) {
        int vertices = distances.length;
        System.out.println("\nThe following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (distances[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(distances[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static HashMap<Character, Integer> createMap() {
        HashMap<Character, Integer> letterToNumber = new HashMap<>();

        int n = 15;
        for (int i = 0; i < n; i++) {
            char letter = (char) ('a' + i);
            int number = i;
            letterToNumber.put(letter, number);
        }

        System.out.println("Letter to Number mappings:");
        System.out.println(letterToNumber);

        return letterToNumber;
    }

    public static void main(String[] args) {

        int INF = 999999;
        int n = 15;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 5));
        graph.get(0).add(new Edge(2, 10));

        graph.get(1).add(new Edge(5, 3));
        graph.get(1).add(new Edge(4, 8));

        graph.get(2).add(new Edge(1, 6));
        graph.get(2).add(new Edge(5, 6));

        graph.get(3).add(new Edge(7, 2));

        graph.get(4).add(new Edge(8, 6));
        graph.get(4).add(new Edge(5, 4));
        graph.get(4).add(new Edge(3, 4));

        graph.get(5).add(new Edge(9, 4));
        graph.get(5).add(new Edge(6, 5));

        graph.get(6).add(new Edge(10, 7));

        graph.get(7).add(new Edge(8, 7));
        graph.get(7).add(new Edge(11, 10));
        graph.get(7).add(new Edge(12, 8));

        graph.get(8).add(new Edge(12, 9));

        graph.get(9).add(new Edge(4, 5));
        graph.get(9).add(new Edge(8, 3));
        graph.get(9).add(new Edge(12, 5));
        graph.get(9).add(new Edge(13, 4));

        graph.get(10).add(new Edge(9, 6));
        graph.get(10).add(new Edge(13, 6));
        graph.get(10).add(new Edge(14, 8));

        graph.get(11).add(new Edge(12, 4));

        graph.get(14).add(new Edge(13, 3));

        int[] distances = dijkstra(graph, 0);

        System.out.println("Shortest distances from vertex 0:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }

        int src = 1;
		int dest = 5;

		int distance = djkstraForVertex(graph, src, dest);

		System.out.printf("Distance between %d %d is %d",src, dest, distance);
    }
}