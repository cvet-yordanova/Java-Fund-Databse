package Model.transactions;


public interface Command<E> {
    E execute();
}
