import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
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






    @Test
    void getKey() {
        assertEquals(0,n1.getKey());
    }

    @Test
    void getLocation() {
        GeoLoc g=new GeoLoc(2.55,-6.5,0.0);
        assertEquals(g.x(),n3.getLocation().x());
        assertEquals(g.y(),n3.getLocation().y());
        assertEquals(g.z(),n3.getLocation().z());
    }

    @Test
    void setLocation() {
        GeoLoc g=new GeoLoc(1,1,1);
        n2.setLocation(g);
        assertEquals(g,n2.getLocation());
    }

    @Test
    void getWeight() {
        assertEquals(2.5,n1.getWeight());
    }

    @Test
    void setWeight() {
        n1.setWeight(3);
        assertEquals(3,n1.getWeight());
    }

    @Test
    void getInfo() {
        assertEquals("",n1.getInfo());
    }

    @Test
    void setInfo() {
        n1.setInfo("hi");
        assertEquals("hi",n1.getInfo());
    }

    @Test
    void getTag() {
        assertEquals(5,n4.getTag());
    }

    @Test
    void setTag() {
        n4.setTag(1);
        assertEquals(1,n4.getTag());
    }
}