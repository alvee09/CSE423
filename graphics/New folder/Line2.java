package graphics;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.util.Scanner;
import java.io.*;

public class Line2 implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    static BufferedReader sc;
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Line l = new Line();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("20 points from file");
	      //adding canvas to frame
	      

	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
	   System.out.println("here");
	   try {
		   FileReader f= new FileReader("coordinates.txt");
		   BufferedReader sc= new BufferedReader(f);
		   String line = sc.readLine();
		  
		   }
		   catch(Exception e)
		   {
			   System.out.println("file not found");
		   }
	   for(int i=0; i<20; i++)
	   {
		   final GL2 gl = drawable.getGL().getGL2();
		   gl.glBegin (GL2.GL_POINTS);//static field
		   		   
	   double x= readNextValue();
	   double y= readNextValue();
	   gl.glVertex2d(x,y);
	   gl.glEnd();
	   }
	   
	      //gl.glVertex2d(0.5f,0.5f);
          //gl.glVertex2d(0.5f,-0.5f);
          //gl.glVertex2d(-0.5f,0.5f);
          //gl.glVertex2d(-0.5f,-0.5f);
          //
          
      
   }
   public double readNextValue(){
	   try{
		   String line = sc.readLine();
		   while(line != null){
			   System.out.println(line);
			   double r=Double.parseDouble(line);
			   return r;
		   }
	   }
	   catch(Exception e)
	   {
		   
	   }
	   
	   
	   
	   
   }
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;


