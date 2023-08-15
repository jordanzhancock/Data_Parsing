public class Car {
    private double price;
    private String color;
    private int numberOfDoors;

    public Car(String price, String color, String numberOfDoors) {
        this.price = Double.parseDouble(price);
        this.color = color;
        this.numberOfDoors = Integer.parseInt(numberOfDoors);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void displayInfo(){
        System.out.printf("Type->Car-> Price: $%.2f \t Color: %s \t Doors: %d\n",price,color,numberOfDoors);
    }
}
