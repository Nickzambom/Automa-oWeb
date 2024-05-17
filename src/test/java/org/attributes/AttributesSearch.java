package org.attributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class AttributesSearch {

    private WebDriver driver;

    public AttributesSearch(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "Nome")
    public WebElement Nome;

    @FindBy(how = How.NAME, using = "Sobrenome")
    public WebElement Sobrenome;

    @FindBy(how = How.NAME, using = "Idade")
    public WebElement Idade;

    @FindBy(how = How.NAME, using = "Telefone")
    public WebElement Telefone;

    @FindBy(how = How.NAME, using = "Email")
    public WebElement Email;

    @FindBy(how = How.NAME, using = "Linkedin")
    public WebElement Linkedin;

    @FindBy(how = How.CSS, using = ".btn.btn-primary")
    public WebElement Cadastrar;



}
