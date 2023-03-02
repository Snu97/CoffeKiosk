package checkpoint.discount;

import java.util.Scanner;

public class CozDiscountCondition implements DiscountCondition {

    // 할인 금액을 저장하는 필드
    private int discountAmount;

    public CozDiscountCondition(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    // 할인 조건을 물어보는 메서드
    private boolean checkDiscountCondition() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생이십니까? (1)_예 (2)_아니오");

        String input = scanner.nextLine();

        if (input.equals("1")) return true;
        else return false;
    }

    // 할인 금액을 계산해주는 메서드
    private int calcuateDiscountedPrice(int price) {
        return price - discountAmount;
    }

    // 할인을 적용해주는 메서드
    public int discount(int price) {
        if (checkDiscountCondition()) return calcuateDiscountedPrice(price);
        else return price;
    }
}
