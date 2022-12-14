package demo;

public class Item {

    //static: shared by all classes instances, static is attribute assigned method or member that you want to share across all instances. static member/methods can be used without initialisation. Dont need to instantiate to use static members.
    // if not static, need to instantiate a class first (new) than 
    
    private static Item item = null;

    public static Integer quantity;
    public String name;

    public static void printQuantity() {
        System.out.printf(">>> the quantity is %d\n", quantity);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { Item.quantity = quantity; }

    public static Item create() {
        if (null == item)
            item = new Item();
        return item;
    }
    
     //static method: to use method without instantiation

}
