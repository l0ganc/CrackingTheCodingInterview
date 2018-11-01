package StacksAndQueues;

public abstract class Animal {
    private int order;
    protected String name;
    public Animal(String n) {
        name = n;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    // compare orders of animals to return the older items
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}