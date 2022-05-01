import java.util.Iterator;

public class Graph<T> implements GraphInterface<T>{

  
/** breadth-first traversal */
public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
        
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);  // enqueue vertex label
        vertexQueue.enqueue(originVertex);  // enqueue vertex
        
        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            
            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }  // end if 
            }  // end while
        }  // end while
        return traversalOrder;
    }  // end getBreadthFirstTraversal
  
  
  
/** depth-first traversal */
 public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        //Assumes graph is not empty
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQue<T>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();
        
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);  // enqueue vertex label
        vertexStack.push(originVertex);  // enqueue vertex
        
        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnVisitedNeighbor();
            
            if (nextNeighbor != null)
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else //All neighbors are visited
                vertexStack.pop();
        } // end while
        
        return traversalOrder;
    }  // end getDepthFirstTraversal

}

