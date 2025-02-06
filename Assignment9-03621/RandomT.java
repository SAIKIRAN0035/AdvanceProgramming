/*
Assignment 9(a)
* Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
 *
 * *  @author Saikiran Reddy Yarava
 * To display colorful triangles on the screen, the `Triangle` class is the primary class to use.
 * It also includes an executable method for the program.
 */
class Triangle {
    public void Screen() {
        System.out.println("Displays 500 randomly colored triangles on the screen: ");
         // Create an instance of a different class object.
       Triangle ob = new Triangle();
        ob.Screen();
    }
}
/**
 * 500 randomly colored triangles appear on the screen via this program.
 *  @author Saikiran Reddy Yarava
 */
public class RandomT extends JPanel {

   private static final int WIDTH = 1600;
    private static final int HEIGHT = 800;
    private static final int NUM_TRIANGLES = 500;

    private Random r = new Random();

    /**
     * Apply a random color pattern of triangles to the canvas.
     *
     * @param g The Graphics object for painting.
     */
    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); // Eliminate the earlier drawings

    for (int i = 0; i < NUM_TRIANGLES; i++) {
        // The triangle's vertices should have randomly generated coordinates.
        int x1 = r.nextInt(WIDTH);
        int y1 = r.nextInt(HEIGHT);
        int x2 = r.nextInt(WIDTH);
        int y2 = r.nextInt(HEIGHT);
        int x3 = r.nextInt(WIDTH);
        int y3 = r.nextInt(HEIGHT);

        // Generating  a random color for the triangle in the comibination of red, green & blue
        Color randomColor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));

        // Use the random color in  current graphics environment.
        g.setColor(randomColor);

        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};
        int numPoints = 3; 
        // Number of vertices in the polygon (triangle)

        
        g.fillPolygon(xPoints, yPoints, numPoints);
    }
}
    /**
     * Main method to start the program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
    // Create a JFrame (window) with a title
    JFrame f = new JFrame("Random 500 Triangles");

    //Instantiate a RandomT class object, which serves as a JPanel for rendering triangles.
    RandomT rTriangles = new RandomT();

    // Increase the JFrame's panel size.
    f.add(rTriangles);
    f.setSize(WIDTH, HEIGHT);
   // Configure the default closure operation to close the window and end the application.
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
}
}

