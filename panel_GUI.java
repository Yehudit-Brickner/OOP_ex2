import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Scanner;


public class panel_GUI extends JPanel {

    Algo algo;

    panel_GUI(String s1) {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBackground(Color.BLACK);
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;
        this.setPreferredSize(new Dimension(screenWidth / 2, screenHeight / 2));

        //this.setPreferredSize(new Dimension(500, 500));
        // add try and catch for json
        this.algo = new Algo(s1);
    }
    public void paint(Graphics g) {
        this.setBackground(new Color(0,0,0));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screensize.height/2;
        int screenWidth =screensize.width/2;
        Graphics2D g2D = (Graphics2D) g;



        double [] arr=find_mins_maxs(this.algo);
        double x_differ=arr[1]-arr[0];
        double y_differ=arr[3]-arr[2];
        int r1=7;

        Iterator<NodeData> iter1 = algo.myGraph.nodeIter();
        while (iter1.hasNext()) {
            g2D.setPaint(Color.RED);
            Node n = (Node) iter1.next();
            double xx=n.geoloc.x();
            int x=change_cord_x(xx,x_differ,screenWidth,arr[0]);
            double yy=n.geoloc.y();
            int y=change_cord_y(yy,y_differ,screenHeight,arr[2]);
            g2D.fillOval(x-r1, y-r1, r1*2, r1*2);
            g2D.setFont(new Font("Ariel", Font.BOLD, 10));
            g2D.setPaint(Color.PINK);
            g2D.drawString("key: "+ n.getKey() , x+7,y+7 );
        }

        g2D.setPaint(Color.BLUE);
        int r2=1;
        g2D.setStroke(new BasicStroke(2*r2));
        Iterator<EdgeData> iter2 = algo.myGraph.edgeIter();
        while(iter2.hasNext()){
            Edge e=(Edge)iter2.next();
            g2D.setPaint(Color.BLUE);

            double xx1=e.getSrc1().geoloc.x();
            int x1=change_cord_x(xx1,x_differ,screenWidth,arr[0]);
            double yy1=e.getSrc1().geoloc.y();
            int y1=change_cord_y(yy1,y_differ,screenHeight,arr[2]);
            double xx2=e.getDest1().geoloc.x();
            int x2=change_cord_x(xx2,x_differ,screenWidth,arr[0]);
            double yy2=e.getDest1().geoloc.y();
            int y2=change_cord_y(yy2,y_differ,screenHeight,arr[2]);
            g2D.drawLine(x1-r2,y1-r2,x2-r2,y2-r2);
            g2D.setPaint(Color.GREEN);
            int xnew=(x1+x2)/2;
            int ynew=(y1+y2)/2;
            g2D.drawString("weight: "+e.getWeight(),xnew,ynew);

        }

    }


    public int change_cord_x(double x,double x_differ,int screenWidth,double minx){
   int x_cor=(int)(((x-minx)/x_differ)*(screenWidth-100));
        x_cor=x_cor+50;
        return x_cor;
    }
    public int change_cord_y(double y,double y_differ,int screenHeight,double miny){
        int y_cor=(int)(((y-miny)/y_differ)*(screenHeight-100));
        y_cor=y_cor+50;
        return y_cor;
    }




    public double[] find_mins_maxs(Algo algo) {
        double minx = Double.MAX_VALUE;
        double maxx = Double.MIN_VALUE;
        double miny = Double.MAX_VALUE;
        double maxy = Double.MIN_VALUE;
        double x;
        double y;
        Iterator<NodeData> iter1 = algo.myGraph.nodeIter();
        while (iter1.hasNext()){
            Node n=(Node)iter1.next();
            x=n.geoloc.x();
            y=n.geoloc.y();
            if(x<minx){
                minx=x;
            }
            if(x>maxx){
                maxx=x;
            }
            if(y<miny){
                miny=y;
            }
            if(y>maxy){
                maxy=y;
            }
        }
        double []arr={minx,maxx,miny,maxy};
        return arr;
    }

}


