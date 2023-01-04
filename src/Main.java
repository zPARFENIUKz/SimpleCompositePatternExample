import Composite.Containers.AbstractContainer;
import Composite.Containers.ClassicBoxes.ClassicCraftBox;
import Composite.Items.Clothes.Sweater;
import Composite.Items.DigitalTech.Laptop;
import Composite.Items.DigitalTech.Phone;
import Composite.Items.Item;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // creating first box (box1 {laptop, iphone})
        final Phone phone = new Phone("IPhone 14 Pro Max 256Gb Purple", 1000.0);
        final Laptop laptop = new Laptop("MacBook 13 pro 2022 512Gb Space Gray", 1000.0);
        final ClassicCraftBox box1 = (ClassicCraftBox) new AbstractContainer.Builder()
                .withContainer(new ClassicCraftBox())
                .addItem(laptop)
                .addItem(phone)
                .build();
        // creating second box (box2 {sweater})
        final Sweater sweater = new Sweater("Black Sweater XL", 29.99);
        final ClassicCraftBox box2 = (ClassicCraftBox) new AbstractContainer.Builder()
                .withContainer(new ClassicCraftBox())
                .addItem(sweater)
                .build();
        // comparing boxes in the another box
        final ClassicCraftBox finalBox = (ClassicCraftBox) new AbstractContainer.Builder()
                .withContainer(new ClassicCraftBox())
                .addContainer(box1)
                .addContainer(box2)
                .build();
        double totalPrice = finalBox.getPrice();
        final List<Item> itemList = finalBox.getItems();
        // Print info
        System.out.println("Information about order: ");
        itemList.forEach(System.out::println);
        System.out.printf("Total price: %.2f$\n", totalPrice);
    }
}
