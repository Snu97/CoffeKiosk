package checkpoint;

import checkpoint.discount.BEDiscountCondition;
import checkpoint.discount.CozDiscountCondition;
import checkpoint.discount.DiscountCondition;

public class AppConfigurer {

    public DiscountCondition discountCondition() {
        return new BEDiscountCondition(20);
    }
}
