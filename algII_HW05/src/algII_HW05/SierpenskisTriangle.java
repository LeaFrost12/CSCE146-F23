//Lea Frost
package algII_HW05;

import java.awt.*;
import javax.swing.*;
import java.util.*;
public class SierpenskisTriangle extends Canvas{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setSize(440,440);
		SierpenskisTriangle sp = new SierpenskisTriangle();
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		//create the black triangle background
		int[] x = {0, 200,400};
		int[] y = {400, 0, 400};
		g.fillPolygon(x, y, 3);
		//call draw triangle
		drawTriangle(0, 400, 400, g);
	}
	public void drawTriangle(int x0, int y0, int size,  Graphics g)
	{
		//cut the size in half each time
		int sub = size/2;
		//create triangle in the middle
		
		int[] x = {x0, x0+(size/2), x0 + size};
		int[] y = {y0, y0+(size), y0};
		g.setColor(java.awt.Color.white);
		g.fillPolygon(x, y, 3);
		//until the pixel limit (size) reaches 4, continue to call drawTriangle
		if(size >= 4)
		{
			
			//top triangle
			drawTriangle(x0+(sub/2), y0-sub, sub, g);
			//bottom left 
			drawTriangle(x0, y0, sub, g);
			//bottom right
			drawTriangle(x0+sub , y0, sub, g);
			
		}
	
		
	}

}