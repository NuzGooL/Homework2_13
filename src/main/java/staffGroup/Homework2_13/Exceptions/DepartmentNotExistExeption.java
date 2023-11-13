package staffGroup.Homework2_13.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DepartmentNotExistExeption extends IllegalArgumentException {
    public DepartmentNotExistExeption(String message) {
        super(message);
    }
}