package Repository;

import Module.Constract;
import util.ReadFileConstract;
import util.WriteFileConstract;

import java.util.Queue;

public class ConstractRepository implements IConstractRepository{
    @Override
    public Queue<Constract> findAll() {
        return ReadFileConstract.readFile();
    }

    @Override
    public void write(Queue<Constract> queue) {
        WriteFileConstract.writeFile(queue);
    }
}
