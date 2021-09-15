import java.util.ArrayList;

public class Donut {
// instance variables

    private Size size;
    private Flavor flavor;
    private Icing icing;
    private Topping topping;

    //Default constructor
    public Donut() {
        size = Size.REGULAR;
        flavor = Flavor.OLD_FASHIONED;
        topping = Topping.NONE;
        icing = Icing.NONE;
    }

    //parameter constructor
   public Donut(Size size) {
        this.size = size;
        flavor = Flavor.OLD_FASHIONED;
        topping = Topping.NONE;
        icing = Icing.NONE;
    }

    // gets size
    public Size getSize() {
        return size;
    }

    //gets flavor
    public Flavor getFlavor() {
        return flavor;
    }

    // gets icing
    public Icing getIcing() {
        return icing;
    }

    //gets topping
    public Topping getTopping() {
        return topping;
    }

    // sets size
    public void setSize(Size size) {
        this.size = size;
    }

    // sets flavor
    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    // sets icing
    public void setIcing(Icing icing) {
        this.icing = icing;
    }

    // sets topping
    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    //returns total customer info as string
    public String toString() {
        String result = "\n\t" + size + "\n\t" + flavor + "\n\t" + icing + "\n\t" + topping + "\n";
        return result;
    }
}
