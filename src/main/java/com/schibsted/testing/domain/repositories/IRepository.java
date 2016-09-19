package com.schibsted.testing.domain.repositories;

import java.util.Optional;

public interface IRepository<A, B> {
    B save(final B entity);
    Optional<B> find(final A id);
}
