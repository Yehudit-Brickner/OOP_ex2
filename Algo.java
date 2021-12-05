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


public class Algo implements DirectedWeightedGraphAlgorithms{

    public Graph myGraph;

public Algo(Graph g){
    this.myGraph = g;
}


    public Algo(String jsonName) {
        try {
            myGraph=new Graph(jsonName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void init(DirectedWeightedGraph g) {
        this.myGraph= (Graph) g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.myGraph;
    }


    @Override
    public DirectedWeightedGraph copy() {
        Graph g =new Graph();
        Iterator<NodeData> a = myGraph.nodeIter();
        while(a.hasNext()){
            g.addNode(a.next());
        }
        Iterator<EdgeData> b= myGraph.edgeIter();
        while(b.hasNext()){
            g.connect(b.next().getSrc(),b.next().getDest(),b.next().getWeight());
        }
        return g;
    }

    @Override
    public boolean isConnected() {
        Queue<NodeData> Short = new ArrayDeque<>();
        Iterator<NodeData> a1 = myGraph.nodeIter();
        while(a1.hasNext()){
            a1.next().setTag(0);
        }
        Iterator<NodeData> a = myGraph.nodeIter();
        Node nodi=null;
        if(a.hasNext()) {
            nodi = (Node) a.next();
        }
        tagchild(nodi);
        Iterator<NodeData> b = myGraph.nodeIter();
        while(b.hasNext()){
            if(b.next().getTag()!= 1)
                return  false;
        }
        Graph newG =   flipGraph(this.myGraph);
        Iterator<NodeData> c = myGraph.nodeIter();
        Node nody=null;
        if(c.hasNext()) {
            nody = (Node) c.next();
        }
        tagchild(nody);
        Iterator<NodeData> d = myGraph.nodeIter();
        while(d.hasNext()){
            if(d.next().getTag()!= 1)
                return  false;
        }
        return true;
    }
    public void tagchild(Node v){
        if (v.Edges_out.size()!=0 && v.getTag()!=1){
            v.tag=1;
            int key = v.getKey();
            Iterator < EdgeData> a = myGraph.edgeIter(key);
            while(a.hasNext()){
                int keys=a.next().getDest();
                Node v1= this.myGraph.Node_map.get(keys);
                tagchild(v1);
            }
        }
    }

    public Graph flipGraph( Graph myGraph){
        Graph newGraph=new Graph ();
        Node n1=null;
        Node n2=null;
        Edge e1=null;
        Iterator<NodeData> a = myGraph.nodeIter();
        while(a.hasNext()){
            n1=(Node)a.next();
            n1.Edges_out.clear();
            n1.Edges_in.clear();
            n1.setTag(0);
            newGraph.addNode(n1);
        }
        Iterator<EdgeData> b= myGraph.edgeIter();
        while(b.hasNext()){
            e1= (Edge) b.next();
            n1=e1.getSrc1();
            n2=e1.getDest1();
            newGraph.connect(n2.getKey(), n1.getKey(), e1.getWeight());
        }
        return newGraph;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        Graph g = new Graph(this.myGraph);
        Queue<NodeData> Short = new ArrayDeque<>();
        Short.add(myGraph.getNode(src));
        NodeData n1 = null;
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        double w1 = 0;
        double w2 = 0;
        while (!Short.isEmpty()) {
            NodeData v = Short.poll();
            Iterator <EdgeData> a = g.edgeIter(v.getKey());
            while (a.hasNext()) {
                Edge e=(Edge)a.next();
                Short.add(e.getDest1());
            }
            Iterator<NodeData> it1 = g.nodeIter();
            while (it1.hasNext()) {
                n1 = it1.next();
                if (n1.getKey() != src || n1.getKey() != dest) {
                    l1.clear();
                    l1.add(v.getKey());
                    l1.add(n1.getKey());
                    l2.clear();
                    l2.add(n1.getKey());
                    l2.add(dest);
                    l3.clear();
                    l3.add(v.getKey());
                    l3.add(dest);
                    if (g.Edge_map.get(l1) != null && g.Edge_map.get(l2) != null) {
                        w1 = g.Edge_map.get(l1).getWeight();
                        w2 = g.Edge_map.get(l2).getWeight();
                        if (g.Edge_map.get(l3) != null) {
                            if (w1 + w2 < g.Edge_map.get(l3).getWeight()) {
                                g.Edge_map.get(l3).setWeight(w1 + w2);
                            }
                        } else {
                            g.connect(v.getKey(), dest, w1 + w2);
                        }
                    }
                }
            }
        }
        List<Integer> l5 = new ArrayList<Integer>();
        l5.add(src);
        l5.add(dest);
        if (g.Edge_map.get(l5) != null) {
            return g.Edge_map.get(l5).getWeight();
        } else {
            return -1;
        }
    }
//
//        Queue<NodeData> Short = new ArrayDeque<>();
//        Short.add(myGraph.getNode(src));
//        HashMap<List<Integer>,Double> nod = new HashMap<List<Integer>,Double> ();
//        NodeData n1=null;
//        NodeData n2=null;
//        Iterator<NodeData> i1 = myGraph.nodeIter();
//        while(i1.hasNext()) {
//            n1 = i1.next();
//            Iterator<NodeData> i2 = myGraph.nodeIter();
//            while (i2.hasNext()) {
//                n2 = i2.next();
//                if (n1.getKey() != n2.getKey()) {
//                    List<Integer> l = new ArrayList<Integer>();
//                    l.add(n1.getKey());
//                    l.add(n2.getKey());
//                    if (myGraph.Edge_map.get(l) == null) {
//                        nod.put(l, Double.MAX_VALUE);
//                    } else {
//                        nod.put(l, myGraph.Edge_map.get(l).getWeight());
//                    }
//                }
//            }
//        }
//        while(!Short.isEmpty()){
//            NodeData v =  Short.poll();
//            Iterator <EdgeData> a = myGraph.edgeIter(v.getKey());
//            while (a.hasNext()) {
//                EdgeData e=a.next();
//                List<Integer> edge = new ArrayList<Integer>();
//                edge.add(e.getSrc());
//                edge.add(e.getDest());
//                HashMap<List<Integer>, Double> map = (HashMap<List<Integer>, Double>) nod.clone();
//                Iterator<List<Integer>> iter = map.keySet().iterator();
//                while (iter.hasNext()) {
//                    List<Integer> arr = new ArrayList<Integer>();
//                    arr = iter.next();
//                    if (arr.get(1) == v.getKey()) {
//                        List<Integer> l1 = new ArrayList<Integer>();
//                        if (nod.get(l1) > e.getWeight()) {
//                            nod.put(l1, e.getWeight());
//                            Short.add(myGraph.getNode(e.getDest()));
//                        }
//                    }
//                }
//            }
//        }
//        List <Integer> l1 = new ArrayList<Integer>();
//        l1.add(src);
//        l1.add(dest);
//        return nod.get(l1);
//    }//must return the smallest way by weight

    @Override
    public List<NodeData> shortestPath(int src, int dest) {

        Queue<NodeData> Short = new ArrayDeque<>();
        Short.add(myGraph.Node_map.get(src));
        HashMap<Integer,Double> nod = new HashMap<Integer,Double> ();
        HashMap<Integer,List<NodeData>> map_list=new HashMap<Integer,List<NodeData>>();
        Iterator<NodeData> e = myGraph.nodeIter();
        List<NodeData> Vs= new ArrayList<NodeData>();
        for(int i =0 ; i< nod.size();i++ )
            nod.put(e.next().getKey(), Double.MAX_VALUE);
        map_list.put(e.next().getKey(),Vs);
        Vs.add((Node) e.next());
        nod.put(src,0.0);

        while(!Short.isEmpty()){
            NodeData v =  Short.poll();
            Iterator <EdgeData> a = myGraph.edgeIter(src);
            while (a.hasNext()){
                EdgeData EDGE = a.next();
                if(nod.get(EDGE.getDest()) > nod.get(v.getKey())+ EDGE.getWeight()) {
                    nod.put(EDGE.getDest(), nod.get(v.getKey()) + EDGE.getWeight());
                    List<NodeData> Vs_new= new ArrayList<NodeData>();
                    List<NodeData> Vs_old= new ArrayList<NodeData>();
                    Vs_old=map_list.get(v.getKey());
                    for (int i=0;i<Vs_old.size();i++){
                        Vs_new.add(Vs_old.get(i));
                    }
                    Vs_old.clear();
                    Vs_old=map_list.get(EDGE.getDest());
                    for (int i=0;i<Vs_old.size();i++){
                        Vs_new.add(Vs_old.get(i));
                    }
                    map_list.put(EDGE.getDest(),Vs_new);
                    Short.add(myGraph.getNode(EDGE.getDest()));
                }
            }

        }
        return map_list.get(dest);
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
