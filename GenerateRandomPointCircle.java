public class GenerateRandomPointCircle {
    double radius; 
    double x_center;
    double y_center;
    public GenerateRandomPointCircle(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }
    
    public double[] randPoint() {
        double[] ans = new double[2];
        double len = Math.sqrt(Math.random())*radius;
        double degree = 2*Math.PI*Math.random();
        ans[0] = x_center+len*Math.cos(degree);
        ans[1] = y_center+len*Math.sin(degree);
        
        return ans;
    }
}
