package checkpoint;

import checkpoint.discount.BEDiscountCondition;
import checkpoint.discount.CozDiscountCondition;
import checkpoint.discount.DiscountCondition;
import checkpoint.products.Product;
import checkpoint.products.ProductRepository;

import java.util.Scanner;

public class Kiosk {

    private ProductRepository productRepository = new ProductRepository();
//    private CozDiscountCondition cozDiscountCondition = new CozDiscountCondition(500);
//    private BEDiscountCondition beDiscountCondition = new BEDiscountCondition(20);
    private DiscountCondition discountCondition;

    public Kiosk(DiscountCondition discountCondition) {
        this.discountCondition = discountCondition;
    }

    private Scanner scanner = new Scanner(System.in);

    public void operate() {


        printMenu();
        Product selectedProduct = chooseMenu();
        selectedProduct.applyOption();
        order(selectedProduct);
    }

    private void order(Product selectedProduct) {
        // XXXX.discount()
//        int price = cozDiscountCondition.discount(selectedProduct.getPrice());
//        int price = beDiscountCondition.discount(selectedProduct.getPrice());
        int price = discountCondition.discount(selectedProduct.getPrice());
        System.out.println("주문이 완료되었습니다. ");
        System.out.printf(
                "주문 상품 : %s %s\n",
                selectedProduct.getName(), selectedProduct.getOptionToString()
        );
        System.out.printf("가격 : %d\n", price);
    }

    private Product chooseMenu() {
        int selectedId = Integer.parseInt(scanner.nextLine());
        Product selectedProduct = productRepository.findById(selectedId);
        return selectedProduct;
    }

    private void printMenu() {
        System.out.println("# 메뉴");
        System.out.println("-".repeat(50));

        for (Product product : productRepository.getProducts()) {
            System.out.printf(
                    "(%d) %-15s %d\n",
                    product.getId(), product.getName(), product.getPrice()
            );
        }

        System.out.println("-".repeat(50));
        System.out.println("메뉴를 골라주세요.");
    }
}
