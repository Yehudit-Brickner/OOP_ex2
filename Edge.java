


public class Edge implements EdgeData{

    int src;
    int dest;
    double weight;
    String info;
    int tag;
    Node dest1;
    Node src1;

    public Edge( double w, String str, int t,Node d,Node s) {
        this.src1=s; // not deep copy
        this.dest1=d; // not deep copy
        this.dest=d.getKey();
        this.src=s.getKey();
        this.weight=w;
        this.info=str;
        this.tag=t;

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
