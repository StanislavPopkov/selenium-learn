package ru.qalearn.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private WebElement table;
    private WebDriver webDriver;

    public Table(WebElement webElement, WebDriver webDriver) {
        this.table = webElement;
        this.webDriver = webDriver;
    }

    /**
     * получаем строки таблицы
     * @return List<WebElement>
     */
    public List<WebElement> getRows(){
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    /**
     * получаем заголовки таблицы
     * @return List<WebElement>
     */
    public List<WebElement> getHeadings(){
        WebElement heading = table.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headings = heading.findElements(By.xpath(".//th"));
        return headings;
    }

    /**
     * получаем строки разбитые на колонки
     * @return List<List<WebElement>>
     */
    public List<List<WebElement>> getRowWithsColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<>();
        rows.stream().map(webElement -> webElement.findElements(By.xpath(".//td")))
                .forEach(listElement -> rowsWithColumns.add(listElement));
        return rowsWithColumns;
    }

    /**
     * получаем значение из таблицы по номеру строки и номеру колонки
     * @param rowNumber
     * @param columnNumber
     * @return String
     */
    public String getValueFromCell(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowWithsColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }

    /**
     * получаем значение из таблицы по номеру строки и имени колонки
     * @param rowNumber
     * @param columnName
     * @return String
     */
    public String getValueFromMapHeadingValue(int rowNumber, String columnName) {
        List<Map<String, WebElement>> listMap = getMapHeadingValue();
        return listMap.get(rowNumber - 1).get(columnName).getText();
    }

    /**
     * получаем map, состоящую из строк(List). Каждый list соответствует номеру строки таблицы.
     * В каждом list содержиться map содержащая название заголовка и значение.
     * @return List<Map<String, WebElement>>
     */
    public List<Map<String, WebElement>> getMapHeadingValue(){
        List<List<WebElement>> rowsWithColumns = getRowWithsColumns();
        List<Map<String, WebElement>> listMap = new ArrayList<>();
        List<WebElement> headings = getHeadings();
        Map<String, WebElement> mapHeadingValue = null;
        for (List<WebElement> rowList : rowsWithColumns) {
            mapHeadingValue = new HashMap<>();
            for (int i = 0; i < headings.size() ; i++) {
                String headingValue = headings.get(i).getText();
                WebElement webElement = rowList.get(i);
                mapHeadingValue.put(headingValue, webElement);
            }
            listMap.add(mapHeadingValue);
        }
        return listMap;
    }
}
