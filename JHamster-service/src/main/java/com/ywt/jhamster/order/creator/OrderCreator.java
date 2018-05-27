package com.ywt.jhamster.order.creator;

public interface OrderCreator<R,T> {
	R createOrder(T t);
}
