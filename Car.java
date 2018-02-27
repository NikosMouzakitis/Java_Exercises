 
public class Car {
    
    static double max_speed = 120.;
    static double min_speed = 0.;
    
    /*  Constructors    */
    public Car(int gear, double speed) {
        if( (speed >= 0.) && (speed <= max_speed) )
            this.speed = speed;
        else
            this.speed = 10;
        
        if( (gear >=1) && (gear <= 6) )
            this.gear = gear;
        else
            this.gear = 1;
    }
    
    public Car() {
        
        gear = 0;
        speed = 0.;
    }
    
    
    /*  Setters & Getters   */
    
    public void setGear(int val) {
        if( (val >=1) && (val <= 6) )
            gear = val;
    }
    
    public void setSpeed(int val) {
        
        if ( (val >= 0.) && (val <= max_speed) )
            speed = val;
    }
    
    
    public int getGear(){
        return gear;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    
    /*  Methods */
    public void speedUp() {
        speed +=5;
        if(speed > max_speed)
            speed = max_speed;
    }
    
    public void speedUp(int value) {
        speed += value;
        
        if(speed > max_speed)
            speed = max_speed;
    }
    
    public void slowDown() {
        speed -=5;
        if(speed < min_speed)
            speed = min_speed;
    }
    
    public void slowDown(int value) {
        speed += value;
        
        if(speed < min_speed)
            speed = min_speed;
    }
    
    
    public void GearUp() {
        
        gear += 1;
        if(gear > 6)
            gear = 6;
        
    }
    
    public void gearDown() {
        gear -=1;
        if(gear < 1)
            gear = 1;
    }
    
    private double speed;
    private int gear;
}
