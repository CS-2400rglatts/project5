/** 
      An interface of methods providing basic operations for directed
      and undirected graphs that are either weighted or unweighted. */

   public interface GraphInterface<T>
   {
     /** Adds an edge between two given vertices that are currently in this graph. 
         @param source  An object that labels the origin vertex of the edge.
         @param target  An object that labels the target vertex of the edge.
         @return  True if the edge is added, or false if not. */
     public boolean addEdge(T source, T target);
  
     /** Sees whether an edge exists between two given vertices.
         @param source  An object that labels the origin vertex of the edge.
         @param target  An object that labels the target vertex of the edge.
         @return  True if an edge exists. */
     public boolean isEdge(T source, T target);
     
     /** Remove an edge in this graph.
         @param source  An object that labels the origin vertex of the edge.
         @param target  An object that labels the target vertex of the edge. */
     public void removeEdge(int source, int target);
     
     /**
     * Obtain a list of neighbors of a specfied vertex of this graph.
     * @param vertex location to be accessed.
     * @return A list of vertex's neighbors
     */
    public int[] neighbors(int vertex);
  
     /** Sees whether this graph is empty.
         @return  True if the graph is empty. */
     public boolean isEmpty();
  
     /** Gets the label of vertices in this graph.
       @param vertex location to be accessed.
       @return  The label of vertex. */
    public T getLabel(int vertex);
  
      /** Set a vertex's label to a new label.
       @param vertex  the vertex of object.
       @param newLabel  the new label. */
    public void setLabel(int vertex, T newLabel);
  
     /**
     * Return the number of vertices in the graph.
     * @return The number of vertices.
     */
    public int size();
    
  } // end BasicGraphInterface 


