package cz.janrehak.Communicator.exception;

import java.io.IOException;

public class DatabaseException extends IOException {

    public DatabaseException() {
    }

    public DatabaseException(String message, Throwable cause) {
        super("Exception on Database side.", cause);
    }
}
