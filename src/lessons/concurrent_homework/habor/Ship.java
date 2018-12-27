package lessons.concurrent_homework.habor;

public class Ship {
    private int upLoading;
    private int loading;

    public Ship(int upLoad, int load) {
        this.upLoading = upLoad;
        this.loading = load;
    }

    public int getUpLoading() {
        return upLoading;
    }

    public void setUpLoading(int upLoading) {
        this.upLoading = upLoading;
    }

    public int getLoading() {
        return loading;
    }

    public void setLoading(int loading) {
        this.loading = loading;
    }
}
