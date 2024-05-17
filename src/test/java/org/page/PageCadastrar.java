package org.page;

import org.attributes.AttributesSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;


public class PageCadastrar extends AttributesSearch {
    public WebDriver driver;

    public PageCadastrar(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void inserirDados() {
        Nome.sendKeys("Nicholas");
        Sobrenome.sendKeys("Luiz");
        Idade.sendKeys("30");
        Telefone.sendKeys("1234567890");
        Email.sendKeys("nicholas.smith@example.com");
        Linkedin.sendKeys("https://www.linkedin.com/feed/)");
        Cadastrar.click();
        String titlePageEsperado = "Registro Sucesso";
        String titlePage = driver.getTitle();

        assertEquals(titlePageEsperado,titlePage);
    }
}
