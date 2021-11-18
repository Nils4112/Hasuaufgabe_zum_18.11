/**
 * Klasse zur Repräsentation eines Rechtecks
 */
public class Rectangle {
	private int x;
	private int y;
	private int width;
	private int heigth;
	/**
	 * Konstruktor für Rechtecke, die keine Quadrate sind
	 * @param xInput initiales x
	 * @param yInput initiales y
	 * @param widthInput initiale width
	 * @param heightInput initiale height
	 */
	public Rectangle(int xInput, int yInput, int widthInput, int heightInput) 
	{
		if(ueberpruefe(xInput)&&ueberpruefe(yInput)&&ueberpruefe(heightInput)&&ueberpruefe(widthInput)) {
			this.x = xInput;
			this.y = yInput;
			this.width =widthInput;
			this.heigth = heightInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}
	}
	/**
	 * Konstruktor für Rechtecke, die Quadrate sind
	 * @param xInput initiales x
	 * @param yInput initiales y
	 * @param sidelengthInput initiale Seitenlaenge, setzt width und height
	 */
	public Rectangle ( int xInput , int yInput , int sidelengthInput ) 
	{
		if(ueberpruefe(xInput)&&ueberpruefe(yInput)&&ueberpruefe(sidelengthInput)) {
			this.x = xInput;
			this.y = yInput;
			this.width = sidelengthInput;
			this.heigth = sidelengthInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}
	}
	/**
	 * Erstellt ein neues Rechteck mit den selben Attributen, wie das übergebene Rechteck
	 * @param toCopy Das vorhandene Rechteck
	 * @return Das neue Rechteck mit den selben Attributen, wie toCopy
	*/
	public static Rectangle copy(Rectangle toCopy)
	{
		return new Rectangle(toCopy.getX(), toCopy.getY(), toCopy.getWidth(), toCopy.getHeigth());
	}
	/**
	 * Ueberprueft ob der uebergebene Input zulaessig ist
	 * @param Input zu ueberprüfender Input
	 * @return Boolean ob Input zulaessig ist
	 */
	private boolean ueberpruefe(int Input)
	{
		if(Input<0&&!(Input==(int)Input))
		{
			return false;
		}
		else
		{
			return true;
		} 
	}
	/**
	 * Getter für x
	 * @return x des Rechtecks
	*/
	public int getX()
	{	
		return this.x;
	}
	/**
	 * Setter für x
	 * @param xInput neuer Wert für x
	*/
	public void setX(int xInput)
	{
		if(ueberpruefe(xInput)){
			this.x = xInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	/**
	 * Getter für y
	 * @return y des Rechtecks
	*/
	public int getY()
	{
		return this.y;
	}
	/**
	 * Setter für y
	 * @param yInput neuer Wert für y
	*/
	public void setY(int yInput)
	{
		if(ueberpruefe(yInput)){
			this.y = yInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	/**
	 * Getter für width
	 * @return width des Rechtecks
	*/
	public int getWidth()
	{
		return this.width;
	}
	/**
	 * Setter für width
	 * @param widthInput neuer Wert für width
	*/
	public void setWidth(int widthInput)
	{
		if(ueberpruefe(widthInput)){
			this.width = widthInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	/**
	 * Getter für height
	 * @return height des Rechtecks
	*/
	public int getHeigth()
	{
		return this.heigth;
	}
	/**
	 * Setter für height
	 * @param heigthInput neuer Wert für height
	*/
	public void setHeigth(int heigthInput)
	{
		if(ueberpruefe(heigthInput)){
			this.heigth = heigthInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	/**
	 * Gibt zurück ob die Recktecke Quadrate sind
	 * @param rectangles Liste der zu ueberprüfenden Rechtecke
	 * @return true wenn alle uebergebenen Rechtecke Quadrate sind
	*/
	public static boolean areSquares(Rectangle ... rectangles)
	{
		boolean square= true;
		for(int i = 0; i<rectangles.length; i++) 
		{
			int hoehe= rectangles[i].getHeigth();
			int breite =rectangles[i].getWidth();
			if(!(hoehe== breite))
			{
				square = false;
			}
			
		}
		return square;
	}
	
	/**
	 * Gibt die Fläche des Rechtecks zurück
	 * @return berechnete Flaeche
	*/
	public int area()
	{
		int fArea = this.heigth*this.width;
		return fArea;
	}
	/**
	 * Gibt den Schnitt der übergebenen Rechtecke zurück
	 * @param rectangles Liste der Rechtecke
	 * @return neues Rechteck, das den Schnitt repraesentiert
	*/
	public static Rectangle intersection ( Rectangle ... rectangles )
	{
		int[] maxX = new int[rectangles.length];
		//x ermitteln 
		for(int i = 0; i<rectangles.length; i++) 
		{
			maxX[i]=rectangles[i].getX();
		}
		int X = Utils.max(maxX);
		//x ueberpruefen 
		for(int x = 0; x<rectangles.length; x++) 
		{
			if(!(X<rectangles[x].getX()+rectangles[x].getWidth()))
			{
				System.out.println("bin hier");
				return null;
			}
		}
		int[] minY = new int[rectangles.length];
		//y ermitteln 
		for(int y = 0; y<rectangles.length; y++) 
		{
			minY[y]=rectangles[y].getY();
		}
		int Y = Utils.min(minY);
		//y ueberpruefen 
		for(int i = 0; i<rectangles.length; i++) 
		{
			if(!(Y>rectangles[i].getY()-rectangles[i].getWidth()))
			{
				return null;
			}
		}
		int[] xWidth = new int[rectangles.length];
		for(int i = 0; i<rectangles.length; i++) 
		{
			xWidth[i]=rectangles[i].getX()+rectangles[i].width-X;
		}
		int xNew= Utils.min(xWidth);
		int[] yWidth = new int[rectangles.length];
		for(int i = 0; i<rectangles.length; i++) 
		{
			yWidth[i]=rectangles[i].getY()+rectangles[i].heigth-Y;
		}
		int yNew= Utils.min(yWidth);
		
		Rectangle r1 = new Rectangle(X,Y,xNew,yNew);
		return r1;
		
	}
	/**
	 * Gibt einen der Aufgabe entsprechenden String zurück
	 * @return String mit den Eckpunkten des Rechtecks gegen den Uhrzeigersinn
	 */
	public String toString()
	{
		int xWidth= (this.x+this.width);
		int yHeigth =this.y-this.heigth;
		return "("+this.x+"|"+this.y+"),("+this.x+"|"+yHeigth+"),("+xWidth+"|"+yHeigth+"),("+xWidth+"|"+this.y+")";	
	}
	
}
