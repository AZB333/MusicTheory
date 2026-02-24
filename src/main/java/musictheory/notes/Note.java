package musictheory.notes;

public class Note {
    private final String name;

    public Note(String name){
        String lowerCaseName = name.toLowerCase();
        switch(lowerCaseName) {
            case ("c"), ("db"), ("d"), ("eb"), ("e"), ("f"), ("gb"), ("g"), ("ab"), ("a"), ("bb"), ("b") -> this.name = name;
            default -> throw new IllegalArgumentException("Not a valid note");
        }
    }

    public String getName() {return name;}
}
