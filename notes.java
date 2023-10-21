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

                Hello Mr. Cho, I have encountered an issue when performing the straightening operation with a quickly flung seek bar. The issue arises because the condition (degree >= 45F || degree <= -45F) is applied in the performStraighten(deltaDegree) function. In some cases, degree is calculated as getProgressFromState() - deltaDegree, and I believe this is incorrect. I attempted to change the subtraction to addition, but in some cases, when the seek bar is flung quickly, it still doesn't work correctly.

This condition is causing the seek bar not to align with the preview in the straighten operation. You can observe this issue when moving the seek bar to 0; the preview does not match the original. If you don't mind, please review this commit. I'm unsure why these functions are needed. Thank you for taking the time to read this, Mr. Cho.
