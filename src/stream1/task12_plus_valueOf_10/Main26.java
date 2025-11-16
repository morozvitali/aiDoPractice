package stream1.task12_plus_valueOf_10;

import java.text.NumberFormat;
import java.util.Locale;

public class Main26 {
    long balance = 123456789L;
NumberFormat nf = NumberFormat.getInstance(Locale.US);
String formatted = nf.format(balance);

}
