class Shape{
    private String name;
    
    public Shape(String name){
        this.name = name;
    }
    public Shape(){
        name = "no name";
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return getClass().getName() + " " + name;
    }
}

class Circle extends Shape{ //円
    private int radius;
    private double perimeter;
    private double area;

    public Circle(int radius){
        this.radius = radius;
        perimeter = 0;
        area = 0;
    }
    public void calperimeter(){
        perimeter = radius * 2.0 * Math.PI;
    }
    public void calarea(){
        area = radius * radius * Math.PI;
    }
    public String toString(){
        return "perimeter: "+perimeter+" area: "+area;
    }
    
    public String equals(Shape obj) {
    		if(obj == null) {
    			return "No";
    		}else if(getClass() == obj.getClass()) {
    			return "Yes";
    		}else {
    			return "No";
    		}
    }
}

class Rectangle extends Shape{ //長方形
    private int tate;
    private int yoko;
    private int perimeter;
    private int area;

    public Rectangle(int tate,int yoko){
        this.tate = tate;
        this.yoko = yoko;
        perimeter = 0;
        area = 0;
    }
    public Rectangle(int side){
        this.tate = side;
        yoko = side;
    }
    public void calperimeter(){
        perimeter = 2*tate + 2*yoko;
    }
    public void calarea(){
        area = tate*yoko;
    }
    public int getPerimeter(){
        return perimeter;
    }
    public int getArea(){
        return area;
    }
    public String toString(){
        return "perimeter: "+perimeter+" area: "+area;
    }
    public String equals(Shape obj) {
		if(obj == null) {
			return "No";
		}else if(getClass() == obj.getClass()) {
			return "Yes";
		}else {
			return "No";
		}
    }

}

class Square extends Rectangle{ //正方形

    public Square(int side){
        super(side);
    }
    public void  calculate(){
       super.calperimeter();
       super.calarea();
    }
    public String toString(){
        return "perimeter: "+super.getPerimeter()+" area: "+super.getArea();
    }
    public String equals(Shape obj) {
		if(obj == null) {
			return "No";
		}else if(getClass() == obj.getClass()) {
			return "Yes";
		}else {
			return "No";
		}
    }

}

class Parallelogram extends Shape{ //平行四辺形
    private double cos,sin;
    private int area,perimeter;
    private int tate,yoko,diagonal;

    public Parallelogram(int tate,int yoko,int diagonal){
        this.tate = tate;
        this.yoko = yoko;
        this.diagonal = diagonal;
        perimeter = 0;
        area = 0;
    }
    public void calculate(){
    		perimeter = 2*tate + 2*yoko;
    		
        cos = (double)(tate*tate + yoko*yoko - diagonal*diagonal) / (2*tate*yoko);
        sin = 1.0 - cos*cos;
        sin = Math.sqrt(sin);
        /*
         * "tate"と"yoko"にsinをかけてからキャストしないと、sinは1以下の値のため、sin自体をキャストすると0になるため、areaも0になってしまう
         */
        area = (int)(tate*yoko*sin);
    }
    public String toString(){
        return "perimeter: "+perimeter+" area: "+area;
    }
    public int getArea() {
    		return area;
    }
    public int getPerimeter() {
    		return perimeter;
    }
    public String equals(Shape obj) {
		if(obj == null) {
			return "No";
		}else if(getClass() == obj.getClass()) {
			return "Yes";
		}else {
			return "No";
		}
    }
}

class Rhombus extends Parallelogram{ //ひし形

    public Rhombus(int side,int diagonal){
        super(side,side,diagonal);
    }
    public String toString(){
        return "perimeter: "+super.getPerimeter()+" area: "+super.getArea();
    }
    public String equals(Shape obj) {
		if(obj == null) {
			return "No";
		}else if(getClass() == obj.getClass()) {
			return "Yes";
		}else {
			return "No";
		}
    }

}

public class TestFigures{
    public static void main(String[] args){
        Shape circle = new Shape("circle");
        Circle en = new Circle(3);
        en.calperimeter();
        en.calarea();
        System.out.println( circle.toString() +" "+ en.toString()+"\n");

        Shape rectangle = new Shape("rectangle");
        Rectangle abcd = new Rectangle(3,6);
        abcd.calperimeter();
        abcd.calarea();
        System.out.println( rectangle.toString() + " " + abcd.toString());
        System.out.println(circle.toString()+" and "+rectangle.toString()+" are same shape? Answer is "+abcd.equals(en)+"\n");

        Shape square = new Shape("square");
        Square box = new Square(3);
        box.calculate();
        System.out.println( square.toString() +" "+ box.toString() );
        System.out.println(rectangle.toString()+" and "+square.toString()+" are same shape? Answer is "+box.equals(rectangle)+"\n");

        Shape parallelogram = new Shape("parallelogram");
        Parallelogram heikou = new Parallelogram(3,4,5);
        heikou.calculate();
        System.out.println( parallelogram.toString() +" "+ heikou.toString() );
        System.out.println(rectangle.toString()+" and "+parallelogram.toString()+" are same shape? Answer is "+heikou.equals(abcd));
        System.out.println(square.toString()+" and "+parallelogram.toString()+" are same shape? Answer is "+heikou.equals(box)+"\n");

        Shape rhombus = new Shape("rhombus");
        Rhombus hisigata = new Rhombus(10,12);
        hisigata.calculate();
        System.out.println( rhombus.toString() +" "+ hisigata.toString() );
        System.out.println(square.toString()+" and "+rhombus.toString()+" are same shape? Answer is "+hisigata.equals(box));
        System.out.println(rectangle.toString()+" and "+rhombus.toString()+" are same shape? Answer is "+hisigata.equals(abcd));
        System.out.println(parallelogram.toString()+" and "+rhombus.toString()+" are same shape? Answer is "+hisigata.equals(heikou));
    }
}
