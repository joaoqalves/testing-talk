package com.schibsted.testing.shapes;


public class ShapeFactory {

    public Rectangle newRectangle() {
        return new Square();
    }

}
