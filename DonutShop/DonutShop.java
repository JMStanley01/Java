import java.util.ArrayList;

/****************************************************************************
 * DonutShop
 ****************************************************************************
 * Project description
 * Displays a customer's name and donut order
 * April 8th, 2020
 ****************************************************************************/
public class DonutShop {
    public static void main(String[] args) {
        ArrayList<Donut> donuts1 = new ArrayList<Donut>();
        ArrayList<Donut> donuts2 = new ArrayList<Donut>();
        Customer c1 = new Customer();
//Practice run with John Doe/ Jane Doe customers
        c1.setFirstName("John");
        c1.setLastName("Doe");
        c1.setEmail("JohnDoe123@email.com");
        c1.setPhone("123-456-7890");
        // c1.orderDonut();
        c1.getDonut();
        // c1.getNumDonut();
        Donut c1d1 = new Donut();
        c1d1.setFlavor(Flavor.CHOCOLATE);
        c1d1.setIcing(Icing.CHOCOLATE);
        c1d1.setSize(Size.REGULAR);
        c1d1.setTopping(Topping.SPRINKLES);
        c1.orderDonut(c1d1);
        System.out.println(c1.toString());
        System.out.println(c1d1.toString());
        Customer c2 = new Customer();
        c2.setFirstName("Jane");
        c2.setLastName("Doe");
        c2.setEmail("JaneDoe321@email.com");
        c2.setPhone("987-654-3210");
        // c2.orderDonut();
        c2.getDonut();
        //   c2.getNumDonut();
        Donut c2d1 = new Donut();
        c2d1.setTopping(Topping.CANDY);
        c2d1.setSize(Size.HOLE);
        c2d1.setIcing(Icing.NONE);
        c2d1.setFlavor(Flavor.VANILLA);
        c2.orderDonut(c2d1);
        Donut c2d2 = new Donut();
        c2d2.setFlavor(Flavor.OLD_FASHIONED);
        c2d2.setIcing(Icing.STRAWBERRY);
        c2d2.setSize(Size.LARGE);
        c2d2.setTopping(Topping.CANDY);
        c2.orderDonut(c2d2);
        System.out.println(c2.toString());
        System.out.println(donuts2);
        System.out.println();
    }
}
