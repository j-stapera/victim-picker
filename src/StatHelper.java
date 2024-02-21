import java.util.Arrays;

public class StatHelper {

    public static double findMean(double... numbers){
        double mean = 0;

        for (double num : numbers){
            mean += num;
        }
        mean /= numbers.length;
        return mean;
    }

    public static double getRange(double... numbers){
        double max = numbers[0];
        double min = numbers[0];

        for (double num : numbers){
            if (num > max){
                max = num;
            } else if (num < min){
                min = num;
            }
        }

        double range;
        range = max - min;
        return range;
    }

    public static double findMedian(double... numbers){
        Arrays.sort(numbers);
        double median = 0;
        int index = numbers.length / 2;
        if (numbers.length % 2 == 0){
            median = (double)(numbers[index] + numbers[index + 1]) / 2; // gets avg median since list length is even
        } else {
            median = numbers[index];
        }
        return median;
    }

    public static double findStdDev(double... numbers){
        double median = findMedian(numbers);
        double stdDev = 0;
        for (double num : numbers){
            num -= median;
            stdDev += Math.pow(num, 2);
        }

        stdDev /= numbers.length;
        stdDev = Math.sqrt(stdDev);
        return stdDev;
    }
}