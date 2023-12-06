package service.impl;

public class GeneratorId {
    public static long id = 0;

    public static long idReader = 0;

    public static long idBook = 0;

    public static long generator(){
        return (++id);
    }

    public static long generatorReader(){
        return (++idReader);
    }

    public static long generatorBook(){
        return (++idBook);
    }
}
