import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Problem_10 extends JPanel{
    private int depth = 5; //control the depth of recursion

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g,depth, 20,20,400);
    }
    private void draw (Graphics g, int depth, int x, int y, int size){
        if (depth == 0) {
            drawTriangle(g, x, y, size);
        } else {
            //  half-size for the smaller triangles
            int newSize = size / 2;

            // Top triangle
            draw(g, depth - 1, x + newSize / 2, y, newSize);

            // Bottom left triangle
            draw(g, depth - 1, x, y + newSize, newSize);

            // Bottom right triangle
            draw(g, depth - 1, x + newSize, y + newSize, newSize);
    }}
    private void drawTriangle(Graphics g, int x, int y, int size) {
        int[] xPoints = {x, x + size / 2, x + size};
        int[] yPoints = {y + size, y, y + size};
        g.drawPolygon(xPoints, yPoints, 3);
    }


    public static void main (String [] args){
        JFrame frame = new JFrame("Sierpinski Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 440); //swap to convert to vertical
        frame.setLocationRelativeTo(null);
        frame.add(new Problem_10());
        frame.setVisible(true);
    }
}
