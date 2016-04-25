package ca.uwaterloo.PedoMap;

import java.util.ArrayList;

import android.graphics.PointF;

public class 
public void recursivePath(PointF startPoint){
	PointF currentPoint = startPoint;
	PointF nextPoint;
	ArrayList<PointF> path = new ArrayList<PointF>();
	ArrayList<PointF> availablePoints = (ArrayList<PointF>)anchors.clone();
	path.add(startPoint);
	while (!availablePoints.isEmpty()){
		currentPoint = path.get(path.size() - 1);
		float min = 999999;
		nextPoint = null;
		for (PointF anchor : anchors){
			if (mv.calculateIntersections(currentPoint, mv.destPoint).isEmpty()){
				path.add(mv.destPoint);
				solution = path;
				mv.setUserPath(solution);
				return;
			}
			intercept = mv.calculateIntersections(currentPoint, anchor);
			if (intercept.isEmpty() & !path.contains(anchor)){
				float currentMin = distanceBetween(anchor, mv.destPoint);
				if (currentMin < min){
					nextPoint = anchor;
					min = currentMin;
					availablePoints.remove(anchor);
				}
			}
		}
		path.add(nextPoint);	
	}
	
	path.add(currentPoint);
	solution = path;
	mv.setUserPath(solution);
}