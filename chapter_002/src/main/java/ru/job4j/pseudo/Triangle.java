package ru.job4j.pseudo;
/**
 * @author Airat Muzafarov
 * @since 17/02/2019
 * @version 0.1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("   * ");
        picture.append("  *** ");
        picture.append(" ***** ");
        picture.append("*******");
        return picture.toString();
    }
}
