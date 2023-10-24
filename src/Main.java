



public class Main {
    public static void main(String[] args) {

        System.out.println("Adding Customer");
        CustomerControl cc = new CustomerControl();
        cc.createCustomer();
        cc.displayAll(cc.getCustomers());

    }
}