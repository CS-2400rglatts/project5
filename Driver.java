package Y;

public class Driver {
    public Driver() {

    };

    public static void main(String args[]) {
        Graph graph = new Graph<>();
        //creating the vertexes
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        
       //creating the edges between them in order
        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("A", "E");
        graph.addEdge("B", "E");
        graph.addEdge("D", "G");
        graph.addEdge("E", "F");
        graph.addEdge("E", "H");
        graph.addEdge("G", "H");
        graph.addEdge("F", "C");
        graph.addEdge("F", "H");
        graph.addEdge("H", "I");
        graph.addEdge("C", "B");
        graph.addEdge("I", "F");


        //prints out breadth first and depth first traversal
        System.out.println("Breadth First Traversal: ");
        System.out.println(graph.getBreadthFirstTraversal("A"));
        System.out.println("\nDepth first Traversal: ");
        System.out.println(graph.getDepthFirstTraversal("A"));

    }
}
