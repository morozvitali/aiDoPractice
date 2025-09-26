package stream.task60x24.x1.task12_plus_valueOf_10;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class Main20 {

    public void practice1() {
        List<String> inputs = List.of("1010", "7B", "377", "42");
        List<Integer> bases = List.of(2, 16, 8, 10);

        List<Long> result = IntStream.range(0, inputs.size())
                .mapToObj(i -> Long.parseLong(inputs.get(i), bases.get(i)))
                .toList();
    }

    public void practice2 () {
        long balance = 123456789L;
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        String formatted = nf.format(balance);
    }


}