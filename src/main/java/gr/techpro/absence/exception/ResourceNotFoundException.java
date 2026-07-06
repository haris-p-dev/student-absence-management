package gr.techpro.absence.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String errorMsg){
        super(errorMsg);
    }

}
