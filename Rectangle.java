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
	public Rectangle copy(Rectangle toCopy)
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
}
