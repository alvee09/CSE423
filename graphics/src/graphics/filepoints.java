package graphics;
import javax.media.opengl.GL2;
import java.util.*;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.io.*;

public class filepoints implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    static Scanner sc= new Scanner(System.in);
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   try {
		   File file= new File("coordinates.txt");
		   sc= new Scanner(file);
	   }
	   catch(Exception e)
	   {
		   System.out.println("file not found");
	   }
	      
	   		filepoints l = new filepoints();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("random points");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
	   //System.out.println("display start");
	   for(int i= 0; i<10; i++)
	   {
		   final GL2 gl = drawable.getGL().getGL2();
		   gl.glBegin (GL2.GL_POINTS);//static field
		   //System.out.println(i);
		   double x= readNextValue();
		   //System.out.println(x);
		   double y= readNextValue();
		   //System.out.println(y);
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
	   //try {
	   String s= sc.next();
	   //System.out.println(s);
	   double r=Double.parseDouble(s);
	   return r;
	   //}
	   //catch(Exception e)
	   //{
		//   System.out.println("end of file");
	   //}
	   
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
