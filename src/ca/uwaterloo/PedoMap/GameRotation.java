package ca.uwaterloo.PedoMap;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import ca.uwaterloo.PedoMap.MainActivity.AccelerometerSensorEventListener;

class GameRotation implements SensorEventListener {
	TextView rotX, rotY, rotZ;		//output textviews
	public static double maxMagX, maxMagY, maxMagZ;		//store abs of magnetic sensor for each axis
	public static float azm;
	private float point1, point2;
	private int counter, frequency;
	private boolean point1Needed;
	private static float[] points = new float[10];
	
	public GameRotation(TextView xAxis, TextView yAxis, TextView zAxis) {
		rotX = xAxis;		//link output textviews with constructors
		rotY = yAxis;
		rotZ = zAxis;
		point1 = 0;
		point2 = 0;
		counter = 0;
		frequency = 2;
		point1Needed = false;
	}
	
	public void onAccuracyChanged(Sensor s, int i) {}
	
	public void onSensorChanged(SensorEvent se) {
		if (se.sensor.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR){
		
//			if (counter > points.length-1){
//				point1Needed = true;
//				counter = 0;
//			}
//			
//			points[counter] = se.values[2];
//			
//			if (counter % frequency == 0 && point1Needed){
//				point1 = se.values[2];
//				point1Needed = false;
//			}else if (counter % 10 == 0){
//				point2 = se.values[2];
//				point1Needed = true;
//			}
			
//			if (counter % points.length == 0 && point1Needed){
//				azm = avg(points);
//			    azm = (float) Math.PI * azm;
//				azm = (int)azm;
//			}
			
			AccelerometerSensorEventListener.magnetic = se.values;
			//display magnetic sensor data and max sensor values(formated)
			//rotX.setText("rot X-Axis: " + se.values[0] + "\n"); //+ "Max X: " + maxMagX);
			//rotY.setText("rot Y-Axis: " + se.values[1] + "\n");//+ "Max Y: " + maxMagY);
		    //rotZ.setText("rot Z-Axis: " + se.values[2] + "\n"); //+ "Max Z: " + maxMagZ + "\n");
			azm = se.values[2]*100;
//		    azm = (float) 180 * azm;
//			azm = (int)azm;
		    rotZ.setText("rot Z-Axis: " + azm + "\n"); //+ "Max Z: " + maxMagZ + "\n");
		}
	}
		
}
