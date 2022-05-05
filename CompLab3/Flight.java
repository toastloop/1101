public class Flight {
    private String city = "";
    private String country = "";
    private Double oneWayCost = 0.0;
    private Double roundTripCost = 0.0;

    /**
     * Flight Constructor
     */
    public Flight(){}
    /**
     * Flight Constructor
     * @param city
     */
    public Flight(String city){
        this.city = city;
    }
    /**
     * Flight Constructor
     * @param city
     * @param country
     */
    public Flight(String city, String country){
        this.city =  city;
        this.country = country;
    }
    /**
     * Flight Constructor
     * @param city
     * @param country
     * @param oneWayCost
     */
    public Flight(String city, String country, Double oneWayCost){
        this.city = city;
        this.country = country;
        this.oneWayCost = oneWayCost;
    }
    /**
     * Flight Constructor
     * @param city
     * @param country
     * @param oneWayCost
     * @param roundTripCost
     */
    public Flight(String city, String country, Double oneWayCost, Double roundTripCost){
        this.city = city;
        this.country = country;
        this.oneWayCost = oneWayCost;
        this.roundTripCost = roundTripCost;
    }

    /**
     * Get city name
     * @return
     */
    public String getCity(){
        return this.city;
    }
    /**
     * Get country name
     * @return
     */
    public String getCountry(){
        return this.country;
    }
    /**
     * Get one way cost
     * @return
     */
    public Double getOneWayCost(){
        return this.oneWayCost;
    }
    /**
     * Get round trip cost
     * @return
     */
    public Double getRoundTripCost(){
        return this.roundTripCost;
    }

    /**
     * Set city name
     * @param city
     */
    public void setCity(String city){
        this.city = city;
    }
    /**
     * Set country name
     * @param country
     */
    public void setCountry(String country){
        this.country = country;
    }
    /**
     * Set one way cost
     * @param oneWayCost
     */
    public void setOneWayCost(Double oneWayCost){
        this.oneWayCost = oneWayCost;
    }
    /**
     * Set round trip cost
     * @param roundTripCost
     */
    public void setRoundTripCost(Double roundTripCost){
        this.roundTripCost = roundTripCost;
    }
}
