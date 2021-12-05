import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {


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


    @Test
    void addNode() {
        gr1.addNode(n1);
        gr1.addNode(n2);
       // assertEquals(n1,gr1.getNode(0));
       // assertEquals(n2,gr1.getNode(1));

    }


    @Test
    void getNode() {
        assertEquals(n2,gr1.getNode(1));

    }

    @Test
    void connect() {
        gr1.connect(0,1,3.524);
        gr1.connect(1,0,1.2);
    }

    @Test
    void getEdge() {
        Edge e1=new Edge(3.524,"",0,n1,n2);
        Edge e2=new Edge(1.2,"",0,n2,n1);
        assertEquals(e1,gr1.getEdge(0,1));
       // assertEquals(e2,gr1.getEdge(1,0));
    }




    @Test
    void nodeIter() {
    }

    @Test
    void edgeIter() {
    }

    @Test
    void testEdgeIter() {
    }

    @Test
    void removeNode() {
    }

    @Test
    void removeEdge() {
    }

    @Test
    void nodeSize() {
    }

    @Test
    void edgeSize() {
    }

    @Test
    void getMC() {
    }
}