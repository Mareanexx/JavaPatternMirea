import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Application {
    public static String stringToOutput() {
        List<String> stringArray = new ArrayList<>(Arrays.asList(
                "Life is like a box of chocolates, you never know what you're gonna get!",
                "Sometimes my life seems like a surrealistic movie with no plot.",
                "Laughter is the best medicine, especially when you can't afford medical bills.",
                "Friday is a little victory over life!",
                "The more I learn about people, the more I value moments when I'm alone.",
                "Life is not just black and white, but all shades of gray.",
                "If life were fair, chips wouldn't run out at the most inconvenient moment.",
                "When I grow up, I want to be childhood.",
                "It's never too late to start living as if tomorrow will never come.",
                "Love is like Wi-Fi, available everywhere, but the connection quality depends on the password."
        ));
        Random random = new Random();
        int randomIndex = random.nextInt(stringArray.size());
        return stringArray.get(randomIndex);
    }

    public static void main(String[] args) {
        System.out.println(stringToOutput());
    }
}