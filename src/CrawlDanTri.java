import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/29/2020
 * Time: 2:40 PM
 */
public class CrawlDanTri {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            content = content.replaceAll(System.lineSeparator(), "");

            Pattern pattern = Pattern.compile("MainList\\|.*title=\"(.*?)\"");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
