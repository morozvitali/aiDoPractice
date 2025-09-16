package stream.task1_peek_mapping_chartoint_8;

import java.util.stream.IntStream;

public class Main8 {
public int practice1 (int n) {
    return String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
            .map(d->d*d).sum();

    //return String.valueOf(Math.abs(n)).chars().map(c->c-'0')
            //.map(d->d*d).sum();
}


public boolean practice2 (int n) {
    return String.valueOf(Math.abs(n)).chars().map(c->c-'0').allMatch(c->c%2==0);
}

public int practice3 (int n) {
    return String.valueOf(Math.abs(n)).chars().map(c->c-'0').max().orElse(-1);
}

public long practice4 (int n) {
    return String.valueOf(Math.abs(n)).chars().map(c->c-'0').filter(d->d>5).count();
}

public int practice5 (int n) {
    int [] arrays = String.valueOf(Math.abs(n)).chars().map(c->c-'0').toArray();
    return IntStream.range(0, arrays.length).filter(i->i%2 ==1)
            .map(i->arrays[i])
            .reduce(1, (a,b) -> a * b);
}



}
