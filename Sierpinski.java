package zrandhawHWK5;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class Sierpinski extends JFrame
{
    protected static Graphics graphics;
    protected static int level;

    protected static final int SIZE = 243;

    public Sierpinski(int level)
    {      
        super("Sierpinski Carpet");
        this.level = level;
        setSize(SIZE, SIZE + 24);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }      

    //Is changing the method functions input parameter allowed?
    public static void drawSquare(Point p1, Point p2, int level, Graphics g)
    {      
        if (level == 0)
        {
            Polygon p = new Polygon();
            p.addPoint(p1.x, p1.y);
            p.addPoint(p1.x, p2.y);
            p.addPoint(p2.x, p2.y);
            p.addPoint(p2.x, p1.y);
            graphics.drawPolygon(p);
        }
        else
        {
            //Is the orientation correct???
            int aThird=(p2.y - p1.y)/3;

            Point p3 = new Point(p1.x, p1.y + aThird);
            Point p4 = new Point(p1.x, p2.y - aThird);
            Point p5 = new Point(aThird + p1.x, p2.y);
            Point p6 = new Point(p2.x - aThird, p2.y);

            Point p7 = new Point(p2.x , p2.y - aThird);
            Point p8 = new Point(p2.x , p1.y + aThird);
            Point p9 = new Point(p2.x - aThird , p1.y);
            Point p10 = new Point(p1.x + aThird , p1.y);

            Point p11 = new Point(p10.x,p3.y);
            Point p12 = new Point(p10.x,p4.y);
            Point p13 = new Point(p9.x,p3.y);
            Point p14 = new Point(p9.x,p4.y);

            drawSquare(p1, p11, level - 1, g);
            drawSquare(p3, p12, level - 1, g);
            drawSquare(p4, p5,  level - 1, g);
            drawSquare(p12, p6, level - 1, g);
            drawSquare(p14, p2, level - 1, g);
            drawSquare(p13, p7, level - 1, g);
            drawSquare(p9, p8,  level - 1, g);
            drawSquare(p10, p13,level - 1, g);
        }
    }
    @Override
    public void paint(Graphics g)
    {
        graphics=g;
        Point p1 = new Point(0, 24);
        Point p2 = new Point(SIZE, SIZE + 24);
        drawSquare(p1, p2, level, g);
    }
    public static void main(String [] args)
    {
        int level = Integer.parseInt(args[0]);
        Sierpinski s = new Sierpinski(level);   
    }
}