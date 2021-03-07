package com.senlainc.util.comparators;

import com.senlainc.model.Order;

import java.util.Comparator;

public class OrderCheckOutDateComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getCheckOutDate().compareTo(o2.getCheckOutDate());
    }
}
