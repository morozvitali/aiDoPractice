package stream.task1_peek_mapping_chartoint_8;

public class Main8 {
public int practice1 (int n) {
    return String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
            .map(d->d*d).sum();

    //return String.valueOf(Math.abs(n)).chars().map(c->c-'0')
            //.map(d->d*d).sum();
}

}
