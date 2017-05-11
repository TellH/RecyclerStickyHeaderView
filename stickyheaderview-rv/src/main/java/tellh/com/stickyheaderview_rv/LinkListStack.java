package tellh.com.stickyheaderview_rv;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Created by tlh on 2017/5/11 :)
 */

public class LinkListStack<E> {
    private LinkedList<E> list = new LinkedList<>();

    public E push(E item) {
        list.addLast(item);
        return item;
    }

    public E pop() {
        if (list.isEmpty())
            return null;
        return list.removeLast();
    }

    public synchronized E peek() {
        if (list.size() == 0)
            throw new EmptyStackException();
        return list.peekLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void clear() {
        list.clear();
    }

    public boolean remove(E item) {
        return list.remove(item);
    }

}
