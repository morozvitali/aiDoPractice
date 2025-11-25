package stream1.DTO_training_types_entity__;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Main2 {
    public static void main(String[] args) {
        Account entity = new Account();
        entity.balance = new BigDecimal("1,234.56");

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        AccountDto dto = new AccountDto();
        dto.balance = nf.format(entity.balance);
    }

}

class Account {
    BigDecimal balance;
}

class AccountDto {
    String balance;
}

