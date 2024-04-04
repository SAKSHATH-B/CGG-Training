public class Program9 {
    public static String performOperation(String input, int choice) {
        switch (choice) {
            case 1:
                return input + input;
            case 2:
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 == 0) {
                        result.append(input.charAt(i));
                    } else {
                        result.append("#");
                    }
                }
                return result.toString();
            case 3:
                return input.chars()
                        .distinct()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
            case 4:
                char[] charArray = input.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (i % 2 != 0) {
                        charArray[i] = Character.toUpperCase(charArray[i]);
                    }
                }
                return new String(charArray);
            default:
                return "Invalid choice";
        }
    }

    public static void main(String[] args) {
        String input = "example";  // Replace with your desired input string
        int choice = 4;  // Replace with the user's choice (1, 2, 3, or 4)

        String result = performOperation(input, choice);
        System.out.println("Result: " + result);
    }
}
