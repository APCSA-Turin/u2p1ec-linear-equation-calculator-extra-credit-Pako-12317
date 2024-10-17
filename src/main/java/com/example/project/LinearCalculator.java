package com.example.project;
    
import java.text.DecimalFormat;

public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    public LinearCalculator(String coor1, String coor2){
     x1= Integer.parseInt(coor1.substring(coor1.indexOf("(")+1, coor1.indexOf(",")));
     x2= Integer.parseInt(coor2.substring(coor2.indexOf("(")+1, coor2.indexOf(",")));
     y1= Integer.parseInt(coor1.substring(coor1.indexOf(",")+1, coor1.indexOf(")")));
     y2= Integer.parseInt(coor2.substring(coor2.indexOf(",")+1, coor2.indexOf(")")));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int x){x1=x;}
    public void setY1(int y){y1=y;}
    public void setX2(int x){x2=x;}
    public void setY2(int y){y2=y;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.parseDouble(format.format(Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2))));
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, returns -999.99
    public double yInt(){
        DecimalFormat format = new DecimalFormat("#.##");
        if (slope()==-999.99){
            return -999.99;
        }else{
        return Double.parseDouble(format.format(y1-((double)x1*slope())));
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, returns -999.99
    public double slope(){
        DecimalFormat format = new DecimalFormat("#.##");
        if(x2==x1){
            return -999.99;
        }else{
        return Double.parseDouble(format.format(((double)y2-y1)/((double)x2-x1)));
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation returns -> "undefined"
    
    public String equation(){
        if(slope()==0&&yInt()==0){
            return "y=0";
        }else if(slope()==0){
            return "y="+yInt();
        }else if(yInt()==0){
            return "y="+slope()+"x";
        }else if(yInt()>=0){
            return "y="+slope()+"x+"+yInt();
        }else if(slope()==-999.99){
            return "undefined";
        }else{
            return "y="+slope()+"x"+yInt();
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        DecimalFormat format = new DecimalFormat("0.##");
        return Integer.parseInt(format.format(x));
    }

    //returns all information about the point and the equation together in one string
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: "+equation();
        str += "\nThe slope of this line is: "+slope();
        str += "\nThe y-intercept of the line is: "+yInt();
        str += "\nThe distance between the two points is: "+distance();
        str += "\n"+findSymmetry();
        str += "\n"+Midpoint();
 
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method determine if there is symmetry between the two points
    public String findSymmetry(){
        if(yInt()==0){
            return "Symmetric about the origin";
        }else if(slope()==-999.99){
            return "Symmetric about the x-axis";
        }else if(slope()==0){
            return "Symmetric about the y-axis";
        }else{
            return "No symmetry";
        }
    }

    //Midpoint()->return a string 
    //the method calculate the midpoint between the two points
    public String Midpoint(){
        double x=((double)x2+x1)/2;
        double y=((double)y2+y1)/2;
        return "The midpoint of this line is: ("+x+","+y+")";
    }

}
