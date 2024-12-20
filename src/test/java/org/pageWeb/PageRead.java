package org.pageWeb;

import org.attributesWeb.AttributesRead;
import org.actions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageRead extends AttributesRead implements Actions {

    public WebDriver driver;
    public PageRead(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validarCadastro(){
        click(visualizar);
        String title = driver.getTitle();
        String titleEsperado = "Visualizar Usuários";
        validateObject(topoPage);
        validateObject(editarButton);
        validateObject(deletarButton);
    }
}
