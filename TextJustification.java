import java.util.ArrayList;
import java.util.List;
public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;
        for (String word : words) {
            if (currentLength + word.length() + currentLine.size() > maxWidth) {
                result.add(justifyLine(currentLine, maxWidth, false));
                currentLine.clear();
                currentLength = 0;
            }
            currentLine.add(word);
            currentLength += word.length();
        }
        result.add(justifyLine(currentLine, maxWidth, true));
        return result;
    }
    private static String justifyLine(List<String> line, int maxWidth, boolean isLastLine) {
        if (line.size() == 0) return "";
        if (line.size() == 1 || isLastLine) {
            return String.join(" ", line) + " ".repeat(maxWidth - line.stream().mapToInt(String::length).sum() - (line.size() - 1));
        }
        int totalSpaces = maxWidth - line.stream().mapToInt(String::length).sum();
        int spaceBetweenWords = totalSpaces / (line.size() - 1);
        int extraSpaces = totalSpaces % (line.size() - 1);

        StringBuilder justifiedLine = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            justifiedLine.append(line.get(i));
            if (i < line.size() - 1) {
                justifiedLine.append(" ".repeat(spaceBetweenWords + (i < extraSpaces ? 1 : 0)));
            }
        }
        return justifiedLine.toString();
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> justifiedText = fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }
}
