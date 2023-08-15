import java.util.ArrayList;

public class Kennel {

        private int capacity;
        private String size;
        private ArrayList<Wolf> wolves;

        public Kennel(ArrayList<Wolf> wolves,String size, String capacity) {
            this.capacity = Integer.parseInt(capacity);
            this.size = size;
            this.wolves = wolves;
        }
        public ArrayList<Wolf> getWolves(){
            return wolves;
        }
        public void setFruits(ArrayList<Wolf> wolves){
            this.wolves = wolves;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setColor(int capacity) {
            this.capacity = capacity;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public void displayInfo(){
            if(wolves.size() != 0){
                System.out.printf("Type->Kennel-> Size: %-10s \t\tCapacity: %s\n",size,capacity);
                for (Wolf wolf : wolves) {
                    System.out.print("\t\t");
                    wolf.displayInfo();
                }
            }else{
                System.out.printf("Type->Kennel-> Size: %-10s \t\tCapacity: %s\n",size,capacity);
            }
        }
    }

