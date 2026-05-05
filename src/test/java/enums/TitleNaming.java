package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TitleNaming {
    PRODUCTS("Products"),
    CART("Your Cart"),
    CHECKOUT("Checkout: Your Information"),
    CHECKOUTINFO("Checkout: Overview");

    private final String displayName;
}
