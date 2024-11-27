package org.attributesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AttributesRead {

    public WebDriver driver;
    public AttributesRead(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='mx-auto p-3']//button[1]")
    public WebElement visualizar;

    @FindBy(how = How.XPATH, using = "//span[text()='Lista de Usuários']")
    public WebElement topoPage;


    protected WebElement listaUsers(String id){
        WebElement listaUser = driver.findElement(By.xpath("//ul[@class='list-group']//li["+id+"]"));
        return listaUser;
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Editar')]")
    public WebElement editarButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Deletar')]")
    public WebElement deletarButton;
}
