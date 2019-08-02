import java.util.Random;

class PartTime extends Employee{
        Random rand = new Random();

        private int hour;
        
        public PartTime(int w){
                super(w);
        }
        
        public void generateNumberHours(){
                hour = rand.nextInt(4);
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
