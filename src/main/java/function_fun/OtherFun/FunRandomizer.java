package function_fun.OtherFun;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.23.24                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
public class FunRandomizer {

    /**
     * Generates a random integer between the specified minimum and maximum values (inclusive).
     *
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return a random integer between min and max (inclusive)
     */
    public Integer randomInt(Integer min, Integer max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Generates a random BigDecimal value between the specified minimum and maximum values.
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (exclusive)
     * @return a random BigDecimal value between min (inclusive) and max (exclusive)
     */
    public BigDecimal randomBigDec(BigDecimal min, BigDecimal max){
        Random random = new Random();
        return min.add(new BigDecimal(random.nextDouble()).multiply(max.subtract(min)));
    }

    /**
     * Generates a random BigInteger value between the specified minimum and maximum values (inclusive).
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return a random BigInteger value between min and max
     */
    public BigInteger randomBigInt(BigInteger min, BigInteger max){
        Random random = new Random();
        return min.add(new BigInteger(max.subtract(min).bitLength(), random));
    }

    /**
     * Generates a random Long value between the specified minimum and maximum values (inclusive).
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return a random Long value between min and max
     */
    public Long randomLon(Long min, Long max){
        Random random = new Random();
        return min + (long) (random.nextDouble() * (max - min));
    }

    /**
     * Generates a random double value between the specified minimum and maximum values.
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (exclusive)
     * @return a random double value between min (inclusive) and max (exclusive)
     */
    public Double randomDou(Double min, Double max){
        Random random = new Random();
        return min + (random.nextDouble() * (max - min));
    }

    /**
     * Selects a random element from the provided list.
     *
     * @param <T> the type of elements in the list
     * @param list the list from which to select a random element
     * @return a randomly selected element from the list, or null if the list is empty
     */
    public <T> T selectRandom(List<T> list) {
        // Create a new Random instance
        Random random = new Random();

        // If the list is empty, return null
        if (list.isEmpty()) {
            return null;
        }

        // Generate a random index within the bounds of the list size
        int index = random.nextInt(list.size());

        // Return the element at the randomly generated index
        return list.get(index);
    }
}
