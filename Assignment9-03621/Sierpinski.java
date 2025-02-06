/*
Assignment 9(b)
* Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/
import javax.swing.*;
import java.awt.*;
import java.util.Random;

//Author : Saikiran Reddy Yarava
public class Sierpinski extends JPanel {
    // Constants for the width and height of the panel
public static final int WIDTH = 1024;
public static final int HEIGHT = 768;
    // Maximum number of iterations for drawing the Sierpinski Triangle

private static final int MAX_ITERATIONS = 50000;

// The starting coordinates of the triangle's vertices
private int x1 = 512, y1 = 109;
private int x2 = 146, y2 = 654;
private int x3 = 876, y3 = 654;
// Current position for drawing the Sierpinski Triangle
private int x = 512, y = 382;

/**
     * // Renders the Sierpinski Triangle on the panel:
     *
     * @param g The graphics object used for rendering.
     */
public void paintComponent(Graphics g) {
    // Render the text "Sierpinski Triangle" at position (462, 484) on the panel:

super.paintComponent(g);

g.drawString("Sierpinski Triangle", 462, 484);

int i = 0;
while (i < MAX_ITERATIONS) {
int random = new Random().nextInt(3) + 1;

int dx = 0, dy = 0;
if (random == 1) {
    // Determine the displacement between the current position and Vertex 1 (x1, y1):

dx = x - x1;
dy = y - y1;
} else if (random == 2) {
    // Determine the displacement between the current position and Vertex 2 (x2, y2):

dx = x - x2;
dy = y - y2;
} else {
    // Determine the displacement between the current position and Vertex 3 (x3, y3):

dx = x - x3;
dy = y - y3;
}
// Adjust the current position to the midpoint between the previous position and a vertex:
x = x - dx / 2;
y = y - dy / 2;
 // Draw a point at the updated (x, y) position
g.drawLine(x, y, x, y);

i++;

        }
    }


/**
     * Main method to create and display the JFrame.
     *
     * @param args Command line arguments (not used).
     */

public static void main(String[] args) {
JFrame frame = new JFrame("Sierpinski Triangle");
Sierpinski panel = new Sierpinski();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(WIDTH, HEIGHT);
frame.add(panel);
frame.setVisible(true);
}
}

/**
 *class represents the Sierpinski Triangle generator.
 //Author : Saikiran Reddy Yarava
 **/
 //Author : Saikiran Reddy Yarava
class Generator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        Sierpinski panel = new Sierpinski();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Sierpinski.WIDTH, Sierpinski.HEIGHT); 
        // Access constants from the Sierpinski class
        frame.add(panel);
        frame.setVisible(true);
    }
}




