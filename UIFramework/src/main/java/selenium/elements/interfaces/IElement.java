package selenium.elements.interfaces;

import org.openqa.selenium.Keys;
import selenium.elements.HighlightState;


public interface IElement {

    /**
     * Send keys.
     *
     * @param key key for sending.
     */
    void sendKeys(Keys key);

    /**
     * Click on an item and wait for the page is loaded
     */
    void clickAndWait();

    /**
     * Get the item text (inner text).
     *
     * @return Text of element
     */
    default String getText() {
        return getText(HighlightState.DEFAULT);
    }

    /**
     * return text of element with highlighting or not before getting text
     *
     * @param highlightState if HIGHLIGHT: create red border around element that we interact while getting text
     * @return text of element
     */
    String getText(HighlightState highlightState);

    /**
     * Gets attribute value of the element.
     *
     * @param attr Attribute name
     * @return Attribute value
     */
    default String getAttribute(String attr) {
        return getAttribute(attr, HighlightState.DEFAULT);
    }

    /**
     * returns attribute value of element with highlighting or not before getting text
     *
     * @param highlightState if HIGHLIGHT: create red border around element that we interact while getting text
     * @param attr           html attribute name
     * @return Attribute value
     */
    String getAttribute(String attr, HighlightState highlightState);

    /**
     * Gets css value of the element.
     *
     * @param propertyName css value name
     * @return css value
     */
    default String getCssValue(String propertyName) {
        return getCssValue(propertyName, HighlightState.DEFAULT);
    }

    /**
     * Gets css value of the element.
     *
     * @param propertyName   css value name
     * @param highlightState if HIGHLIGHT: create red border around element that we interact while getting css value
     * @return css value
     */
    String getCssValue(String propertyName, HighlightState highlightState);
}
