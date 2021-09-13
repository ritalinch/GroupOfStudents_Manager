public class NoEmptySpaceException extends Exception{

    public NoEmptySpaceException(){
        super("There are 10 students already in the group, " +
                "therefore it is not possible to add new students.");
    }
}