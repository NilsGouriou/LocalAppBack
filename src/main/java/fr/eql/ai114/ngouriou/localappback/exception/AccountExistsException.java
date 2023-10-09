package fr.eql.ai114.ngouriou.localappback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Account already exist")
public class AccountExistsException extends Exception {
    
}
