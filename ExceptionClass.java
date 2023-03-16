public class ExceptionClass extends Exception {
    public ExceptionClass(String type){
        super(String.format("Type %s is not comparable", type));
    }
}
