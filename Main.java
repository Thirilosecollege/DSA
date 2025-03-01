import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> listOfProducts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. add product");
            System.out.println("2. remove product");
            System.out.println("3. update product");
            System.out.println("4. search product");
            System.out.println("5. list products");
            System.out.println("6. exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("product name: ");
                    String name = scanner.nextLine();
                    System.out.println("product price: ");
                    int price = scanner.nextInt();
                    System.out.println("product description: ");
                    scanner.nextLine(); 
                    String description = scanner.nextLine();
                    System.out.println("product quantity: ");
                    int quantity = scanner.nextInt();
                    add(name, price, description, quantity);
                    break;
                    
                case 2:
                    System.out.println("Enter the Product to be deleted:");
                    String x = scanner.nextLine();
                    for(Product item : listOfProducts){
                        if(item.getProductName().equalsIgnoreCase(x)){
                            remove(x);
                        }
                        else{
                             System.out.println("Not Found");
                        }
                    }
                    
                    break;
                    
                case 3:
                    System.out.println("Enter the product to be updated: ");
                    String nameOfProduct = scanner.nextLine();
                    System.out.println("Enter new product price: ");
                    int newPrice = scanner.nextInt();
                    System.out.println("Enter new product description: ");
                    scanner.nextLine(); 
                    String newDescription = scanner.nextLine();
                    System.out.println("Enter new product quantity: ");
                    int newQuantity = scanner.nextInt();
                    update(nameOfProduct, newPrice, newDescription, newQuantity);
                    break;
                    
                case 4: 
                    System.out.println("product name: ");
                    String findName = scanner.next();
                    for(Product product:listOfProducts){
                        if(product.getProductName().equalsIgnoreCase(findName)){
                            System.out.println("ID: " + product.getProductId());
                            System.out.println("Name: " + product.getProductName());
                            System.out.println("Price: " + product.getProductPrice());
                            System.out.println("Description: " + product.getProductDescription());
                            System.out.println("Quantity: " + product.getProductQuantity());
                        }
                        else{
                            System.out.println("Not Found");
                        }
                    }
                    
                    break;

                case 5:
                    printList();
                    break;

                case 6:
                    scanner.close();
                    return;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    private static void printList() {
        for (Product product : listOfProducts) {
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: " + product.getProductPrice());
            System.out.println("Description: " + product.getProductDescription());
            System.out.println("Quantity: " + product.getProductQuantity());
            System.out.println();
        }
    }

    public static void add(String name, int price, String description, int quantity) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size() + 1);
        listOfProducts.add(product);
    }

    public static void remove(String ProductName) {
        boolean removed = false;
        for(int i = 0;i < listOfProducts.size();i++){
            if(listOfProducts.get(i).getProductName().equalsIgnoreCase(ProductName)){
                listOfProducts.remove(i);
                System.out.println("Successfully removed "+ ProductName);
            }
        }
    }

    public static void update(String name, int price, String description, int quantity) {
        for (Product product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                product.setProductPrice(price);
                product.setProductDescription(description);
                product.setProductQuantity(quantity);
                System.out.println("Successfully updated " + name);
                return;
            }
        }
        System.out.println("Product not found.");

    }
}
