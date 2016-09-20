package com.schibsted.testing.servicetest.domain.repositories;

public interface IIdGenerator<T> {
    T generateId();
}
