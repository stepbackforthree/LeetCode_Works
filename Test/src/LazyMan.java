public class LazyMan {

    private LazyMan() {}

    private static LazyMan lazyMan;

    public static LazyMan getLazyMan() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }

        return lazyMan;
    }
}
