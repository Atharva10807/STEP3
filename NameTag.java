class Tag {
    private final String firstName;
    private final char lastInitial;

    Tag(String fullName) {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastInitial = parts[1].charAt(0);
    }

    String getNickname() {
        return firstName + " " + lastInitial + ".";
    }
}

public class NameTag {
    public static void main(String[] args) {
        Tag tag = new Tag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname());
    }
}