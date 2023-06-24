import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOperator {

    public String firstTask(List<String> namesList) {
        return namesList.stream()
                .distinct()
                .filter(name -> namesList.indexOf(name) % 2 == 0)
                .map(name -> (namesList.indexOf(name) + 1) + ". " + name)
                .collect(Collectors.joining(", "));
    }

    public List<String> secondTask(List<String> stringsList) {
        return stringsList.stream()
                .map(line -> line.toUpperCase(Locale.ROOT))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public String thirdTask(String[] numbers) {
        return Arrays.stream(numbers)
                .map(line -> Arrays.stream(line.split(", "))
                        .sorted()
                        .collect(Collectors.joining(", ")))
                .collect(Collectors.joining(", "));
    }

    public Stream<Long> foursTask(long a, long c, long m) {
        return Stream.iterate(258195289894487L, i -> (a * i + c) % m);
    }

    public Stream<Long> foursTask() {
        return foursTask(25214903917L, 11, (long) Math.pow(2, 48));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream.Builder<T> stream = Stream.builder();
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            stream.add(iterator1.next());
            stream.add(iterator2.next());
        }
        return stream.build();
    }
}
