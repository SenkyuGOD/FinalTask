package org.example.database;

public final class DataBaseProvider {
    private final static DataBaseProvider instance = new DataBaseProvider();

    private FileProduct productFile = new FileProduct();

    private Bucket bucket = new Bucket();

    public Bucket getBucket() {return  bucket;}

    public FileProduct getFileProduct() {
        return productFile;
    }

    public static DataBaseProvider getInstance() {
        return instance;
    }
}
