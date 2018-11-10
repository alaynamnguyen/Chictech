public class PictureTester
{
  
	public static void testPhotoshop()
  {
	  Picture pisa = new Picture("Himalayan.jpg");
	  Picture caitlyn = new Picture("thicc.jpg");
	  
	  pisa.Photoshop(caitlyn);
	  caitlyn.explore();
	  pisa.explore();
	  caitlyn.explore();
  }
	
  public static void testGrayScale() {
  	Picture pisa = new Picture("Himalayan.jpg");
    pisa.grayscale();
    pisa.explore();
  	
  	
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    testPhotoshop();
    testGrayScale();
  }
}