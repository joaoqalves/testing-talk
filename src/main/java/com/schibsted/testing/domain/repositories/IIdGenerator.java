package com.schibsted.testing.domain.repositories;

public interface IIdGenerator<T> {
    T generateId();
}
