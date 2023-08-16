package Logic;

public interface StringParser<T> {
    public T parseString(String string) throws StringParserException, UserParamsException;
}
