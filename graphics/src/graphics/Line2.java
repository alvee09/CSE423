package graphics; 
import java.io.File;
import java.util.Scanner;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
//import java.util.*;
//import java.io.*;
public class Line2 implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    static double x1=0;
    static double x2=0;
    static double y1=0;
    static double y2=0;
    static Scanner sc= new Scanner(System.in);
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Line2 l = new Line2();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
	   double x= 0;
	   double y= 0;
	   try {
		   File file= new File("slopepoints.txt");
		   sc= new Scanner(file);
		   for(int i=0;i<10; i++)
		   {
			   final GL2 gl = drawable.getGL().getGL2();
			   gl.glBegin (GL2.GL_POINTS);//static field
			   
			   x1= -100 + (double)(Math.random() * ((100 - (-100)) + 100));
			   System.out.println(x1);
			   y1= -100 + (double)(Math.random() * ((100 - (-100)) + 100));
			   //System.out.println(y1);
			   x2= -100 + (double)(Math.random() * ((100 - (-100)) + 100));
			   y2= -100 + (double)(Math.random() * ((100 - (-100)) + 100));
					   
			   if(x1>x2 || y1>y2)
			   {
				   double temp = x1;
				   x1= x2;
				   x2= temp;
				   double temp2= y1;
				   y1= y2;
				   y2= temp2;
			   }
			   x= x1/100;
			   System.out.println(x);
			   y =y1/100;
			   gl.glVertex2d(x,y);
			   gl.glEnd();
			   
			
			   
				   double dx= x2-x1;
				   double dy= y2-y1;
				   double m = dy/dx;
				   //System.out.println(m);
				   if(m>=-1 && m<=1)
				   {
					   for(;x1<x2; x1++)
					   {
						   y1= y1+m;
						   
						   x= x1/100;
						   System.out.println("first while");
						   y =y1/100;
						   gl.glVertex2d(x,y);
						   gl.glEnd();
					   }
					   
				   }
				   else
				   {
					   for(;y1<y2; y1++)
					   {
						   x1= x1+(1/m);
						   x= x1/100;
						   //System.out.println(x);
						   y =y1/100;
						   gl.glVertex2d(x,y);
						   gl.glEnd();
					   }
					   
				   }
			   
			   //x= (x1-100)/100;
			   //y =(y1-100)/100;
			   //gl.glVertex2d(x1,y1);
			   //gl.glEnd();
			  
		   }
	   }
	   catch(Exception e)
	   {
		   System.out.println("file not found");
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
