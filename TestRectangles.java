public class TestRectangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1= new Rectangle(1,2,4,4);
		Rectangle r2= new Rectangle(1,2,4,3);
		Rectangle r3= new Rectangle(1,2,4,4);
		Rectangle r4= new Rectangle(1,2,4,4);
		
		System.out.println(r1.toString());
		System.out.println(r1.area());
		System.out.println(r1.areSquares(r1,r2,r3,r4));
	}

}
