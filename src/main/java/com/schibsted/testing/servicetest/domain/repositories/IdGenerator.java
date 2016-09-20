package com.schibsted.testing.servicetest.domain.repositories;

public interface IdGenerator<T> {
    T generateId();
}
