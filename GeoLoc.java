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

    public GeoLoc (String s){
        int a = 0;
        int b=0;
        String x = "";
        String y ="";
        String z = "";
        int k=0;
        for (int i =0 ; i<2;i++){
            if(i==1)k++;
            while(s.charAt(k)!= ','){
                k++;
            }
            if(a==0){
                a=k;
            }else{
                b=k;
            }
        }
        x=s.substring(0,a);
        y=s.substring(a+1,b);
        z=s.substring(b+1,s.length());
        this.x_cor = Double.parseDouble(x);
        this.y_cor = Double.parseDouble(y);
        this.z_cor = Double.parseDouble(z);
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
