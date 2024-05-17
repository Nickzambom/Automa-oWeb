package org.actions;

import org.openqa.selenium.WebElement;

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
}
