import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class algoTest {



    GeoLoc g1=new GeoLoc(0.0,0.0,0.0);
    GeoLoc g2=new GeoLoc(-1.5,3.5,0.0);
    GeoLoc g3=new GeoLoc(2.5,-6.5,0.0);
    GeoLoc g4=new GeoLoc(12.5,0.0,0.0);
    GeoLoc g5=new GeoLoc(5,4.5,0.0);

    String s="";
    int t=0;

    Node n1=new Node(1,s,2,t,g1);
    Node n2=new Node(2,s,4,t,g2);
    Node n3=new Node(3,s,8,t,g3);
    Node n4=new Node(4,s,3,t,g4);
    Node n5=new Node(5,s,1,t,g5);






    @Test
    void init() {
    }

    @Test
    void getGraph() {
    }

    @Test
    void copy() {
    }

    @Test
    void isConnected() {
/*
        Graph gr1=new Graph();
        Algo a1=new Algo(gr1);
        a1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.addNode(n4);
        gr1.addNode(n5);
        gr1.connect(0,1,2);
        gr1.connect(1,3,1);
        gr1.connect(4,3,4);
        gr1.connect(4,2,1);
        gr1.connect(4,1,3);
        gr1.connect(1,2,3);
        gr1.connect(2,0,2);
        gr1.connect(3,4,1);
        boolean con=a1.isConnected();
        assertTrue(con);
        */
        /*
        Graph gr1 = new Graph();
        Algo b1 = new Algo(gr1);
        b1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.addNode(n4);
        gr1.addNode(n5);
        gr1.connect(5,1,0);
        gr1.connect(1,2,0);
        gr1.connect(2,3,0);
        gr1.connect(4,3,0);
        gr1.connect(4,5,0);
        gr1.connect(2,5,0);
        gr1.connect(4,2,0);
        gr1.connect(2,4,0);
        gr1.connect(3,1,0);
        boolean con = b1.isConnected();
        assertTrue(con);
         */

        try {
            Graph gr2=new Graph("G1.json");
            Algo b2=new Algo(gr2);
            b2.init(gr2);
            boolean con2=b2.isConnected();
            assertTrue(con2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Graph gr2=new Graph("G2.json");
            Algo b2=new Algo(gr2);
            b2.init(gr2);
            boolean con2=b2.isConnected();
            assertTrue(con2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Graph gr2=new Graph("G3.json");
            Algo b2=new Algo(gr2);
            b2.init(gr2);
            boolean con2=b2.isConnected();
            assertTrue(con2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    void tagchild() {
    }

    @Test
    void flipGraph() {
        Graph gr1=new Graph();
        Algo a1=new Algo(gr1);
        a1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.connect(0,1,0);
        gr1.connect(1,2,0);
        gr1.connect(2,0,0);

        Graph gr2=new Graph();
        Algo a2=new Algo(gr2);
        a2.init(gr2);
        gr2.addNode(n1);
        gr2.addNode(n2);
        gr2.addNode(n3);
        gr2.connect(0,2,0);
        gr2.connect(2,1,0);
        gr2.connect(1,0,0);
        Graph gr3=a1.flipGraph(gr1);
        boolean flip= gr3.equals(gr2);
        System.out.println(flip);

    }



    @Test
    void Floyd_Warshall(){
        Graph gr1=new Graph();
        Algo a1=new Algo(gr1);
        a1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
       // gr1.addNode(n4);
        //gr1.addNode(n5);
      //  gr1.connect(5,1,1);
       // gr1.connect(5,4,1);
        gr1.connect(1,2,5);
        //gr1.connect(3,5,2);
        //gr1.connect(4,3,2);
       // gr1.connect(4,2,6);
       // gr1.connect(3,5,5);
        gr1.connect(3,1,3);
        gr1.connect(1,3,1);
        gr1.connect(3,2,2);
        HashMap<List<Integer>,Double> m=a1.Floyd_Warshall();
        gr1.addNode(n1);
    }




    @Test
    void shortestPathDist() {
        Graph gr1=new Graph();
        Algo a1=new Algo(gr1);
        a1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.addNode(n4);
        gr1.addNode(n5);
        gr1.connect(1,5,1);
        gr1.connect(5,4,1);
        gr1.connect(4,3,1);
        gr1.connect(3,2,1);
        gr1.connect(2,1,1);
        gr1.connect(4,5,5);
        gr1.connect(4,2,5);
        gr1.connect(5,3,6);
        gr1.connect(2,4,3);


        double ans1=a1.shortestPathDist(1,2);
        assertEquals(4,ans1);
        double ans2=a1.shortestPathDist(5,3);
        assertEquals(2,ans2);

    }

    @Test
    void shortestPath() {
        Graph gr1=new Graph();
        Algo a1=new Algo(gr1);
        a1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.addNode(n4);
        gr1.addNode(n5);
        gr1.connect(1,5,1);
        gr1.connect(5,4,1);
        gr1.connect(4,3,1);
        gr1.connect(3,2,1);
        gr1.connect(2,1,1);
        gr1.connect(4,5,5);
        gr1.connect(4,2,5);
        gr1.connect(5,3,6);
        gr1.connect(2,4,3);
        List<NodeData> l=new ArrayList<NodeData>();
        l.add(n1);
        l.add(n5);
        l.add(n4);
        l.add(n3);
        l.add(n2);
        List<NodeData> ans=a1.shortestPath(1,2);
        assertEquals(l,ans);
    }

    @Test
    void center() {
    }

    @Test
    void tsp() {
    }

    @Test
    void save() {
    }

    @Test
    void load() {
    }
}