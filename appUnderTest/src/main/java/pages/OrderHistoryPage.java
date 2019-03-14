package pages;

import common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class OrderHistoryPage extends AbstractPage<OrderHistoryPage> {


    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getUrl() {
        return "?controller=history";
    }

    public boolean validateOrderHistory() {
        List<WebElement> rowsOfTable = getWebDriver().findElements(By.xpath("//*[@id='order-list']/tbody/tr"));
        boolean flag = false;
        for (int i = 1; i < rowsOfTable.size(); i++) {
            if (OrderPage.boxText.contains(rowsOfTable.get(i).findElement(By.xpath("//td[1]")).getText())
                    && OrderPage.boxText.contains(rowsOfTable.get(i).findElement(By.xpath("//td[3]")).getText())) {
                flag = true;
                break;
            }
        }

        return flag;

    }

}
