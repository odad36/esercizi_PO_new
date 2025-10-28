
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int width = 10;
        int height = 20;

        int newX = 5;
        int newY = 5;

        double area;
        double perimeter;

        Rectangle box = new Rectangle(x, y, width, height);
        box.setLocation(newX, newY);
        Rectangle box2 = new Rectangle(newX + 10 , newY, width, height);
        Rectangle box3 = new Rectangle(newX + 20, newY, width, height);
        Rectangle box4 = new Rectangle(newX + 30, newY, width, height);
        box.add(box2);
        box.add(box3);
        box.add(box4);
        area = box.getWidth() * box.getHeight();
        perimeter = box.getWidth()*2 + box.getHeight()*2;
        System.out.println(box);
        System.out.println(area);
        System.out.println(perimeter);

    }
}
