package strategy1.step4.modularization;

import strategy1.step4.inter.FlyNo;
import strategy1.step4.inter.IFly;
import strategy1.step4.inter.IKnife;
import strategy1.step4.inter.IMissile;
import strategy1.step4.inter.KnifeNo;
import strategy1.step4.inter.MissileNo;

public class LowRobot extends Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
}
