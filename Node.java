import java.util.HashMap;
import java.util.List;

public class Node implements NodeData{

    Integer key;
    GeoLoc geoloc;
    double weight;
    String info;
    int tag;
    HashMap<List<Integer>,Edge> Edges_in;
    HashMap<List<Integer>,Edge> Edges_out;


public Node(Integer k, String s, double w,int t, GeoLocation gl ){
    this.key=k; // this is the id of the node;
    this.info=s;
    this.weight=w;
    this.tag=t;
    this.geoloc= (GeoLoc) gl;
    this.Edges_in=new HashMap<List<Integer>, Edge>();
    this.Edges_out=new HashMap<List<Integer>, Edge>();
   }


    public Node(int id ,String s, double w,int t, GeoLoc g) {
        this.key = id;
        this.geoloc = g;
        this.tag = 0;
        this.weight = 0;
        this.info = s;
        this.Edges_in=new HashMap<List<Integer>, Edge>();
        this.Edges_out=new HashMap<List<Integer>, Edge>();
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.geoloc;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.geoloc= (GeoLoc) p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight=w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info=s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
    this.tag=t;
    }
}
