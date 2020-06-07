package az.rest.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class GenericResponse<T> {
    private ResponseMessage message;
    private int responseStatus;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;

    public GenericResponse(ResponseMessage message, T data) {
        this.message = message;
        this.data = data;
    }

    public static <T> GenericResponse<T> empty() {
        return new GenericResponse<>();
    }


    public static <T> GenericResponse<T> ok() {
        return createGenericResponse(HttpStatus.OK.value(), ResponseMessage.ok(), null);
    }

    public static <T> GenericResponse<T> ok(T data) {
        return createGenericResponse(HttpStatus.OK.value(), ResponseMessage.ok(), data);
    }

    public static <T> GenericResponse<T> bad() {
        return createGenericResponse(HttpStatus.BAD_REQUEST.value(), ResponseMessage.bad(), null);
    }

    public static <T> GenericResponse<T> resourceNotFound() {
        return createGenericResponse(HttpStatus.NOT_FOUND.value(), ResponseMessage.resourceNotFound(), null);
    }

    private static <T> GenericResponse<T> createGenericResponse(int responseStatus,
                                                                ResponseMessage message,
                                                                T data) {
        GenericResponse<T> GenericResponse = new GenericResponse<>(message, data);
        GenericResponse.setResponseStatus(responseStatus);
        return GenericResponse;
    }
}
