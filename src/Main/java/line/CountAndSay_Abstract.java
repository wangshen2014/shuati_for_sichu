package line;

/**
 * Created by patrickyu on 10/2/16.
 */
abstract public class CountAndSay_Abstract implements CountAndSay {

    public static final String ILLEGAL_ARGUMENT_MESSAGE = "Invalid input";

    protected void checkInput(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
    }


}

