package scenerio;

import base.BaseProcess;
import methods.Methods;
import org.junit.Test;
import pageObjects.BasketPageProcess;
import pageObjects.BookPageProcess;
import pageObjects.MainPageProcess;

public class MainTest extends BaseProcess {
    Methods methods = new Methods();



    @Test
    public void Main()  {

        //Going to the site.
        methods.getUrl(firstUrl);

        //It is verified that the site has been visited.
        methods.currentUrlControl(firstUrl);
        methods.findElement(MainPageProcess.mainBasePageLogo); // The site is verified to be loaded.
        methods.sendKey(MainPageProcess.searchBar, methods.csvRead());// The text "Roman" from the csv file was written to the searchbox.
        methods.enterKey(MainPageProcess.searchBar);//After typing the novel into the Searchbar, press enter from the keyboard.
        methods.randomBookPickClick(MainPageProcess.productList);//After selecting a random novel from the ProductList, it is added to the cart.
        methods.assertionTextControl(BookPageProcess.basketLogo,"1");//Checked that the value in the Cart Logo is incremented by one.
        methods.clickToElement(BookPageProcess.basketLogo);//The basket logo has been clicked.
        methods.clickToElement(BookPageProcess.goToBasketButton);//Click the go to cart button.
        methods.clickToElement(BasketPageProcess.quantity);//Clicked on the product quantity.
        methods.clearToElement(BasketPageProcess.quantity);//The product quantity has been deleted.
        methods.sendKey(BasketPageProcess.quantity,"2");//The amount of product has been increased by one.
        methods.clickToElement(BasketPageProcess.updateQuantity);//The product update button has been pressed.
        methods.assertionTextControl(BasketPageProcess.updateQuantityText,"Sepetiniz güncelleniyor!");
        methods.clickToElement(BasketPageProcess.cancelButton);//The basket is cleaned by pressing the cross.
        methods.assertionTextControl(BookPageProcess.basketLogo,"0");//The basket is confirmed to be empty.
    }








}
