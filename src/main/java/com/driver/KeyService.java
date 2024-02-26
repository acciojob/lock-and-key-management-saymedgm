package com.driver;

public class KeyService {
    private KeyRepository keyRepository;

    public KeyService(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    public void addKey(int id, String type, String description) {
        Key key = new Key(id, type, description);
        keyRepository.addKey(key);
        System.out.println("Key added with ID: " + id);
    }

    public Key getKeyById(int id) {
        return keyRepository.getKeyById(id);
    }
}