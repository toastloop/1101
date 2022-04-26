/*
    Name: City
    Author Name: Matthew Knowlton
    Lab Number: 11
    Date: 25 April 2022
*/

public class City {

    /* Parameters  */
    private String name = "";
    private String state = "";
    private double size = 0.0;
    private int population = 0;
    private int elevation = 0;

    /* Constructors */
    public City(){

    }
    public City(String na){
        this.name = na;
    }
    public City(String na, String st, double  si, int pop, int elev){
        this.name = na;
        this.state = st;
        this.size = si;
        this.population = pop;
        this.elevation = elev;
    }

    /* Actions */
    public void getType(){
        if(this.population > 500000 && this.population  < 1000000){
            System.out.println("City");
        }
        else if(this.population >= 1000000  && this.population < 5000000){
            System.out.println("Medium City");
        }
        else if(this.population >= 5000000 && this.population < 10000000){
            System.out.println("Large City");
        }
        else if(this.population  > 10000000){
            System.out.println("Mega City");
        }
    }

    /* Getter/Accessors */
    public String getName(){
        return this.name;
    }
    public String getState(){
        return this.state;
    }
    public double getSize(){
        return this.size;
    }
    public int getPopulation(){
        return this.population;
    }
    public int getElevation(){
        return this.elevation;
    }

    /* Setter/Mutators */
    public void setName(String na){
        this.name = na;
    }
    public void setState(String st){
        this.state = st;
    }
    public void setSize(double si){
        this.size =  si;
    }
    public void setPopulation(int pop){
        this.population = pop;
    }
    public void setElevation(int elev){
        this.elevation = elev;
    }

}