/*
Assignment Bonus
* Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SmileyMouth 
/*
    * Class: SmileyMouth
    * Author: Saikiran Reddy Yarava
    * Description: Represents the smiley mouth and provides methods for drawing.
    */
    {
    private int Width;
    private int Height;
    private int mouthX;
    private int mouthY;

    /**
     * Constructs a SmileyMouth with specified parameters.
     *
     * @param mouthWidth   Width of the mouth.
     * @param mouthHeight  Height of the mouth.
     * @param mouthX       X-coordinate of the mouth.
     * @param mouthY       Y-coordinate of the mouth.
     */
    public SmileyMouth(int Width, int Height, int mouthX, int mouthY) {
        this.Width = Width;
        this.Height = Height;
        this.mouthX = mouthX;
        this.mouthY = mouthY;
    }

    /**
     * Draws the SmileyMouth on the specified graphics context.
     *
     * @param graphics2d The graphics context on which to draw the SmileyMouth.
     */
    public void draw(Graphics2D graphics2d) {
        // Set the stroke width for the single thick line
        graphics2d.setStroke(new BasicStroke(10));
        graphics2d.setColor(Color.BLACK);
        // Draw the curved mouth with transparent border
        graphics2d.drawArc(mouthX, mouthY - 20, Width, Height, -35, -110);
    }
}

/**
 * Represents a JFrame with a smiley face having googly eyes and a smiley mouth.
 * @Author : Saikiran Reddy Yarava
 */
public class Bonus2 extends JFrame {
    private int eyeRadius = 35;
    private Point leftEye = new Point(140, 110);
    private Point rightEye = new Point(240, 110);
    private SmileyMouth smileyMouth = new SmileyMouth(160, 80, 110, 190);

    /**
     * Constructor for the SmileyFace class.
     * Sets the title, size, and default close operation for the JFrame.
     * Initializes a JPanel with overridden paintComponent method for custom drawing.
     */
    public Bonus2() {
      setTitle("Happy Face with Moving Eyes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel facePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D graphics2d = (Graphics2D) graphics;
                // face color
                graphics2d.setColor(Color.YELLOW);
                graphics2d.fillOval(40, 30, 300, 300);
                // left eye
                drawGooglyEye(graphics2d, leftEye);
                // right eye
                drawGooglyEye(graphics2d, rightEye);
                // the smiley mouth
                smileyMouth.draw(graphics2d);
            }

            /**
             * Draws a googly eye on the specified graphics context at the given position.
             *
             * @param graphics2d   The graphics context on which to draw the eye.
             * @param eyePosition  The position of the eye.
             */
            private void drawGooglyEye(Graphics2D graphics2d, Point eyePosition) {
                // Set the color to draw the eye white
                graphics2d.setColor(Color.WHITE);
                int eyeDiameter = eyeRadius * 2;
                // Adjust the Y-coordinate for the eye position
                int eyeY = eyePosition.y;
                // Draw the white part of the eye
                graphics2d.fillOval(eyePosition.x - eyeRadius, eyeY - eyeRadius, eyeDiameter, eyeDiameter);
                // Draw pupil
                Point pupilPosition = calculatePupilPosition(new Point(eyePosition.x, eyeY));
                int pupilRadius = 35;
                graphics2d.setColor(Color.BLACK);
                // Draw the pupil at the calculated position
                graphics2d.fillOval(pupilPosition.x - pupilRadius / 2, pupilPosition.y - pupilRadius / 2, pupilRadius, pupilRadius);
            }

            /**
             * Calculates the position of the pupil based on the mouse position.
             *
             * @param eyePosition  The position of the eye.
             * @return             The calculated position of the pupil.
             */
            private Point calculatePupilPosition(Point eyePosition) {
                Point mousePosition = getMousePosition();
                if (mousePosition == null) {
                    return eyePosition;
                }
                // Get the current mouse coordinates
                int mouseX = (int) mousePosition.getX();
                int mouseY = (int) mousePosition.getY();
                // Calculate the differences between the mouse and eye coordinates
                int deltaX = mouseX - eyePosition.x;
                int deltaY = mouseY - eyePosition.y;
                // Calculate the angle between the eye and mouse positions
                double angle = Math.atan2(deltaY, deltaX);
                int distance = Math.min(eyeRadius / 2, 35);
                // Calculate the new position of the pupil based on the angle and distance
                int pupilX = eyePosition.x + (int) (Math.cos(angle) * distance);
                int pupilY = eyePosition.y + (int) (Math.sin(angle) * distance);

                return new Point(pupilX, pupilY);
            }
        };

        /**
         * Adds a mouse motion listener to the face panel for tracking mouse movements.
         */
        facePanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Repaint the face panel on mouse movement to update the googly eyes
                repaint();
            }
        });

        add(facePanel);
    }

    /**
     * The main method to start the SmileyFace application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bonus2 happyFace = new Bonus2();
            happyFace.setVisible(true);
        });
    }
}
