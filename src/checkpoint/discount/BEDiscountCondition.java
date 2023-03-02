package checkpoint.discount;

import java.util.Scanner;

public class BEDiscountCondition implements DiscountCondition {

    private int discountRate;

    public BEDiscountCondition(int discountRate) {
        this.discountRate = discountRate;
    }

    // 할인 조건을 물어보는 메서드
    private boolean checkDiscountCondition() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("코드스테이츠 백엔드 코스 수강생이십니까? (1)_예 (2)_아니오");

        String input = scanner.nextLine();

        if (input.equals("1")) return true;
        else return false;
    }

    // 할인 금액을 계산해주는 메서드
    private int calcuateDiscountedPrice(int price) {
        return price - (price * discountRate / 100);
    }

    // 할인을 적용해주는 메서드
    public int discount(int price) {
        if (checkDiscountCondition()) return calcuateDiscountedPrice(price);
        else return price;
    }
}
