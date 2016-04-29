package rivet.core.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Util {
	public static <T> List<T> shuffleList(final List<T> lis, final Long seed) {
		final Integer size = lis.size();
		return randInts(size, size, seed)
				.mapToObj(lis::get)
				.collect(toList());
	}
	
	public static double[] shuffleDoubleArray(final double[] arr, final Long seed) {
		final int size = arr.length;
		return randInts(size, size, seed)
				.mapToDouble((i) -> arr[i])
				.toArray();
	}
	
	public static IntStream randInts (final Integer bound, final Integer length, final Long seed) {
		return new Random(seed).ints(0, bound).distinct().limit(length);
	}
	
	public static LongStream range (final Long start, final Long bound) { return LongStream.range(start, bound);}
	public static LongStream range (final Long start, final Long bound, final Long step) {
		return range(start, bound).filter((x) -> (x - start) % step == 0L);
	}
	public static LongStream range(final Long bound) { return range(0L, bound); }
	
	public static IntStream range (final Integer start, final Integer bound, final Integer step) { 
		return range(start, bound).filter((x) -> (x - start) % step == 0L);
	}
	public static IntStream range (final Integer start, final Integer bound) { return IntStream.range(start, bound); }
	public static IntStream range (final Integer bound) {	return range(0, bound); }
}
