import static org.junit.jupiter.api.Assertions.*;

class GeoLocTest {
    GeoLoc g1=new GeoLoc(0.0,0.0,0.0);
    GeoLoc g2=new GeoLoc(-1.5,3.6,0.0);
    GeoLoc g3=new GeoLoc(2.55,-6.5,0.0);
    GeoLoc g4=new GeoLoc(12.61,0.0,0.0);

    @org.junit.jupiter.api.Test
    void x() {
        double ans=g2.x();
        assertEquals(-1.5,ans);
    }

    @org.junit.jupiter.api.Test
    void y() {
        double ans=g3.y();
        assertEquals(-6.5,ans);
    }

    @org.junit.jupiter.api.Test
    void z() {
        double ans=g4.z();
        assertEquals(0.0,ans);
    }

    @org.junit.jupiter.api.Test
    void distance() {
        double eps=0.00001;

        double dist1=g1.distance(g2);
        boolean ans1= (dist1<=3.9+eps && dist1>=3.9-eps);
        assertTrue(ans1);

        double dist2=g2.distance(g3);
        boolean ans2= (dist2<=10.88175078+eps && dist2>=10.88175078-eps);
        assertTrue(ans2);

        double dist3=g3.distance(g4);
        boolean ans3= (dist3<=11.9772117+eps && dist3>=11.9772117-eps);
        assertTrue(ans3);

        double dist4=g4.distance(g1);
        boolean ans4= (dist4<=12.61+eps && dist4>=12.61-eps);
       assertTrue(ans4);

        double dist5=g1.distance(g4);
        boolean ans5= (dist5<=12.61+eps && dist5>=12.61-eps);
        assertTrue(ans5);

        assertEquals(dist5,dist4);

    }
}