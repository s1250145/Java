import java.util.Random;

public class CalculatingWorkingHours {
        public static void main(String[] args){
                Employee [] e;
                Random rand = new Random();
                e = new Employee[rand.nextInt(500)];
                
                for(int i=0; i<e.length; i++){
                        switch ( rand.nextInt(4) ){
                        case 0:
                                e[i] = new Regular(2000);
                                break;
                        case 1:
                                e[i] = new PartTime(1000);
                                break;
                        case 2:
                                e[i] = new Engineer(2500);
                                break;
                        case 3:
                                e[i] = new Manager(2900);
                                break;
                        }
                }
                
                for(int i=0; i<e.length; i++) {
                		e[i].generateNumberHours();
                		e[i].setH( e[i].getH() );
                		System.out.println("number of hours at work today: "+e[i].getH() );
                		System.out.println("hourly wage: "+e[i].getW() );
                		System.out.println("\tToday's payment: "+e[i].getDayPayment()+"\n");
                }
                
        }
}