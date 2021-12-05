import java.util.ArrayList;
import java.util.List;

public class Edge implements EdgeData{

    int src;
    int dest;
    double weight;
    String info;
    int tag;
    Node dest1;
    Node src1;
    List <Integer> name;

    public Edge( double w, String str, int t,Node s,Node d) {
        this.src1=s; // not deep copy
        this.dest1=d; // not deep copy
        this.dest=d.getKey();
        this.src=s.getKey();
        this.weight=w;
        this.info=str;
        this.tag=t;
        List <Integer> l=new ArrayList<Integer>();
        l.add(s.getKey());
        l.add(d.getKey());
        this.name=l;
        // adding the edge to the nodes hashmaps of edges
        add_to_maps(s.getKey(),d.getKey(),l);
    }
    public void add_to_maps(int src, int dest,List<Integer> l){
      if (l.get(0)==src){
            src1.Edges_out.put(l,this);
            dest1.Edges_in.put(l,this);
        }
        else {
            dest1.Edges_out.put(l, this);
            src1.Edges_in.put(l, this);
        }
    }

    public Node getDest1() {
        return dest1;
    }

    public Node getSrc1() {
        return src1;
    }

    public List<Integer> getName() {
        return this.name;
    }

    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double w){
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
