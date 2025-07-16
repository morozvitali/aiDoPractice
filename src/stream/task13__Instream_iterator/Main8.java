package stream.task13__Instream_iterator;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main8 {
    public void practice1 () {
        IntStream.iterate(10, i ->i -1).limit(10).forEach(System.out::println);
    }

    public void practice2 () {
        IntStream.iterate(2, i->i+2).limit(10).forEach(System.out::println);
    }

    public void practice3 () {
        IntStream.iterate(1, i->i+2).limit(10).forEach(System.out::println);
    }

    public void practice4 () {
        IntStream.iterate(50, i->i-5).limit(10).forEach(System.out::println);
    }

    public void practice5 () {
        IntStream.iterate(1, i->i+1).map(a->a*a).forEach(System.out::println);

    }

    public void practice6 () {
        IntStream.iterate(17, i->i+10).limit(9).forEach(System.out::println);
    }


    public void practice7 () {
        IntStream.iterate(1, i->i*2).limit(10).forEach(System.out::println);

    }

    public void practice8 () {
        IntStream.iterate(1, i->i+3).filter(a->a%3==0).limit(10).forEach(System.out::println);
    }

    public void practce9 () {
        IntStream.iterate(1, i->i+1).map(a->a*a).filter(a->a%10!=5).limit(10).forEach(System.out::println);
    }

    public void practice10 () {
        IntStream.iterate(1, i->i+1).filter(a->a%3==0).skip(5).forEach(System.out::println);
    }

    public void practice11 () {
        IntStream.iterate(1, new IntPredicate() {
            int sum = 0;
            public boolean test (int i) {
                sum += i;
                return sum < 50;
            }
        }, i->i+1);
    }

    public void practice12 () {
        "programmingisfun".chars().distinct().limit(10).forEach(System.out::println);
    }

    public void practice13 () {
        "streamprocessing".chars().mapToObj(a->(char)a).filter(a->"aeiou".indexOf(a)>=0).forEach(System.out::println);
    }

    public void practice14 () {
        IntStream.rangeClosed(1,20).map(a->a*a).filter(value -> value%4 == 0).peek(a-> System.out.println("LOG " + a)).forEach(System.out::println);
    }


}
