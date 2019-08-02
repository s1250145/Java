import java.util.Random;

class Manager extends Employee{
        Random rand = new Random();
        
        private int hour;
        
        public Manager(int w){
                super(w);
        }
        
        public void generateNumberHours(){
                hour = rand.nextInt(5)+6;
        }
        
        public void setH(){
                super.setH(hour);
        }
        
        public int getDayPayment(){
    			return super.getDayPayment();
        }
        
        public int getH(){
                return hour;
        }
}
