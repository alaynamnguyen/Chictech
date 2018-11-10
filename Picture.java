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
		Pixel[][] pixel = this.getPixels2D();
		for (int i = 0; i < pixel.length; i++) // Pixel[] rpwArrau: pixels
		{
			for (int i2 = 0; i2 < pixel[i].length; i2++) // Pixel pixel0bj: rowArray
			{
				int average = ((pixel[i][i2]).getRed() + (pixel[i][i2]).getBlue() + (pixel[i][i2]).getGreen())/3;
				pixel[i][i2].setRed(average);
				pixel[i][i2].setBlue(average);
				pixel[i][i2].setGreen(average);
			}
		}
	}


	public void Photoshop(Picture newPic)
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] greenScreen = newPic.getPixels2D();
		for (int row = 0; row < greenScreen.length; row++)
		{
			for (int col = 0; col < greenScreen[0].length; col++)
			{
				int rVal = greenScreen[row][col].getRed() +10;
				int bVal = greenScreen[row][col].getBlue() +10;
				int gVal = greenScreen[row][col].getGreen();
				
				if (gVal > rVal && gVal > bVal)
				{
					greenScreen[row][col].setColor(pixels[row][col].getColor());
				}
			}
		}
  }



} 
