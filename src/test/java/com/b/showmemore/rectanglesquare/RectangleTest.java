package com.b.showmemore.rectanglesquare;

import com.schibsted.testing.shapes.Rectangle;
import com.schibsted.testing.shapes.ShapeFactory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RectangleTest {

    private ShapeFactory shapeFactory;

    @Before
    public void setUp() {
        this.shapeFactory = new ShapeFactory();
    }

    @Test
    public void givenSameHeightAndWidthWhenCalculatesAreaThenSucceeds() {
        // Given
        Rectangle r = this.shapeFactory.newRectangle();
        r.setWidth(5);
        r.setHeight(5);

        // When
        int actual = r.calculateArea();

        // Then
        assertEquals(25, actual);
    }

    @Test
    public void givenDifferentHeightAndWidthWhenCalculatesAreaThenSucceeds() {
        // Given
        Rectangle r = this.shapeFactory.newRectangle();
        r.setWidth(6);
        r.setHeight(5);

        // When
        int actual = r.calculateArea();

        // Then
        assertEquals(30, actual);
    }

}
