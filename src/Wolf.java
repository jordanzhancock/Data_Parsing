public class Wolf {
    private String furColor;
    private double weight;


    public Wolf(String type, String weight) {
        this.furColor = type;
        this.weight = Double.parseDouble(weight);
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void displayInfo(){
        System.out.printf("Type->Wolf-> Fur Color: %-12s \t\t Weight: %s\n", furColor,weight);
    }
}
