package org.skypro.exception;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchTerm) {
        super("Не найден подходящий объект для поискового запроса: " + searchTerm);
    }
}
