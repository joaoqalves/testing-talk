package com;

import com.schibsted.testing.shapes.Rectangle;
import com.schibsted.testing.shapes.ShapeFactory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SquareTest {

    private ShapeFactory shapeFactory;

    @Before
    public void before() {
        this.shapeFactory = new ShapeFactory();
    }

    @Test
    public void calculateAreaSameWidthAndHeight() {

        // Given a rectangle
        Rectangle r = this.shapeFactory.newRectangle();
        // When setting 5 as width
        r.setWidth(5);
        // And 5 as height
        r.setHeight(5);

        // Then the area should be equals to 25
        assertEquals(25, r.calculateArea());
    }

    @Test
    public void calculateAreaDifferentWidthAndHeight() {
        // Given a rectangle
        Rectangle r = this.shapeFactory.newRectangle();
        // When setting 6 as width
        r.setWidth(6);
        // And 5 as height
        r.setHeight(5);

        // Then the area should be equals to 30
        assertEquals(30, r.calculateArea());
    }

}
