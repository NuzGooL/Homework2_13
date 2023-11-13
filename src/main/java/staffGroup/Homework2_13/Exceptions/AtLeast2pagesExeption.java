package staffGroup.Homework2_13.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AtLeast2pagesExeption extends IllegalArgumentException {
    public AtLeast2pagesExeption(String message) {
        super(message);
    }
}