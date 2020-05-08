package com.airhacks.learning.model;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
public interface BaseEntity {

    long getId();
    String getNamedQueryPrefix(); // to force add to entity string of named query prefix

}
