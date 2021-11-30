public class GeoLoc implements GeoLocation {
    double x_cor;
    double y_cor;
    double z_cor;

    public GeoLoc(double x, double y,double z){
        this.x_cor=x;
        this.y_cor=y;
        this.z_cor=z;
    }

    public GeoLoc(GeoLoc other){
        this.x_cor=other.x_cor;
        this.y_cor=other.y_cor;
        this.z_cor=other.z_cor;
    }




    @Override
    public double x() {
        return this.x_cor;
    }

    @Override
    public double y() {
        return this.y_cor;
    }

    @Override
    public double z() {
        return this.z_cor;
    }

    @Override
    public double distance(GeoLocation g) {
        return Math.sqrt(  (this.x_cor-g.x())*(this.x_cor-g.x())+((this.y_cor-g.y())*(this.y_cor-g.y()))+((this.z_cor-g.z())*(this.z_cor-g.z()))  );
    }
}
