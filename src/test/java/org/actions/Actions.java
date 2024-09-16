package org.actions;

import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public interface Actions {

    default void validateObject(WebElement element){
        boolean flag = false;
        try{
            if (element.isEnabled()){
                flag=true;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    default void setText(WebElement element, String texto) {
        try {
            if (element.isEnabled()) {
                element.sendKeys(texto);
            } else {
                throw new IllegalStateException("O elemento não está habilitado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao definir o texto: " + e.getMessage(), e);
        }
    }

    default void click(WebElement element){
        try{
            if(element.isEnabled()){
                click(element);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    default boolean validateEquals(String element, String element2){
        try{
            return element.equals(element2);
        }catch (Exception e){
            throw new RuntimeException("Erro ao comparar os elementos"+e.getMessage(),e);
        }
    }
}
