import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class frameGui extends JFrame implements ActionListener {
    Algo algo;
    panel_GUI panel;
    JMenuBar mb;
    JMenu vertex,edge,graph;
    JMenuItem save,load,isConected,tsp,center,shortestPathList,shortestPath,connect,removeEdge,edgeSize,addNode,removeNode,nodeSize,makeList;

    public frameGui(String s1) {

        super();
        algo=new Algo(s1);

        ImageIcon image= new ImageIcon("green fade.png");
        this.setIconImage(image.getImage());
        this.setResizable(false);
        panel = new panel_GUI(s1);
        this.add(panel);
        this.pack();

        //  this.getContentPane().setBackground(new Color(65, 196, 166));
        // Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
       // int screenHeight = screensize.height;
        //int screenWidth = screensize.width;
        //this.setSize(screenWidth/2,screenHeight/2);



        this.setTitle("Najeeb and Yehudit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        //this.setLayout(new FlowLayout());
        //ImageIcon image= new ImageIcon("green fade.png");
       //this.setIconImage(image.getImage());
       this.getContentPane().setBackground(new Color(65, 196, 166));

        mb=new JMenuBar();

        vertex=new JMenu("vertex");
        edge=new JMenu("edge");
        graph=new JMenu("graph");




        addNode=new JMenuItem("add vertex");
        removeNode=new JMenuItem("remove vertex");
        nodeSize=new JMenuItem("number of vertexes");
        vertex.add(addNode);
        vertex.add(removeNode);
        vertex.add(nodeSize);


        connect=new JMenuItem("add edge");
        removeEdge=new JMenuItem("remove edge");
        edgeSize =new JMenuItem("number of edges");
        edge.add(connect);
        edge.add(removeEdge);
        edge.add(edgeSize);


        isConected=new JMenuItem("isConected");
        shortestPath=new JMenuItem("shortest Path");
        shortestPathList=new JMenuItem("shortest Path list");
        center=new JMenuItem("center");
        makeList=new JMenuItem("make list");
        tsp=new JMenuItem("tsp");
        save=new JMenuItem("save");
        load=new JMenuItem("load");
        graph.add(isConected);
        graph.add(shortestPath);
        graph.add(shortestPathList);
        graph.add(center);
        graph.add(tsp);
        graph.add(save);
        graph.add(load);

        mb.add(vertex);
        mb.add(edge);
        mb.add(graph);



        nodeSize.addActionListener(this);
        addNode.addActionListener(this);
        removeEdge.addActionListener(this);

        edgeSize.addActionListener(this);
        connect.addActionListener(this);
        removeEdge.addActionListener(this);


        isConected.addActionListener(this);
        shortestPath.addActionListener(this);
        shortestPathList.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        center.addActionListener(this);
        tsp.addActionListener(this);












        this.add(mb);
        this.setJMenuBar(mb);

        this.setVisible(true);


    }





 @Override
 public void actionPerformed(ActionEvent e) {
      if (e.getSource() == isConected) {
          boolean b = algo.isConnected();
          System.out.println("is the graph connected? " + b);
      }
      if (e.getSource() == shortestPath){
          System.out.println("mmmmmm");
          PopUp path=new PopUp();
          path.setVisible(true);
           //scan 2 numbers
           //double d=algo.shortestPathDist();
      }
      if (e.getSource() == shortestPathList) {

            //scan 2 numbers
            //double d=algo.shortestPath();
       }
       if(e.getSource()==center){
            NodeData n=algo.center();
            if(n!=null) {
                  System.out.println("the NOdeData in the middle of the graph is the node with key "+ n.getKey());
            }
            else{
                  System.out.println("this graph doesn't have a center ");
            }
       }
       if(e.getSource()==tsp){
           //make list
           // run algo on the list
        }
        if(e.getSource()==save){
             // get file name
             // run algo with the file name
        }
        if(e.getSource()==load){
         // get file name
         // run algo with the file name
       }
       if(e.getSource()==addNode){
        //algo.myGraph.addNode();
        //need to get the info

       }
       if(e.getSource()==removeNode){
        //algo.myGraph.addNode();
        //need to get the info
      }
      if(e.getSource()==nodeSize){
       int s=algo.myGraph.nodeSize();
       System.out.println("the number of Vertexes in the graph is " +s);

      }
      if(e.getSource()==connect){
       //algo.myGraph.addNode();
       //need to get the info

      }
      if(e.getSource()==removeEdge){
       //algo.myGraph.addNode();
       //need to get the info

      }
      if(e.getSource()==edgeSize){
       int s=algo.myGraph.edgeSize();
       System.out.println("the number of edges in the graph is " +s);

     }
    }


    public static void main(String[] args) {

        frameGui myGui=new frameGui("G2.json");

    }

}
