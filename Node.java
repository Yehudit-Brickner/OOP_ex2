


public class Node implements NodeData{

    Integer key;
    String info;
    double weight;
    int tag;
    GeoLoc geoloc;



public Node(Integer k, String s, double w,int t, GeoLocation gl ){
    this.key=k; // this is the id of the node;
    this.info=s;
    this.weight=w;
    this.tag=t;
    this.geoloc= (GeoLoc) gl;

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
        return 0;
    }

    @Override
    public void setTag(int t) {

    }
}
