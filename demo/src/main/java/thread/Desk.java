package thread;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/6 9:58
 */
public class Desk {
    private boolean falg;
    private int count;
    private final Object lock = new Object();

    public Desk(boolean falg, int count) {
        this.falg = falg;
        this.count = count;
    }

    public Desk() {
        this(false,10);
    }

    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getLock() {
        return lock;
    }
}
