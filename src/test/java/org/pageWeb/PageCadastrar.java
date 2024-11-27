
package org.pageWeb;

import org.actions.Actions;
import org.attributesWeb.AttributesSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageCadastrar extends AttributesSearch implements Actions {
    public WebDriver driver;

    public PageCadastrar(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void inserirDados() {
        setText(Nome,"Nicholas");
        setText(Sobrenome,"Luiz");
        setText(Idade,"30");
        setText(Telefone,"1234567890");
        setText(Email,"nicholas.smith@example.com");
        setText(Linkedin,"https://www.linkedin.com/feed/)");
        click(Cadastrar);
        String titlePageEsperado = "Registro Sucesso";
        String titlePage = driver.getTitle();

        validateEquals(titlePageEsperado,titlePage);
    }
}

