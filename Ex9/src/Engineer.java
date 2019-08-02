import java.util.Random;

class Engineer extends Employee{
        Random rand = new Random();

        private int hour;
        
        public Engineer(int w){
        		super(w);
        }
        
        public void generateNumberHours(){
        		hour = rand.nextInt(2)+8;
        }
        
        public void setH(){
                super.setH(hour);
        }
        
        public int getDayPayment(){
        		return super.getDayPayment();
        }
        
        public int getH() {
        		return hour;
        }
}
