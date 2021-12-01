import java.util.*;

public class Graph implements DirectedWeightedGraph{


HashMap<Integer,Node> Node_map;
HashMap<int[],Edge> Edge_map;


public Graph(){
    this.Node_map=new HashMap<Integer, Node>();
    this.Edge_map=new HashMap<int[],Edge>();
}


    @Override
    public NodeData getNode(int key) {
        return Node_map.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
    int arr[]={src,dest};
    //return Node_Edge.get(arr);
        return Node_map.get(src).Edges_in.get(arr);
    }

    @Override
    public void addNode(NodeData n) {
        Node x= (Node) n;
        Node_map.put(x.getKey(), x);
    }

    @Override
    public void connect(int src, int dest, double w) {
    Node dest1= Node_map.get(dest);
    Node src1= Node_map.get(src);
    Edge e=new Edge(w,"",0,dest1,src1);
    int arr[]={src,dest};
    Edge_map.put(arr,e);

    }

    @Override
    public Iterator<NodeData> nodeIter() {

        Iterator<Map.Entry<Integer, Node>> iter_node = Node_map.entrySet().iterator();
        while(iter_node.hasNext()){
            Map.Entry<Integer, Node> set = (Map.Entry<Integer, Node>) iter_node.next();
        }

        return null; /////***********//////////
    }


    @Override
    public Iterator<EdgeData> edgeIter() {
        Iterator<Map.Entry<int[], Edge>> iter_edge = Edge_map.entrySet().iterator();
        while(iter_edge.hasNext()){
            Map.Entry<int[], Edge> set = (Map.Entry<int[], Edge>) iter_edge.next();
        }
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
    Node_map.get(node_id);

        return null;
    }

    @Override
    public NodeData removeNode(int key) {
// go through the edges_in and for each in go to the other nodes out and delete the edge;
// go through the edges_out and for each out go to the other node in and delete the edge;
// clear this nodes in and out
// delete the node from the hashmap

Node v=Node_map.get(key);
    for(Map.Entry<int[],Edge> entry: v.Edges_in.entrySet()){
        Edge value = entry.getValue();
        int[] arr={value.getSrc(),key};
        Node_map.get(value.getSrc()).Edges_out.remove(arr);
        Edge_map.remove(arr);
        }
    for(Map.Entry<int[],Edge> entry: v.Edges_out.entrySet()){
        Edge value = entry.getValue();
        int[] arr={key, value.getDest()};
        Node_map.get(value.getDest()).Edges_in.remove(arr);
        Edge_map.remove(arr);
        }
    Node_map.get(key).Edges_in.clear();
    Node_map.get(key).Edges_out.clear();
    Node_map.remove(key);
        return null; //////*************///////////
    }





    @Override
    public EdgeData removeEdge(int src, int dest) {
        int [] arr={src, dest};
        Node dest1= Node_map.get(dest);
        Node src1= Node_map.get(src);
        dest1.Edges_in.remove(arr);
        dest1.Edges_out.remove(arr);
        src1.Edges_in.remove(arr);
        src1.Edges_out.remove(arr);
        return null;//////**************//////////
    }

    @Override
    public int nodeSize() {
        return Node_map.size();
    }

    @Override
    public int edgeSize() {
        return Edge_map.size();
    }

    @Override
    public int getMC() {
        return 0;
    }
}
