package pl.warehouse.exceptions;

import javax.persistence.NonUniqueResultException;

public class LoginCheckException extends NonUniqueResultException {
    private String info;
    public LoginCheckException(String info){
            this.info=info;}
    public String getInfo(){return info;}

}
