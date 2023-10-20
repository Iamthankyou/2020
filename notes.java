float startX, startY; // Store the initial touch coordinates
float endX, endY;   // Store the final touch coordinates

// Handle the onTouchMove event
@Override
public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            startX = event.getX();
            startY = event.getY();
            break;

        case MotionEvent.ACTION_MOVE:
            endX = event.getX();
            endY = event.getY();

            float deltaX = endX - startX;
            float deltaY = endY - startY;

            if (Math.abs(deltaX) > Math.abs(deltaY)) {
                if (deltaX > 0) {
                    // Move to the right
                } else {
                    // Move to the left
                }
            } else {
                if (deltaY > 0) {
                    // Move downwards
                } else {
                    // Move upwards
                }
            }

            startX = endX;
            startY = endY
