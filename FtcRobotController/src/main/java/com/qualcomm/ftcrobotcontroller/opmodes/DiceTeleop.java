package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by DICE on 10/13/2015.
 */
public class DiceTeleop extends OpMode
{
    CommonRobotInfo robot = new CommonRobotInfo();
    DcMotor left;
    DcMotor right;
    DcMotor lift;
    DcMotor winch;
    double leftPower;
    double rightPower;

    public void init()
    {
        lift = robot.getLiftMotor();
        winch = robot.getWinchMotor();
        left = robot.getMotorLeft();
        right = robot.getMotorRight();
        left.setDirection(DcMotor.Direction.REVERSE);
    }

    public void loop()
    {
        leftPower = Range.clip(gamepad1.left_stick_y, -1, 1);
        rightPower = Range.clip(gamepad1.right_stick_y, -1, 1);

        left.setPower(leftPower);
        right.setPower(rightPower);
    }
}
