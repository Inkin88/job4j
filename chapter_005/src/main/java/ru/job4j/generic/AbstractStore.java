package ru.job4j.generic;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> data;

    public AbstractStore(SimpleArray<T> data) {
        this.data = data;
    }

    @Override
    public void add(T model) {
        data.add(model);

    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < data.index; i++) {
            if (id.equals(data.get(i).getId())) {
                data.set(i, model);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < data.index; i++) {
            if (id.equals(data.get(i).getId())) {
                data.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < data.index; i++) {
            if (id.equals(data.get(i).getId())) {
                result = data.get(i);
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
