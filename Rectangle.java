public class Rectangle {
	int x;
	int y;
	int width;
	int heigth;
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
	public static Rectangle copy(Rectangle toCopy)
	{
		Rectangle rec1= toCopy;
		return rec1;
	}
	private boolean ueberpruefe(int Input)
	{
		/**@param ueberprueft ob es ein zugelassener Input ist*/
		if(Input<0&&!(Input==(int)Input))
		{
			return false;
		}
		else
		{
			return true;
		} 
	}
	public int getX()
	{
		/**@param gibt x aus*/
		return this.x;
	}
	public void setX(int xInput)
	{
		/**@param verändert x*/
		if(ueberpruefe(xInput)){
			this.x = xInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	public int getY()
	{
		/**@param gibt y aus*/
		return this.y;
	}
	public void setY(int yInput)
	{
		/**@param verändert y*/
		if(ueberpruefe(yInput)){
			this.y = yInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	public int getWidth()
	{
		/**@param gibt width aus*/
		return this.width;
	}
	public void setWidth(int widthInput)
	{
		/**@param verändert width*/
		if(ueberpruefe(widthInput)){
			this.width = widthInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	public int getHeigth()
	{
		/**@param gibt heigth aus*/
		return this.heigth;
	}
	public void setHeigth(int heigthInput)
	{
		/**@param verändert heigth*/
		if(ueberpruefe(heigthInput)){
			this.heigth = heigthInput;
		}
		else
		{
			Utils.error("falscher Wert eingegeben");
		}	
	}
	public boolean areSquares(Rectangle ... rectangles)
	{
		/**@param überprüft ob die Recktecke Quadrate sind*/
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
	
	
	public int area()
	{
		/**@param die Fläche des Rechtecks*/
		int fArea = this.heigth*this.width;
		return fArea;
	}
	public Rectangle intersection ( Rectangle ... rectangles )
	{
		/**@param berechnet den Schnitt der Rechtecke*/
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
	public String toString()
	{
		/**@param erstellt einen der Aufgabe entsprechenden String*/
		int xWidth= (this.x+this.width);
		int yHeigth =this.y-this.heigth;
		return "("+this.x+"|"+this.y+"),("+this.x+"|"+yHeigth+"),("+xWidth+"|"+yHeigth+"),("+xWidth+"|"+this.y+")";	
	}
	
}
