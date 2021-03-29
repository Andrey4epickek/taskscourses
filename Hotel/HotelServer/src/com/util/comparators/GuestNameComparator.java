package com.util.comparators;


import com.model.Order;

import java.util.Comparator;

public class GuestNameComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getGuest().getName().compareTo(o2.getGuest().getName());
    }
}
