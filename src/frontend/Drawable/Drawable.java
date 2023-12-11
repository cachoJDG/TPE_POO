package frontend.Drawable;

import javafx.scene.canvas.GraphicsContext;

public interface Drawable {

    public void draw(GraphicsContext gc);
}

//capaz conviene pasarle las drawables a paintPane, que paintPane llame a draw(gc) y listo para cada figura
