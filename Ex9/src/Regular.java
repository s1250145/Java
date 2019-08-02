import java.util.Random;

class Regular extends Employee{
        Random rand = new Random();

        private int hour;
        
        public Regular(int w){
                super(w);
        }
        
        public void generateNumberHours(){
                hour = rand.nextInt(1)+8;
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
