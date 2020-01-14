package com.tj.ex13_robot;
// RobotOrder order = new RobotOrder();
// Robot r = new SingRobot();
// order.actiong(r)
public class RobotOrder {

	public void action(Robot robot) {
		if(robot instanceof SingRobot) {
			SingRobot r = (SingRobot)robot;
			r.sing();
		}else if(robot instanceof DrawRobot) {
			DrawRobot r = (DrawRobot)robot;
			r.draw();
		}else if(robot instanceof DanceRobot) {
			DanceRobot r = (DanceRobot)robot;
			r.dance();
		}else {
			System.out.println("황장된 로봇이면 구현이 필요합니다.");
		}
	}
}
