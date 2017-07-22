package Model.transactions;


import java.util.List;

public interface MultiResultCommand<E> {
    List<E> execute();
}
