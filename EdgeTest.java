import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EdgeTest {


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


    Edge e1=new Edge(3.55,s,t,n1,n2);
    Edge e2=new Edge(0.5,s,t,n2,n1);
    Edge e3=new Edge(1.423,s,t,n3,n1);
    Edge e4=new Edge(0,s,t,n4,n2);
    Edge e5=new Edge(6.54,s,t,n4,n3);




    @Test
    void add_to_maps() {
        boolean ans1= n1.Edges_in.containsValue(e2);
        assertTrue(ans1);
        boolean ans2= n1.Edges_out.containsValue(e1);
        assertTrue(ans2);
        boolean ans3= n1.Edges_in.containsValue(e5);
        assertFalse(ans3);


    }

    @Test
    void getDest1() {
        assertEquals(n2.getKey(),e1.getDest());
    }

    @Test
    void getSrc1() {
        assertEquals(n1.getKey(),e1.getSrc());
    }

    @Test
    void getName() {
        List<Integer> l=new ArrayList<Integer>();
        l.add(1);
        l.add(0);
        assertEquals(l,e2.getName());
    }

    @Test
    void getSrc() {
        assertEquals(n4,e4.getSrc1());
    }

    @Test
    void getDest() {
        assertEquals(n3,e5.getDest1());
    }

    @Test
    void getWeight() {
        assertEquals(0.5,e2.getWeight());
    }

    @Test
    void getInfo() {
        assertEquals(s,e3.getInfo());
    }

    @Test
    void setInfo() {
        e3.setInfo("hi");
        assertEquals("hi",e3.getInfo());
    }

    @Test
    void getTag() {
        assertEquals(0,e5.getTag());
    }

    @Test
    void setTag() {
        e5.setTag(5);
        assertEquals(5,e5.getTag());
    }
}