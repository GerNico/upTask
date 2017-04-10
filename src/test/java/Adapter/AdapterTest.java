package Adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SuppressWarnings("unchecked")
class AdapterTest {
    @Test
    void count() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        assertEquals(3,adapter.count());
    }

    @Test
    void get() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        assertEquals("gjghgh",adapter.get(1));
    }

    @Test
    void first() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        assertEquals(1d,adapter.first());
    }

    @Test
    void last() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        assertEquals(12345L,adapter.last());
    }

    @Test
    void include() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        assertEquals(true,adapter.include(1d));
    }

    @Test
    void append() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        adapter.append("firstOne");
        assertEquals("firstOne",adapter.first());
    }

    @Test
    void prepend() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        adapter.prepend("lastOne");
        assertEquals("lastOne",adapter.last());
    }

    @Test
    void delete() {
        Adapter adapter =new Adapter();
        adapter.add(1d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        adapter.delete(1d);
        assertEquals(2,adapter.size());
        assertEquals(false,adapter.get(0).equals(1d));
    }

    @Test
    void deleteLast() {
        Adapter adapter =new Adapter();
        adapter.add(1325d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        adapter.deleteLast();
        assertEquals(2,adapter.size());
        assertEquals(false,adapter.get(0).equals(12345L));
    }

    @Test
    void deleteFirst() {
        Adapter adapter =new Adapter();
        adapter.add(1325d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        adapter.deleteFirst();
        assertEquals(2,adapter.size());
        assertEquals(false,adapter.get(0).equals(1325d));
    }

    @Test
    void deleteAll() {
        Adapter adapter =new Adapter();
        adapter.add(1325d);
        adapter.add("gjghgh");
        adapter.add(12345L);
        adapter.deleteAll();
        assertEquals(0,adapter.size());
    }

}