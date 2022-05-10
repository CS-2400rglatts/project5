package Y;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Test;
/**
 * Unit testing for Graph.java
 */
public class Junit 

{
    @Test
    public void checkBreadthFirstTraversal()

    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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


        //prints out breadth first
        System.out.println("Breadth First Traversal: ");
        System.out.println(graph.getBreadthFirstTraversal("A"));
        

        
        assertEquals("ABCDEGFHCI", outContent.toString().trim());


    } 
    @Test
    public void checkDepthFirstTraversal()

    {
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


        //prints out depth first travesal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.out.println("\nDepth first Traversal: ");
        System.out.println(graph.getDepthFirstTraversal("A"));

        
       
        assertEquals("ABEFCHIDG", outContent.toString().trim());
    } 
    }

