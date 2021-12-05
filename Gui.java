import javax.swing.*;
import java.awt.*;


public class Gui extends JFrame{

    public Gui() {
        super();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;
        this.setTitle("Najeeb and Yehudit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(screenWidth/2,screenHeight/2);

        ImageIcon image= new ImageIcon("green fade.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(65, 196, 166));

        JMenuBar mb=new JMenuBar();

        JMenu vertex=new JMenu("vertex");
        JMenuItem addNode=new JMenuItem("add vertex");
        JMenuItem removeNode=new JMenuItem("remove vertex");
        JMenuItem nodeSize=new JMenuItem("number of vertexes");
        vertex.add(addNode);
        vertex.add(removeNode);
        vertex.add(nodeSize);

        JMenu edge=new JMenu("edge");
        JMenuItem Connect=new JMenuItem("add edge");
        JMenuItem removeEdge=new JMenuItem("remove edge");
        JMenuItem edgeSize =new JMenuItem("number of edges");
        edge.add(Connect);
        edge.add(removeEdge);
        edge.add(edgeSize);

        JMenu graph=new JMenu("graph");
        JMenuItem isConected=new JMenuItem("isConected");
        JMenuItem shortestPath=new JMenuItem("shortest Path");
        JMenuItem shortestPathList=new JMenuItem("shortest Path list");
        JMenuItem center=new JMenuItem("center");
        JMenuItem tsp=new JMenuItem("tsp");
        JMenuItem save=new JMenuItem("save");
        JMenuItem load=new JMenuItem("load");
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
        this.add(mb);
        this.setJMenuBar(mb);


        this.setVisible(true);

    }
    public static void main(String[] args) {
Gui myGui=new Gui();


        /*
        Dimension screensize= Toolkit.getDefaultToolkit().getScreenSize();
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //j.setSize(500,500);
       // j.setSize(screensize);
        j.setSize(screensize.width/2,screensize.height/2);
        j.getContentPane().setBackground(new Color(65, 196, 166));
        j.setTitle("Najeeb and Yehudit");
        ImageIcon image= new ImageIcon("green fade.png");
        j.setIconImage(image.getImage());
       // JMenuBar mb=new JMenuBar();
       // JMenu file=new JMenu("File");
       // mb.add(file);
       // j.add(mb);




        j.setVisible(true);


    */
    }
}
