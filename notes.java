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
android {
    // ...

    applicationVariants.all { variant ->
        if (variant.buildType.name == "debug") { // Thay đổi thành build type của bạn (ví dụ: release)
            variant.outputs.all { output ->
                def apkFile = output.getOutputFile("outputFileName.apk")
                tasks.create("installDebugApk", Exec) {
                    commandLine "$android.getAdbExe()",
                            'install',
                            '-r',
                            apkFile.getAbsolutePath()
                }
            }
        }
    }
}
#!/bin/bash

# Đường dẫn đến tệp APK đã được build
APK_PATH="app/build/outputs/apk/debug/app-debug.apk"

# Kiểm tra xem có thiết bị Android nào được kết nối không
devices=$(adb devices)
if [[ $devices != *"device"* ]]; then
    echo "Không có thiết bị Android nào được kết nối."
else
    echo "Đang cài đặt APK lên thiết bị..."
    adb install -r "$APK_PATH" # -r để ghi đè nếu APK đã tồn tại
    echo "Cài đặt hoàn tất."
fi
android {
    // ...

    applicationVariants.all { variant ->
        if (variant.buildType.name == "debug") { // Thay đổi thành build type của bạn (ví dụ: release)
            variant.assemble.finalizedBy(installDebugApk)
        }
    }

    task installDebugApk(type: Exec, dependsOn: 'assembleDebug') {
        commandLine './install_apk.sh' # Đường dẫn đến tệp bash hoặc script của bạn
    }
}
=======
void writeNDE{
    if (doodleParams == null)return;
    JSONObject doodleParamsObject = new JSONObject();
    int penType = doodleParams.getPenType();
    int penSize = doodleParams.getPenSize();
    int penColor = doodleParams.getColor();
    int isStatic = doodleParams.getIsStatic();

    doodleParamsObject.put(ProjectConstants.PEN_TYPE, penType);
    doodleParamsObject.put(ProjectConstants.PEN_SIZE, penSize);
    doodleParamsObject.put(ProjectConstants.PEN_COLOR, penColor);
    doodleParamsObject.put(ProjectConstants.IS_STATIC, isStatic);

    JSONObject doodlePointsObject = new JSONObject();

    ArrayList<DoodleStrokeWrapper> strokeList = doodleParams.getDoodleStrokeList();
    for (DoodleStrokeWrapper stroke: strokeList){
        for (DoodlePointList point: stroke.getPointList()){
            
        }
    }

    int index = 0;

    for (DoodleStrokeWrapper stroke: strokeList) {
        DoodleStrokeWrapper stroke = strokeList.get(i);
        JSONArray strokePointsArray = new JSONArray();
        
        ArrayList<DoodlePointList> pointList = stroke.getPointList();
        for (DoodlePointList point : pointList) {
            JSONObject pointObject = new JSONObject();
            
            pointObject.put("x", point.getX());
            pointObject.put("y", point.getY());
            pointObject.put("tanx", point.getTanX());
            pointObject.put("tany", point.getTanY());
            pointObject.put("pressure", point.getPressure());
            pointObject.put("timestamp", point.getTimestamp());
            
            strokePointsArray.put(pointObject);
        }
        
        doodlePointsObject.put("stroke_" + index++, strokePointsArray);
    }

    doodleParamsObject.put(ProjectConstants.LIST_STROKE, doodlePointsObject);

