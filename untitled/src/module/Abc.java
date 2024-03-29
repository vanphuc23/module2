package module;

public class Abc implements Comparable<Abc>{
    private int use;

    public Abc() {
    }

    public Abc(int use) {
        this.use = use;
    }

    public int getUse() {
        return use;
    }

    public void setUse(int use) {
            this.use = use;
    }

    public void count() {
        setUse(use+1);
    }

    @Override
    public String toString() {
        return this.use+",";
    }

    @Override
    public int compareTo(Abc o) {
        return this.getUse()-o.getUse();
    }
}
