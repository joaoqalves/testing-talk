package com.schibsted.testing.framework;


import com.schibsted.testing.domain.model.Rectangle;
import com.schibsted.testing.domain.model.Square;

public class ShapeFactory {

    public Rectangle newRectangle() {
        return new Square();
    }

}
