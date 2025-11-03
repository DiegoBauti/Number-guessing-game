public enum Difficulty {
    EASY(10),
    MEDIUM(5),
    HARD(3);

    private final int tries;

    Difficulty(int tries) {
        this.tries=tries;
    }

    public int getTries(){
        return tries;
    }



}
