package Repository;

import Module.Constract;

import java.util.Queue;

public interface IConstractRepository {
    Queue<Constract> findAll();
    void write(Queue<Constract> queue);
}
