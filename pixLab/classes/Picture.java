import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture()
	{
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *          the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *          the height of the desired picture
	 * @param width
	 *          the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *          the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *          the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + " height "
				+ getHeight() + " width " + getWidth();
		return output;

	}
	
	public void grayscale()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				int ave = (pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen())
						/ 3;
				pixelObj.setBlue(ave);
				pixelObj.setRed(ave);
				pixelObj.setGreen(ave);
			}
		}
	}


	public void Photoshop(Picture newPic){
	  Pixel[][] newPixels = newPic.getPixels2D();
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 0; row < newPixels.length; row++){
	      for (int col = 0; col <= newPixels[0].length-1; col++){
	    	  
	    
	    	 int red = newPixels[row][col].getRed();
	    	 int green = newPixels[row][col].getGreen();
	    	 int blue= newPixels[row][col].getBlue();

	    	 if(green > red + 10 && green > blue + 10 ) {
	    		 newPixels[row][col].setColor(pixels[row][col].getColor());
    		 }
	      }
	 } 
  }



} 