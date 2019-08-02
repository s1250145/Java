public class FinallyClause {
	
    static int count = 0;
    public static void main(String[] args) {
    	
        while (true) {
            try {
                if (++count == 2) throw new Exception();
                if (count == 3) break;
                System.out.println("(" + count + ") No exception");
            }catch (Exception e) {
                System.out.println("(" + count + ") Exception occurred");
            }finally {
                System.out.println("(" + count + ") in finally clause");
            }
        }
        
    System.out.println("Main program ends");
    }
}

/*
 * 1.  Why does the program print the two lines below?
 * (2) Exception occurred
 * 	Answer: countの値が2になり例外処理が発生したため
 * (2) in finally clause
 * 	Answer: finallyは必ず実行されるメソッドであるから
 * 
 * 2. Why does the program print the line below (It looks like the program does not print the line becuase of the break statement)?
 * (3) in finally clause
 * 	Answer: countの値が3でbreakしたので、それ以降の処理は実行せず、必ず実行されるfinallyの実行がされたから
 * 
 * 3. Why does the program print the line below?
 * Main program ends
 * 	Answer: countの値が3になり、breakされてwhile文から抜けたために最後の出力の部分が実行された
*/
