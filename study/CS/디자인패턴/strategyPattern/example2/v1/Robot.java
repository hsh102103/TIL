package strategyPattern.example2.v1;

public abstract class Robot {
    private String name;
    Robot(String name){
        this.name = name;
    };
    public String getName(){
        return name;
    };
    public abstract void attack();
    public abstract void move();

}
