import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Graph implements DirectedWeightedGraph{


HashMap<Integer,Node> Node_map;
HashMap<List<Integer>,Edge> Edge_map;



    public Graph(String jsonName) throws ParseException {
        Node_map = new HashMap<>();
        Edge_map = new HashMap<>();
        String filename = jsonName;
        try {
            JSONObject jsonObject = parseJSONFile(filename);
            JSONArray vertex = jsonObject.getJSONArray("Nodes");
            JSONArray edges = jsonObject.getJSONArray("Edges");
            saveJson(vertex, edges);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);
    }
    //must use the json file on and add the details in.


    public void saveJson(  JSONArray nodes,JSONArray edges) {
        for (int i =0; i< nodes.length();i++){
            Integer key = nodes.getJSONObject(i).getInt("id");
            String a =nodes.getJSONObject(i).getString("pos");
            GeoLoc p = new GeoLoc(a);
            Node b = new Node(key,"",0,0,p);
            this.Node_map.put(key,b);
        }
        for (int i =0 ; i< edges.length();i++){
            Integer src = edges.getJSONObject(i).getInt("src");
            Double w = edges.getJSONObject(i).getDouble("w");
            Integer dest = edges.getJSONObject(i).getInt("dest");
            Edge a = new Edge(w,"",0,Node_map.get(src),Node_map.get(dest));
            List<Integer> l1=new ArrayList<Integer>();
            l1.add(src);
            l1.add(dest);
            this.Edge_map.put(l1,a);
           /*
            if(this.Edge.containsKey(src)){
                this.Edges.get(src).put(dest,a);
            }else{
                this.Edges.put(src,new HashMap<>());
                this.Edges.get(src).put(dest,a);
            }
            */
        }
    }



public Graph(){
    this.Node_map=new HashMap<Integer, Node>();
    this.Edge_map=new HashMap<List<Integer>,Edge>();
}
public Graph(Graph g){
    this.Node_map=g.Node_map;
    this.Edge_map=g.Edge_map;
}

    @Override
    public NodeData getNode(int key) {
        return(NodeData) Node_map.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
    List<Integer>l=new ArrayList<Integer>();
    l.add(src);
    l.add(dest);
    return (EdgeData) Edge_map.get(l);
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
        List<Integer>l=new ArrayList<Integer>();
        l.add(src);
        l.add(dest);
  //  int []arr={src,dest};
    if (Edge_map.get(l)!=null){
        Edge_map.get(l).setWeight(w);
    }
    else {
        Edge e = new Edge(w, "", 0, src1, dest1);
        Edge_map.put(l, e);
    }

    }

    @Override
    public Iterator<NodeData> nodeIter() {
        HashMap<Integer, NodeData> mapN=(HashMap<Integer, NodeData>)this.Node_map.clone();
        //Iterator<Map.Entry<Integer, Node>> iter_node = mapy.entrySet().iterator();
        Iterator<NodeData> iter_node=mapN.values().iterator();
        return iter_node;
    }


    @Override
    public Iterator<EdgeData> edgeIter() {
        HashMap<List<Integer>, EdgeData> mapE=(HashMap<List<Integer>, EdgeData>)this.Edge_map.clone();
        //Iterator<Map.Entry<int[], Edge>> iter_edge = Edge_map.entrySet().iterator();
        Iterator<EdgeData> iter_edge=mapE.values().iterator();
        return iter_edge;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        HashMap<List<Integer>, EdgeData> mapNE=(HashMap<List<Integer>, EdgeData>)this.Node_map.get(node_id).Edges_out.clone();
        Iterator<EdgeData> iter_node_edge=mapNE.values().iterator();

        return iter_node_edge;
    }

    @Override
    public NodeData removeNode(int key) {
// go through the edges_in and for each in go to the other nodes out and delete the edge;
// go through the edges_out and for each out go to the other node in and delete the edge;
// clear this nodes in and out
// delete the node from the hashmap

Node v=this.Node_map.get(key);
    for(Map.Entry<List<Integer>,Edge> entry: v.Edges_in.entrySet()){
        Edge value = entry.getValue();
        List<Integer>l=new ArrayList<Integer>();
        l.add(value.getSrc());
        l.add(key);
        this.Node_map.get(value.getSrc()).Edges_out.remove(l);
        this.Edge_map.remove(l);
        }
    for(Map.Entry<List<Integer>,Edge> entry: v.Edges_out.entrySet()){
        Edge value = entry.getValue();
       // int[] arr={key, value.getDest()};
        List<Integer>l=new ArrayList<Integer>();
        l.add(key);
        l.add(value.getDest());
        this.Node_map.get(value.getDest()).Edges_in.remove(l);
        this.Edge_map.remove(l);
        }
        this.Node_map.get(key).Edges_in.clear();
        this.Node_map.get(key).Edges_out.clear();
        this.Node_map.remove(key);
        return v;
    }





    @Override
    public EdgeData removeEdge(int src, int dest) {
       // int [] arr={src, dest};
        List<Integer>l=new ArrayList<Integer>();
        l.add(src);
        l.add(dest);
        Edge e=this.Edge_map.get(l);

        Node dest1= this.Node_map.get(dest);
        Node src1= this.Node_map.get(src);

        dest1.Edges_in.remove(l);
        dest1.Edges_out.remove(l);
        src1.Edges_in.remove(l);
        src1.Edges_out.remove(l);
        this.Edge_map.remove(l);
        return e;
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

    public static void main(String[] args) {
        GeoLoc g1=new GeoLoc(0.0,0.0,0.0);
        GeoLoc g2=new GeoLoc(-1.5,3.6,0.0);
        GeoLoc g3=new GeoLoc(2.55,-6.5,0.0);
        GeoLoc g4=new GeoLoc(12.61,0.0,0.0);

        String s="";
        int t=0;

        Node n1=new Node(0,s,2.5,t,g1);
        Node n2=new Node(1,s,3.98,t,g2);
        Node n3=new Node(2,s,8.1,t,g3);
        Node n4=new Node(3,s,2.654,5,g4);

        Graph gr1=new Graph();
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.addNode(n4);
        gr1.connect(0,1,3.55);
        gr1.connect(0,1,2);
        gr1.connect(1,2,1.256);
        gr1.connect(2,3,1.57);
        gr1.connect(3,0,5.64);
        gr1.connect(0,2,0.5);
        gr1.connect(0,3,1);
        gr1.removeNode(n1.getKey());
        gr1.removeEdge(2,3);


    }



}
