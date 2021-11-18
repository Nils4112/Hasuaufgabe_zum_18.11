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
		return this.x;
	}
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
	public int getY()
	{
		return this.y;
	}
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
	public int getWidth()
	{
		return this.width;
	}
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
	public int getHeigth()
	{
		return this.heigth;
	}
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
	public boolean areSquares(Rectangle ... rectangles)
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
	
	
	public int area()
	{
		/**@param die Fläche des Rechtecks*/
		int fArea = this.heigth*this.width;
		return fArea;
	}
	public Rectangle intersection ( Rectangle ... rectangles )
	{
		int[] maxX = new int[rectangles.length-1];
		//x ermitteln 
		for(int i = 0; i<rectangles.length; i++) 
		{
			maxX[i]=rectangles[i].getX();
		}
		int X = Utils.max(maxX);
		//x ueberpruefen 
		for(int i = 0; i<rectangles.length; i++) 
		{
			if(!(X<rectangles[i].getX()-rectangles[i].getWidth()))
			{
				return null;
			}
		}
		int[] minY = new int[rectangles.length-1];
		//y ermitteln 
		for(int i = 0; i<rectangles.length; i++) 
		{
			minY[i]=rectangles[i].getY();
		}
		int Y = Utils.max(maxX);
		//y ueberpruefen 
		for(int i = 0; i<rectangles.length; i++) 
		{
			if(!(Y>rectangles[i].getY()-rectangles[i].getWidth()))
			{
				return null;
			}
		}
		//hier fehlen noch die höhe und breite des neuen Rechtecks
		return null;
	}
}
